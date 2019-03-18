(ns conao3.lambda-clojure.core
  (:require [compojure.core :refer :all]
            [clojure.string :as string]
            [ring.util.response :as response :refer [response]]
            [dali.io :as io]
            [dali.batik :as batik]))

(defn github-svg [{:keys [str forground background]
                   :or {str "Unknown" forground "FFF" background "222"}}]
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
        (format background forground str)))

(defn header [{:keys [params]}]
  (-> (github-svg params)
      (response)
      (response/content-type "image/svg+xml; charset=utf-8")))

(defn header-png [{:keys [params]}]
  (-> (github-svg params)
      (batik/parse-svg-string)
      (batik/render-document-to-png "/tmp/hello-world.png" {}))
  (-> (slurp "/tmp/hello-world.png")
      (response)
      (response/content-type "image/png")))

(defroutes core-routes
  (GET "/header/:str.svg" _ header)
  (GET "/header/:str.png" _ header-png))
