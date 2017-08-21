(ns sketch-repo.posts
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.tools.reader.edn :as edn]
            [clojure.data.json :as json]
            [hawk.core :as hawk]
            [config.core :refer [env]]))

(def posts-directory
  (if (some? (env :posts-directory))
    (env :posts-directory)
    "."))

;; ...can be better I suppose
(defn post?
  "Are the basic sketch components present?"
  [path]
  (let [file (io/as-file path)]
    (and (.isFile file)
         (not (.isHidden file))
         (str/ends-with? (str/lower-case (.getName file)) ".json"))))

(defn- list-posts
  ([]
   (list-posts posts-directory))
  ([dir]
   (filter post? (file-seq (io/as-file dir)))))

(defn- get-post
  [path]
  (when (post? path)
    (let [post (json/read-str (slurp path)
                              :key-fn keyword)]
      (cond
        (vector? post) post
        (map? post) [post]
        :else [post]))))

(def post-list (atom (reverse
                      (sort-by :created
                               (mapcat get-post (list-posts))))))

(hawk/watch! [{:paths [posts-directory]
               :handler (fn [ctx e]
                          (reset! post-list
                                 (reverse
                                  (sort-by :created
                                           (mapcat get-post (list-posts)))))
                          ctx)}])

(defn posts []
  @post-list)
