(ns sketch-repo.prod
  (:require [sketch-repo.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
