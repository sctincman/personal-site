(ns sketch-repo.handler
  (:require [sketch-repo.sketch :as repo]
            [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found resources files]]
            [hiccup.page :refer [include-js include-css html5]]
            [sketch-repo.middleware :refer [wrap-middleware]]
            [config.core :refer [env]]))

(def sketch-parent "/home/tincman/sketch")

(defn sketch-list [path]
  [:ul
   (for [sketch (repo/list-sketches path)]
     (let [props (repo/sketch-info sketch)]
       [:li
        sketch
        [:img.thumbnail {:src (str "sketches/" (.getName sketch) "/" (get props :image))}]
        [:p (get props :theme)]
        [:p (get props :description)]]))])


(def mount-target
  [:div#app
      [:h3 "ClojureScript has not been compiled!"]
      [:p "please run "
       [:b "lein figwheel"]
       " in order to start the compiler"
       (sketch-list sketch-parent)]])

(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css (if (env :dev) "/css/site.css" "/css/site.min.css"))])

(defn loading-page []
  (html5
    (head)
    [:body {:class "body-container"}
     mount-target
     (include-js "/js/app.js")]))


(defroutes routes
  (GET "/" [] (loading-page))
  (GET "/about" [] (loading-page))

  (files "/sketches" {:root sketch-parent})
  (resources "/")
  (not-found "Not Found"))

(def app (wrap-middleware #'routes))
