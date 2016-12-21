(defproject try-integrant "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [integrant "0.1.4"]
                 [aleph "0.4.2-alpha10"]]
  :main ^:skip-aot try-integrant.main
  :target-path "target/%s"
  :profiles {:dev {:source-paths ["dev"]}
             :uberjar {:aot :all}})
