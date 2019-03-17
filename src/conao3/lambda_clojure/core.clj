(ns conao3.lambda-clojure.core
  (:require [compojure.core :refer :all]
            [ring.util.response :as response :refer [response]]))

(defn hello-fn []
  (response {:message "Hello Function"}))

(defn hello-args [req]
  (response {:rest (print-str req)}))

(defroutes hello-routes
  (GET "/hello" _ (response {:message "Hello World"}))
  (GET "/hello-fn" _ hello-fn)
  (GET "/hello-args/:name" _ hello-args))
