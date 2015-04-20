(ns ooo.multi
  (:use midje.sweet))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Datatypes can be used to have some OO style code               ;
;                                                                ;
;----------------------------------------------------------------;

(defmulti area
  "Calculates the area of a Shape"
  :type)

; Implement the methods that can calculate each areas
(fact "I can calculate the areas of different shapes"
      (area {:type :rectangle :width 4 :length 2}) => 8
      (area {:type :square :width 4})              => 16
      (area {:type :circle :radius 1})             => (roughly 3.14 0.01))

(defmulti animal-sound
  "Allows an animal to say something"
  :kind)

(defmethod animal-sound ::dog
  [this]
  (str (:name this) " barks"))

(defmethod animal-sound ::animal
  [this]
  (str (:name this) " emits a sound"))

(fact "Use derive to make the following test pass"
      (animal-sound {:type ::dog
                     :name "Fido"}) =>  "Fido barks"
      (animal-sound {:type ::cat
                     :name "Mr. Wiskers"}) => "Mr. Wiskers emits a sound")
