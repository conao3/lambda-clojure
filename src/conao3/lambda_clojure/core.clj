(ns conao3.lambda-clojure.core
  (:require [compojure.core :refer :all]
            [ring.util.response :as response :refer [response]]))

(defn hello-fn []
  (response {:message "Hello Function"}))

(defn hello-args [req]
  (response {:rest (print-str req)}))

(defn hello-html [req]
  (-> (response "html")
      (response/content-type "text/html; charset=utf-8")))

(defroutes hello-routes
  (context "/hello" _
           (GET "/" _ (response {:message "Hello World"}))
           (GET "/fn" _ hello-fn)
           (GET "/args/:name" _ hello-args)
           (GET "/html" _ hello-html)))
