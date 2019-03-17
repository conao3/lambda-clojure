(ns conao3.lambda-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.util.response :as response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [conao3.lambda-clojure.core :refer [core-routes]]
            [conao3.lambda-clojure.hello :refer [hello-routes]]))

(defroutes app-routes
  hello-routes
  (route/not-found (response/not-found {:message "Not Found"})))

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-defaults api-defaults)))
