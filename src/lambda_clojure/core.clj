(ns lambda-clojure.core
  (:require [clojure.data.json :as json])
  (:gen-class
   :methods [^:static
             [json [Object] Object]
             ;; [hello-json-without-require [String] String]
             ]))

(defn hello-simple [event]
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body "hello world"
   })

(defn -json [event]
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
