(ns adventofcode.day3.b
  (:require [adventofcode.utils :refer :all]
            [clojure.string :as s]))

(defn- group->sets
  [xs]
  (->> xs
       (map #(into #{} %))))

(defn- item-type->priority
  [^java.lang.Character t]
  (cond
    (Character/isLowerCase t) (-> (- (int t) (int \a))
                                  (+ 1))
    (Character/isUpperCase t) (-> (- (int t) (int \A))
                                  (+ 27))))

(defn- set->priority
  [s]
  (->> s
       (map item-type->priority)
       (apply +)))

(defn main
  []
  (let [input (read-lines "day3.txt")]
    (->> input
         (partition 3)
         (map group->sets)
         (map #(apply clojure.set/intersection %))
         (map set->priority)
         (apply +))))

