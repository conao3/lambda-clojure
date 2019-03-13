(ns conao3.lambda-clojure.core
  (:require [ring.util.response :as response :refer [response]]))

(defn hellofn []
  (response {:message "Hello Function"}))
