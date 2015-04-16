(ns intro.basic
  (:use clojure.test))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Basic exercises on Clojure datastructures: fill in the blanks ;
;                                                               ;
;---------------------------------------------------------------;

(deftest numbers
  (testing "I know how to work with numbers"
    (is (= 42  (_ 40 2)))
    (is (= 3/4 (_ _ _)))
    (is (= _   (Math/ceil (double 2/3))))))

(deftest strings
  (testing "I know how to manipulate strings"
    (is (= "foobar" (_ "foo" "bar")))
    (is (= _        (.toUpperCase "clojure")))))

(deftest collections
  (testing "Lists are for sequential access"
    (is (= _ (first '(1 2 3))))
    (is (= _ (nth '(1 2 3) 2))))
  (testing "Vectors are functions of their indexes"
    (is (= _ ([1 2 3] 0))))
  (testing "Maps are functions of their keys, and vice versa"
    (is (= _ ({:foo 1
               :bar 42} :foo)))
    (is (= _ (:foo {:foo 1
                    :bar 42})))))
