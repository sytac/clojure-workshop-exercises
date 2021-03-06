(ns intro.fun
  (use clojure.test))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Functions are at the core of Clojure. Can you master them?    ;
;                                                               ;
;---------------------------------------------------------------;

(def _ :changeme)

; functions can have docstrings
(defn increment-all
  "Takes a sequence of numbers and returns another sequence with all values
   incremented by one"
  [xs]
  _)

(defn remove-odds
  "Takes a sequence of numbers and returns another sequence of all the even
   numbers"
  [xs]
  _)

(defn apply-twice
  "Takes a function of one argument f(x) and returns a function g so that
   g(x) = f(f(x))"
  [f]
  _)

(defn apply-implicit-first
  "Takes a function of two arguments f(x, y) and a value x and returns a
   function g so that g(y) = f(x, y)"
  [f x]
  _)

(deftest basic-functions
  (testing "Write the body of the above functions so that they fulfill the tests"
    (are [expected result] (= expected result)
         [2 3 4 5] (increment-all [1 2 3 4])
         [2 4]     (remove-odds [1 2 3 4])
         4         ((apply-twice inc) 2)
         42        ((apply-implicit-first + 5) 37)))
  (testing "Let's imagine that Clojure didn't have a let form. Use functions to emulate its behavior"
    (is (= (let [a 12
                 b 30]
             (+ a b))
           _))))

(deftest seq-processing-functions
  (testing "Explore the power of the Clojure standard library"
    (is (= ["1" "2" "3"] (map _ [1 2 3])))
    (is (= _ (filter odd? [1 2 3])))
    (is (= _ (apply + [1 2 3])))
    (is (= _ (let [sum-of-chars _]
               (reduce sum-of-chars ["one" "two" "three"])))))
  (testing "Write a function that returns the indexes of the elements with an odd size"
    (is (= [1 2 3] (let [odd-indexes _]
                     (odd-indexes ["one" "two" "three" "four"]))))))
