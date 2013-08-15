(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring/ring-core "1.1.8"]
                 [ring/ring-jetty-adapter "1.1.8"]
                 [ring.middleware.etag "1.0.0-SNAPSHOT"]
                 [hiccup "1.0.4"]]
  :plugins [[lein-ring "0.8.6"]
            [lein-heroku-deploy "0.1.0"]]
  :main {{name}}.server
  :ring {:auto-refresh? true
         :handler {{name}}.server/app}
  :resources-path "static"
  :profiles {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :heroku {
            :app-name "FIXME"
            :app-url "FIXME"})
