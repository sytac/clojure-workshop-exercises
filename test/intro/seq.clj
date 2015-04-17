(ns intro.seq
  (:use clojure.test)
  (:require [clojure.set :as s]))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Test drive your understanding of Clojure collection types     ;
;                                                               ;
;---------------------------------------------------------------;

(def _ :changeme)

(deftest working-on-maps
  (testing "I can get stuff out of maps"
    (is (= "booya!" (_ {:say-what "booya!"})))
    (is (= "booya!" ({:say-what "booya!"} _)))
    (is (= "booya!" (get {:say-what "booya"} _)))
    (is (= "booya!" (get {:say-what "booya"} _ "booya!")))))

(deftest all-about-sequences
 (testing "Functions that accept sequences work on all collections"
   (is (= _ (= [2 3] '(2 3))))

   ; Extract the first element of a collection
   (is (= _ (first [:a :b :c])))
   (is (= _ (first '(:a :b :c))))

   ; Keep all but the first element
   (is (= _ (rest [:a :b :c])))

   ; remember: maps are sequences of key/value pairs
   (is (= _ (seq {:a "apple"
                  :b "banana"})))
   (is (= _ (s/union #{:a :b} #{:c}))))

 (testing "Conjoin adds an element into a sequence."
   ; vectors grow at the end
   (is (= _ (conj [:a :b] :c)))

   ; lists grow at the head
   (is (= _ (conj '(2 3) 1))))

 (testing "Put elements into a collection"
   (is (= _ (into [] '(1 2 3))))))
