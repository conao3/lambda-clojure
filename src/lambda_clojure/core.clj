(ns lambda-clojure.core
  (:require [clojure.data.json :as json])
  (:gen-class
   :methods [^:static
             [json [Object] Object]
             ^:static
             [json_without_require_snake [Object] Object]
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

(defn -jsonWithoutRequireCammel [event]
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body (json/write-str {:message "hello world"})
   })

(gen-class
 :name lambda_clojure.core
 :methods [[jsonWithoutRequireCammel [Object] Object]])

(defn json-without-require-snake [this event]
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body (json/write-str {:message "hello world"})
   })

(gen-class
 :name lambda_clojure.json_without_require
 :prefix json-without-require-
 :methods [[snake [Object] Object]])

(defn hello-json [event]
  (require '[clojure.data.json :as json])
  {'statusCode 200
   'headers {'content-type "application/json"}
   'body (json/write-str {:message "hello world"})
   })
