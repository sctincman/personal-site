(ns sketch-repo.core
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [sketch-repo.views :as view]))

;; -------------------------
;; Routes

(def page (atom #'view/landing-page))

(defn current-page []
  [:div
   view/nav-bar
   [@page]
   [:p "Reagent HAS been started"]])

(secretary/defroute "/" []
  (reset! page #'view/landing-page))

(secretary/defroute "/about" []
  (reset! page #'view/about-page))

(secretary/defroute "/sketches" []
  (reset! page #'view/sketch-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (let [mount-point (.getElementById js/document "app")]
    (reagent/render [current-page] mount-point)))

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
