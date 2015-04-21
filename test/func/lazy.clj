(ns func.lazy
  (:use clojure.test)
  (:require [clojure.java.io :as io]))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Work with lazy sequences                                      ;
;                                                               ;
;---------------------------------------------------------------;

(def _ :changeme)

(defn count-lines []
  (with-open [r (io/reader "target/lazy.txt")]
    (count (line-seq r))))

(defn capitalize-all
  "Applies clojure.string/capitalize to all the elements in the input seq"
  [xs])

(deftest write-your-own
  (testing "Create a recursive function that can capitalize an infinite seq of names"
    (is (= 1000 (count (capitalize-all (repeat "clojure")))))))

(deftest common-pitfall
  (testing "Note: with-open automatically closes on exit. How do you fix this?"
    (try
      (let [write-to-file (fn []
                            (with-open [w (io/writer "target/lazy.txt")]
                              (map #(.write w (str % "\n")) ["one" "two" "three"])))]
        (write-to-file)
        (is (= 3 (count-lines))))
      (finally
        (io/delete-file "target/lazy.txt")))))
