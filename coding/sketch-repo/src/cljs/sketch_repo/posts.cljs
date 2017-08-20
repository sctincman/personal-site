(ns sketch-repo.posts
  (:require [reagent.core :as reagent]
            [ajax.core :refer [GET POST]]))

(defn post?
  [path]
  true)

(defonce post-list (reagent/atom []))

(defn handle-response [response]
  (reset! post-list
          (reverse (sort-by :created response))))

(defn error-response [response]
  (println "/api/post failed"))

(defn fetch-posts []
  (GET "/api/posts"
       {:handler handle-response
        :error-handler error-response
        :response-format :json
        :keywords? true}))

;; Initialize
(fetch-posts)

(defn posts []
  @post-list)


