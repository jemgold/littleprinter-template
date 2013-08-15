(ns leiningen.new.littleprinter
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "littleprinter"))

(defn littleprinter
  "Create a new LittlePrinter publication!"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating a rad new LittlePrinter publication named" (str name "..."))
    (->files data
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["static/meta.json" (render "meta.json" data)]
             ["static/css/style.css" (render "style.css")]
             ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
             ["src/{{sanitized}}/views/layout.clj" (render "layout.clj" data)]
             ["src/{{sanitized}}/views/edition.clj" (render "edition.clj" data)])))
