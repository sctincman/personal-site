(ns sketch-repo.middleware
  (:require [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defn wrap-middleware [handler]
  (-> handler
      (wrap-defaults site-defaults)
      wrap-json-response
      wrap-json-body
      wrap-exceptions
      wrap-reload))
