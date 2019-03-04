(ns lambda-clojure.core
  (:gen-class
   :name lambdaClojure
   :methods [^:static [handler [String] String]]))

(defn -handler [s]
  (str "Hello " s "!"))

; Add POJO handling

(defn -handlepojo [this event]
  (str "Hello " (.getFirstName event) " " (.getLastName event)))

(gen-class
  :name PojoHandler
  :methods [[handlepojo [example.MyEvent] String]])

;;

(defn simple-lambda [event]
  ;; "{ \"headers\": { \"content-type\": null },\"body\": \"hello world\",\"statusCode\": 200 }"
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body "hello world"
   })

(defn simple-lambda-body [event]
  ;; "{ \"headers\": { \"content-type\": null },\"body\": \"hello world\",\"statusCode\": 200 }"
  {'statusCode 200
   'headers {'content-type (-> event :headers :content-type)}
   'body (JSON/stringify {'message "hello world"})
   })
