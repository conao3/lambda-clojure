(defproject lambda-clojure "0.1.0"
  :description "conao's helper API working on AWS Lambda"
  :url "http://github.com/conao3/lambda-clojure"
  :license {:name "AGPLv3"
            :url "https://www.gnu.org/licenses/agpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.json "0.2.6"]
                 [com.amazonaws/aws-lambda-java-core "1.0.0"]]
  :repl-options {:init-ns lambda-clojure.core}
  :java-source-paths ["src/java"]
  :aot :all)
