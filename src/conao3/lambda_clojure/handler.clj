(ns conao3.lambda-clojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.util.response :as response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [conao3.lambda-clojure.core :as lc-core]))

(defroutes app-routes
  (GET "/" _ (response {:apis (print-str ["hello" "hello-fn" "hello-args/:name"])}))
  (GET "/hello" _ (response {:message "Hello World"}))
  (GET "/hello-fn" _ lc-core/hello-fn)
  (GET "/hello-args/:name" _ lc-core/hello-args)
  (route/not-found (response/not-found {:message "Not Found"})))

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-defaults api-defaults)))
