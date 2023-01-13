(ns adventofcode.day4.a
  (:require [adventofcode.utils :refer :all]
            [clojure.string :as s]))

(defn- range->list
  [range]
  (->> (s/split range #"-")
       (map #(Integer/parseInt %))))

(defn- line->ranges
  [line]
  (as-> line $
    (s/split $ #",")
    (map range->list $)))

(defn- overlapping?
  [[[a b] [c d]]]
  (or (and (>= c a)
           (<= d b))
      (and (>= a c)
           (<= b d))))

(defn main
  []
  (let [input (read-lines "day4.txt")]
    (->> input
         (map line->ranges)
         (filter overlapping?)
         count)))

