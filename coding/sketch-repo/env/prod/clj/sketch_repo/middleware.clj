(ns sketch-repo.middleware
  (:require [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defn wrap-middleware [handler]
  (-> handler
      (wrap-defaults site-defaults)
      wrap-json-response
      wrap-json-body))
