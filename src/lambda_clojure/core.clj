(ns lambda-clojure.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn hello [event]
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body "hello world"
   })

(defn hello-json [event]
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body (json/write-str {'message "hello world"})
   })
