(ns adventofcode.day2.b
  (:require [adventofcode.utils :refer :all]
            [clojure.string :as s]))

(defn- shape->points
  [shape]
  (case shape
    "A" 1
    "B" 2
    "C" 3))

(defn- get-shape
  [opponent outcome]
  (case opponent
    "A" (case outcome
          "X" "C"
          "Y" "A"
          "Z" "B")
    "B" (case outcome
          "X" "A"
          "Y" "B"
          "Z" "C")
    "C" (case outcome
          "X" "B"
          "Y" "C"
          "Z" "A")))

(defn- round-outcome->points
  [outcome]
  (case outcome
    "X" 0
    "Y" 3
    "Z" 6))

(defn- calculate-round
  [round]
  (let [[a b] (s/split round #" ")
        shape (get-shape a b)
        shape-points (shape->points shape) 
        round-result (round-outcome->points b)]
    (+ shape-points round-result)))

(defn main
  []
  (let [input (read-lines "day2.txt")]
    (->> input
          (map calculate-round)
          (apply +))))
