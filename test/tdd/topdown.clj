(ns tdd.topdown
  (:use midje.sweet
        clojure.data.csv)
  (:require [clojure.java.io :as io]))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Time for some top-down TDD action                              ;
;                                                                ;
;----------------------------------------------------------------;

; An export from IMDB
(def movies
  (with-open [file (io/reader (io/resource "Essential Nerd Movies.csv"))]
    (doall
     (read-csv file))))

; Implement the unfinished. Rules:
; - max 1 let form per function
; - max 1 if or when form per function
(unfinished with-favorite-director?
            critics-rating)

(defn my-rating [movie]
  (let [from-critics (critics-rating movie)]
    (if (with-favorite-director? movie)
      (* 1.2 from-critics)
      from-critics)))

(fact
  (my-rating ..movie..) => (roughly (* 3 1.2))
  (provided
    (critics-rating ..movie..)          => 3
    (with-favorite-director? ..movie..) => true))
