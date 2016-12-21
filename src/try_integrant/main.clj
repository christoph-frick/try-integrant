(ns try-integrant.main
  (:require [try-integrant.core :refer [start-system! stop-system!]])
  (:gen-class))

(defn -main
  [& args]
  (start-system!)
  (.addShutdownHook (Runtime/getRuntime) (Thread. stop-system!))
  (.join (Thread/currentThread)))

