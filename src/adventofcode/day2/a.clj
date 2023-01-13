(ns adventofcode.day2.a
  (:require [adventofcode.utils :refer :all]
            [clojure.string :as s]))

(defn- shape->points
  [shape]
  (case shape
    "X" 1
    "Y" 2
    "Z" 3))

(defn- round-outcome
  [a b]
  (case a
    "A" (case b
          "X" 3
          "Y" 6
          "Z" 0)
    "B" (case b
          "X" 0
          "Y" 3
          "Z" 6)
    "C" (case b
          "X" 6
          "Y" 0
          "Z" 3)))

(defn- calculate-round
  [round]
  (let [[a b] (s/split round #" ")
        shape (shape->points b) 
        round-result (round-outcome a b)]
    (+ shape round-result)))

(defn main
  []
  (let [input (read-lines "day2.txt")]
    (->> input
          (map calculate-round)
          (apply +))))

