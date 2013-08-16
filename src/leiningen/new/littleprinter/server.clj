(ns {{name}}.server
  (:use compojure.core
        ring.middleware.etag.core :only [with-etag create-hashed-etag-fn md5]
        ring.util.response :only [response]
        ring.adapter.jetty :only [run-jetty]
        clojure.java.io :only [file])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
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
