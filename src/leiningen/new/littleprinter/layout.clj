(ns {{name}}.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css)]))

(defn common [data & body]
  (html5
   [:head
    [:title (:title data) ]]
   [:body
    [:h1 body]]))
