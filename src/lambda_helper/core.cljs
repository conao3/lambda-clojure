;; Copyright (C) 2019 Naoya Yamashita (conao3)

;; Author: Naoya Yamashita (conao3)

;; This program is free software: you can redistribute it and/or modify it
;; under the terms of the Affero GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or (at your
;; option) any later version.
;;
;; This program is distributed in the hope that it will be useful, but WITHOUT
;; ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
;; FITNESS FOR A PARTICULAR PURPOSE.  See the Affero GNU General Public
;; License for more details.
;;
;; You should have received a copy of the Affero GNU General Public License
;; along with this program.  If not, see <https://www.gnu.org/licenses/>.

(ns lambda-helper.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-lambda.macros :refer-macros [defgateway]]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            ;; [clj-http.client :as client]
            ))

(require '[clj-http.client :as client])

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

(defgateway hello-inspect-query [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js event))}))

(defgateway hello-inspect-post [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js event))}))

(defgateway hello-get [event ctx]
  (let [name (get-in event [:query :name])]
    {:status 200
     :headers {:content-type "application/json"}
     :body (JSON/stringify (clj->js (http/get "https://shields.redsparr0w.com/2473/monday" {:accept :json})))}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;  microbadger functions
;;
