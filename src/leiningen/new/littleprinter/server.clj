(ns {{name}}.server
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.etag.core :refer [with-etag create-hashed-etag-fn md5]]
            [ring.util.response :refer [response]]
            [ring.adapter.jetty :refer [run-jetty]]
            [clojure.java.io :refer [file]]
            [{{name}}.views.edition :as edition]))

(defroutes app-routes
  (GET "/meta.json" []
       (response (file "static/meta.json")))
  (GET "/icon.png" []
       (response (file "static/images/ribbon.png")))
  (GET "/sample" []
       (edition/edition {:title "{{name}}"}))
  (GET "/edition" [data]
       (edition/edition {:title data}))
  (route/files "/" {:root "static"})
  (route/not-found "Not found"))

(def app
  (->
   (handler/site app-routes)
   (with-etag {:etag-generator (create-hashed-etag-fn md5)})))


(defn -main []
  (run-jetty #'app {:port 3000 :join? false}))