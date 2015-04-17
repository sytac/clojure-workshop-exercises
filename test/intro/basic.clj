(ns intro.basic
  (:use clojure.test))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Basic exercises on Clojure datastructures: fill in the blanks ;
;                                                               ;
;---------------------------------------------------------------;

(def _ :changeme)

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

(deftest truthiness
  (testing "Most of the things are truthy, except when they're falsey!"
    (are [value expected] (= expected (boolean value))
          1     _
          :a    _
          "b"   _
          []    _
          {}    _
          ()    _
          nil   _
          true  _
          false _)))

(deftest side-effects
  (testing "A do expression disregards all values except the last: only useful for side effects"
    (is (= _ (do
               (println "println always returns nil")
               42)))))
