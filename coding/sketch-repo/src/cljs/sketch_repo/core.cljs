(ns sketch-repo.core
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [hickory.core :as hickory]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to sketch-repo"]
   [:div [:a {:href "/about"} "go to about page"]]])

(defn about-page []
  [:div [:h2 "About sketch-repo"]
   [:div [:a {:href "/"} "go to the home page"]]])

;; -------------------------
;; Routes

(def page (atom #'home-page))

(defn current-page [template]
  (let [fragment (hickory/parse-fragment template)
        hicfrag (map #(with-meta (hickory/as-hiccup %2) {:key %1})
                     (range (count fragment))
                     fragment)]
    (fn [template]
      [:div [@page]
       hicfrag
       [:p "Reagent HAS been started"]])))

(secretary/defroute "/" []
  (reset! page #'home-page))

(secretary/defroute "/about" []
  (reset! page #'about-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (let [mount-point (.getElementById js/document "app")
        content (.-innerHTML mount-point)]
    (reagent/render [current-page content] mount-point)))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
