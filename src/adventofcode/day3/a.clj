(ns adventofcode.day3.a
  (:require [adventofcode.utils :refer :all]
            [clojure.string :as s]))

(defn- string->sets
  [s]
  (->> (partition (/ (count s) 2) s)
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
         (map string->sets)
         (map #(apply clojure.set/intersection %))
         (map set->priority)
         (apply +))))

