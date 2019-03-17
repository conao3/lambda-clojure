(ns conao3.lambda-clojure.core
  (:require [ring.util.response :as response :refer [response]]))

(defn hello-fn []
  (response {:message "Hello Function"}))

(defn hello-args ;; [name role & rest]
  [req]
  (response {;; :name name
             ;; :role role
             :x x
             :rest (print-str req)}))










