(ns sketch-repo.posts
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.tools.reader.edn :as edn]
            [clojure.data.json :as json]
            [hawk.core :as hawk]
            [config.core :refer [env]]
            [hiccup.util :refer [escape-html]]
            [markdown.core :as md]
            [hickory.core :as hickory
             ]))

(def posts-directory
  (if (some? (env :posts-directory))
    (env :posts-directory)
    "."))

(defn post-file?
  [path]
  (let [file (io/as-file path)]
    (and (.isFile file)
         (not (.isHidden file))
         (str/ends-with? (str/lower-case (.getName file)) ".json"))))

(defn post?
  [post]
  (some?
   (and (get post :title)
        (get post :created)
        (get post :content))))

(defn- list-post-files
  ([]
   (list-post-files posts-directory))
  ([dir]
   (filter post-file? (file-seq (io/as-file dir)))))

(defn- parse-md
  [md-string]
  (conj
   (->> md-string
        (escape-html)
        (md/md-to-html-string)
        (hickory/parse-fragment)
        (map hickory/as-hiccup))
   :div))

(defn- parse-json
  [key value]
  (condp = key
    :title (parse-md value)
    :content (parse-md value)
    value))

(defn- read-post-file
  [path]
  (let [post
        (try
          (json/read-str (slurp path)
                         :key-fn keyword
                         :value-fn parse-json)
          (catch Exception e
            (println "exception")
            nil))]
    (cond
      (vector? post) post
      (map? post) [post]
      :else [post])))

(defn- load-posts
  []
  (->> (list-post-files)
       (mapcat read-post-file)
       (filter post?)
       (sort-by :created)
       (reverse)))

(def post-list (atom (load-posts)))

(hawk/watch! [{:paths [posts-directory]
               :handler (fn [ctx e]
                          (reset! post-list
                                 (load-posts))
                          ctx)}])

(defn posts []
  @post-list)
