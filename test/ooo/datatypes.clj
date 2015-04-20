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
