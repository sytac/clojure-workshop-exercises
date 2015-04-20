(ns ooo.datatypes
  (:use midje.sweet))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Datatypes can be used to have some OO style code               ;
;                                                                ;
;----------------------------------------------------------------;

(defprotocol Shape
  (area [this] "Calculates the area of the shape")
  (perimeter [this] "Calculates the perimeter of the shape")
  (wider-than [this that] "Returns true if this has an area bigger than that, false otherwise"))

; Create a Rectangle and Square records that implements the Shape protocol and the Comparable interface
(unfinished ->Rectangle ->Square)

(fact "I can calculate the area of a Rectangle"
      (area (->Rectangle 4 2))        => 8
      (perimeter (->Rectangle 4 2))   => 14
      (area (->Square 4))             => 16
      (perimeter (->Square 4))        => 16
      (wider-than (->Square 4)
                  (->Rectangle 4 2))) => true

; Here is a protocol that implements a datastore
(defprotocol Store
  (put [this key data])
  (get [this key]))

; here's a set of functions that depend on the protocol
(defn checked-add
  "Accepts a store and a validation fn and it returns another function
   that can add an element to the store if it passes the validation"
  [store valid?]
  (fn [store key data]
    (if (valid? key data)
      (put store key data)
      false)))

(defn get-or-default
  "Accepts a default value and it returns another function
   that will try to fetch an element from the store, or return the default
   value if it's not found"
  [default]
  (fn [store key]
    (if-let [data (get store key)]
      data
      default)))

; implement a dummy store that will turn the following tests green
; use first a Record, then reify
(unfinished dummy-store)

(defn key-map-checker
  "Validator function that accepts a keyword as a key and a map as the data"
  [key data]
  (and (keyword? key)
       (map? data)))

(fact "Stores are made for storing"
      ((checked-add key-map-checker) dummy-store :key {})       => {:key   {}
                                                                    :store {:type :dummy}}
      ((checked-add key-map-checker) dummy-store :key :val)     => false
      ((get-or-default {:error :not-found}) dummy-store :store) => {:type :dummy}
      ((get-or-default {:error :not-found}) dummy-store :woot)  => {:error :not-found})
