(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh]]
            [try-integrant.core :as c]))

(defn start!
  []
  (let [config (c/load-default-config)]
    ; add dev specific things either here, or relay on another config file
    (c/start-system! config)))

(defn stop!
  []
  (when c/system
    (c/stop-system!)))

(defn reload!
  []
  (stop!) 
  (refresh :after 'user/start!))
