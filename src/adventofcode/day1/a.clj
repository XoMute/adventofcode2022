(ns adventofcode.day1.a
  (:require [adventofcode.utils :refer :all]))

(defn- sum-calories
  [xs]
  (->> xs
       (map #(Integer/parseInt %))
       (apply +)))

(defn main
  []
  (let [input (read-lines "day1.txt")]
    (->> input
         (partition-by empty?)
         (filter #(not (empty? (first %))))
         (map sum-calories)
         (sort >)
         (first))))
