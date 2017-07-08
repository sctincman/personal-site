(ns ^:figwheel-no-load sketch-repo.dev
  (:require
    [sketch-repo.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
