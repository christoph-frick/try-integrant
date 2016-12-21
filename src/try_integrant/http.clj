(ns try-integrant.http
  (:require [aleph.http :as http]
            [integrant.core :as ig]))

(defmethod ig/init-key :try-integrant/http
  [_ {:keys [response] :as opts}]
  (http/start-server (constantly response) opts))

(defmethod ig/halt-key! :try-integrant/http
  [_ server]
  (.close server))
