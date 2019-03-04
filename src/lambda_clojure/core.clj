(ns lambda-clojure.core
  (:gen-class))

(defn simple-lambda [event]
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body "hello world"
   })

(defn simple-lambda-body [event]
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body (JSON/stringify {'message "hello world"})
   })
