(ns adventofcode.day4.b
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
  [[[a b] [x y]]]
  (not (or (< b x)
           (> a y))))

(defn main
  []
  (let [input (read-lines "day4.txt")]
    (->> input
         (map line->ranges)
         (filter overlapping?)
         count)))

