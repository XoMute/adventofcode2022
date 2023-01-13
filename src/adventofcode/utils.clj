(ns adventofcode.utils
  (:require [clojure.string :refer [split]]
            [clojure.java.io :as io]))

(defn read-lines
  [file]
  (-> file
      io/resource
      slurp
      (split #"\n")))
