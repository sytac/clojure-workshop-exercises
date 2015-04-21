(defproject clojure-workshop "0.1.0-SNAPSHOT"
  :description "Code exercise for the Sytac Clojure Workshop"
  :url "http://www.sytac.nl"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/core.typed "0.2.84"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]
                                  [org.clojure/data.csv "0.1.2"]
                                  [org.clojure/tools.trace "0.7.8"]]
                   :plugins [[lein-midje "3.1.3"]]}})
