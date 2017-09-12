(ns sketch-repo.handler
  (:require [sketch-repo.sketch :as repo]
            [sketch-repo.posts :as posts]
            [compojure.core :refer [GET defroutes context]]
            [compojure.route :refer [not-found resources files]]
            [hiccup.page :refer [include-js include-css html5]]
            [sketch-repo.middleware :refer [wrap-middleware]]
            [ring.util.response]
            [markdown.core :as md]
            [config.core :refer [env]]
            [sketch-repo.views :as view]))

(def sketch-directory
  (if (some? (env :sketch-directory))
    (env :sketch-directory)
    "."))

(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css (if (env :dev) "/css/site.css" "/css/site.min.css"))
   (include-css (if (env :dev)
                  "/font-awesome-4.7.0/css/font-awesome.css"
                  "/font-awesome-4.7.0/css/font-awesome.min.css"))])

(defn wrap-page [content]
  (html5
   (head)
   [:body {:class "body-container"}
    [:div#app
     view/nav-bar
     content
     [:p.status "ClojureScript has not been compiled! please run " [:b "lein figwheel"] " in order to start the compiler"]]
    (include-js "/js/app.js")]))


(defroutes routes
  (GET "/" [] (wrap-page (view/landing-page)))
  (GET "/about" [] (wrap-page (view/about-page)))
  (GET "/sketches" [] (wrap-page (view/sketch-page)))
  (GET "/sketches/:sketch/:name.md" [sketch name]
       (md/md-to-html-string (slurp (str sketch-directory "/" sketch "/" name ".md"))))

  (context "/api" []
           (GET "/sketches" [] (ring.util.response/content-type
                                (ring.util.response/response (repo/sketches))
                                "application/json"))
           (GET "/posts" [] (ring.util.response/content-type
                                (ring.util.response/response (posts/posts))
                                "application/json"))
           (when (env :dev)
             (GET "/cp" [] (map (fn [x] (.toString x))
                                (seq (.getURLs (java.lang.ClassLoader/getSystemClassLoader)))))))

  (files "/assets" {:root (str posts/posts-directory "/assets")})
  (files "/sketches" {:root sketch-directory})
  (resources "/")
  (not-found "Not Found"))

(def app (wrap-middleware #'routes))
