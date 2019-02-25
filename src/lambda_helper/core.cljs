(ns lambda-helper.core
  (:require [cljs-lambda.macros :refer-macros [defgateway]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;  hello functions
;;

(defgateway echo [event ctx]
  {:status  200
   :headers {:content-type (-> event :headers :content-type)}
   :body    (event :body)})

(defgateway hello [event ctx]
  {:status 200
   :headers {:content-type (-> event :headers :content-type)}
   :body "hello world"})

(defgateway hello-query [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js {:hello (or name "world")}))}))

(defgateway hello-inspect [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js event))}))

(defgateway hello-inspect-post [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js event))}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;  microbadger functions
;;
