(ns func.transform
  (:use clojure.test))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Apply a functional style to the following problems            ;
;                                                               ;
;---------------------------------------------------------------;

(def _ :changeme)

(deftest simple-transforms
  (testing "Find the sum of the columns of the given matrix"
    (is (= [12 15 18] (let [matrix [[1 2 3]
                                    [4 5 6]
                                    [7 8 9]]
                            columns-sum _])))))
