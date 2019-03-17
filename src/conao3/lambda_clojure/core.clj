(ns conao3.lambda-clojure.core
  (:require [compojure.core :refer :all]
            [clojure.string :as string]
            [ring.util.response :as response :refer [response]]))

(defn header [{:keys [params]}]
  (let [{:keys [str forground background]
         :or {str "Unknown" forground "FFF" background "222"}}
        params]
    (-> (string/join
         "\n" ["<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"1000\" height=\"170\">"
               "<style xmlns=\"http://www.w3.org/2000/svg\" type=\"text/css\">"
               "@import url('https://fonts.googleapis.com/css?family=Sarabun:100');"
               "text {font-size: 70px; font-family: 'Sarabun', sans-serif; font-weight: 100;}"
               "</style>"
               "<g>"
               "<rect x=\"0\" y=\"0\" width=\"100%%\" height=\"100%%\" fill=\"#%s\"></rect>"
               "</g>"
               "<g fill=\"#%s\">"
               "<text x=\"90\" y=\"120\">%s</text>"
               "</g>"
               "</svg>"])
        (format background forground str)
        (response)
        (response/content-type "image/svg+xml; charset=utf-8"))))

(defroutes core-routes
  (GET "/header/:str.svg" _ header))
