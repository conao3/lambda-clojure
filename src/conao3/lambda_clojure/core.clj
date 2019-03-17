(ns conao3.lambda-clojure.core
  (:require [ring.util.response :as response :refer [response]]))

(defn hello-fn []
  (response {:message "Hello Function"}))

(defn hello-args [req]
  (response {:rest (print-str req)}))










