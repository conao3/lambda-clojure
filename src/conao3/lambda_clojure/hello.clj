(ns conao3.lambda-clojure.hello
  (:require [compojure.core :refer :all]
            [clojure.string :as string]
            [ring.util.response :as response :refer [response]]))

(defn hello-fn []
  (response {:message "Hello Function"}))

(defn hello-args [req]
  (response {:rest (print-str req)}))

(defn hello-html [req]
  (-> (response "html")
      (response/content-type "text/html; charset=utf-8")))

(defn hello-svg [req]
  (-> (string/join
       "\n" ["<?xml version=\"1.0\"?>"
             "<svg xmlns=\"http://www.w3.org/2000/svg\">"
             "  <rect x=\"0\" y=\"0\" width=\"100\" height=\"60\" fill=\"#ddd\" />"
             "  <polygon points=\"50 10, 70 30, 50 50, 30 30\" fill=\"#99f\" />"
             "</svg>"])
      (response)
      (response/content-type "image/svg+xml; charset=utf-8")))

(defroutes hello-routes
  (context "/hello" _
           (GET "/" _ (response {:message "Hello World"}))
           (GET "/fn" _ hello-fn)
           (GET "/args/:name" _ hello-args)
           (GET "/html" _ hello-html)
           (GET "/svg" _ hello-svg)))
