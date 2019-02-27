(defproject lambda-helper "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure       "1.9.0"]
                 [org.clojure/clojurescript "1.10.312"]
                 [io.nervous/cljs-lambda    "0.3.5"]
                 ;; [clj-http "3.9.1"]
                 [cljs-http "0.1.46"]]
  :plugins [[lein-npm                    "0.6.2"]
            [io.nervous/lein-cljs-lambda "0.6.6"]
            [lein-figwheel "0.5.18"]]
  :npm {:dependencies [[serverless-cljs-plugin "0.1.2"]]}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main lambda-helper.core
                                   :output-to     "target/lambda-helper/lambda_helper.js"
                                   :output-dir    "target/lambda-helper"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map-timestamp true}}]}
  :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.18"]
                                  [com.cemerick/piggieback "0.2.2"]]
                   :source-paths ["src" "dev"]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
  :cljs-lambda {:compiler
                {:inputs  ["src"]
                 :options {:output-to     "target/lambda-helper/lambda_helper.js"
                           :output-dir    "target/lambda-helper"
                           :target        :nodejs
                           :language-in   :ecmascript5
                           :optimizations :simple}}})
