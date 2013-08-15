(ns {{name}}.views.edition
  (:use [hiccup.core :only (h)])
  (:require [{{name}}.views.layout :as layout]))

(defn edition [data]
  (layout/common data
                 [:h1 (:title data) ]))