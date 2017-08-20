(ns sketch-repo.sketch
  (:require [reagent.core :as reagent]
            [ajax.core :refer [GET POST]]))

(defn sketch?
  "Are the basic sketch components present?"
  [directory]
  true)

(defn list-sketches []
  ["a " "list" " of " "sketches"])

(defn sketch-info
  "Given a sketch's directory, return map describing the sketch. Fields :image path to image. :theme name of theme. :description short description. :link link to sketch."
  [directory]
  {:path "path"
   :index "index.html"
   :title "placeholder"
   :image "image.png"
   :theme "THEME"
   :description (str "description: " directory)})

(defonce sketch-list (reagent/atom []))

(defn handle-response [response]
  (reset! sketch-list response))

(defn error-response [response]
  (println "/api/requests failed"))

(defn fetch-sketches []
  (GET "/api/sketches"
       {:handler handle-response
        :error-handler error-response
        :response-format :json
        :keywords? true}))

;; Initialize
(fetch-sketches)

(defn sketches []
  @sketch-list)


