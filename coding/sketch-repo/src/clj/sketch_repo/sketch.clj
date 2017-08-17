(ns sketch-repo.sketch
  (:require [clojure.java.io :as io]
            [clojure.tools.reader.edn :as edn]
            [config.core :refer [env]]))

(def sketch-directory
  (if (some? (env :sketch-directory))
    (env :sketch-directory)
    "."))

(defn sketch?
  "Are the basic sketch components present?"
  [directory]
  (let [dir (io/as-file directory)]
    (and (.isDirectory dir)
         (some #(= "props.clj" (.getName %)) (seq (.listFiles dir))))))

(defn list-sketches
  ([]
   (list-sketches sketch-directory))
  ([dir]
   (filter sketch? (file-seq (io/as-file dir)))))

(defn sketch-info
  "Given a sketch's directory, return map describing the sketch. Fields :image path to image. :theme name of theme. :description short description. :link link to sketch."
  [directory]
  (let [dir (io/as-file directory)]
    (when (sketch? directory)
      (-> (edn/read-string (slurp (some #(when (= "props.clj" (.getName %)) %)
                                        (seq (.listFiles dir)))))
          (assoc :path (.getName dir))
          (update :index (fn [index]
                           (if (some? index)
                             index
                             "index.html")))))))

(defn sketches
  []
  (map sketch-info (list-sketches)))
