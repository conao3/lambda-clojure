(ns lambda-clojure.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn hello-simple [event]
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body "hello world"
   })

(defn hello-json-without-require [event]
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body (json/write-str {:message "hello world"})
   })

(defn hello-json [event]
  (require '[clojure.data.json :as json])
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body (json/write-str {:message "hello world"})
   })
