(ns try-integrant.core
  (:require [integrant.core :as ig]
            [clojure.java.io :as io]))

(def system nil)

(defn load-config
  [resource-name]
  (ig/read-string (slurp (io/resource resource-name))))

(defn load-default-config
  []
  (load-config "system.edn"))

(defn start-system
  ([]
   (start-system (load-default-config)))
  ([config]
   (ig/load-namespaces config)
   (ig/init config)))

(defn start-system!
  ([]
   (start-system! (load-default-config)))
  ([config]
   (alter-var-root #'system (fn [_] (start-system config)))))

(defn stop-system
  [system]
  (ig/halt! system)
  nil)

(defn stop-system!
  []
  (alter-var-root #'system stop-system))
