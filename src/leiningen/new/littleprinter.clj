(ns leiningen.new.littleprinter
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "littleprinter"))

(defn check-lein-version []
  (if (< (lein-generation) 2)
    (throw (new Exception "Come on man, upgrade to Leiningen v2…"))))

(defn littleprinter
  "Create a new LittlePrinter publication!"
  [name]
  (check-lein-version)
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating a rad new LittlePrinter publication named" (str name "..."))
    (->files data
             [".gitignore" (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["static/meta.json" (render "meta.json" data)]
             ["static/images/icon.png" (render "icon.png")]
             ["static/css/style.css" (render "style.css")]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)])))
