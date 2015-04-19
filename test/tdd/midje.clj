(ns tdd.midje
  (:use midje.sweet))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Before getting into top-down TDD, let's familiazize with Midje ;
;                                                                ;
;----------------------------------------------------------------;

(def _ :changeme) ; this is the last time you see this!

(defn first-element [sequence default]
  ; BUG! In most LISPs, empty strings are also nil, but not in Clojure!
  (if (nil? sequence)
    default
    (first sequence)))

(facts "about `first-element`"
  (fact "it normally returns the first element"
    (first-element [1 2 3] :default) => 1
    (first-element '(1 2 3) :default) => 1)

  ;; Run the test, get a red, turn it into green
  (fact "default value is returned for empty sequences"
    (first-element [] :default)                     => :default
    (first-element '() :default)                    => :default
    (first-element nil :default)                    => :default
    (first-element (filter even? [1 3 5]) :default) => :default))

(facts
 (fact "Standard equality depends on the type of the checkables"
       (= #"a" #"a") => _)
 (fact "Extended equality provides a better language to express facts"
       #"a" => _
       _    => (three-of number?)
       _    => (just [1 2 3]))
 (fact "Check a collection, but ignore ordering"
       _ => (just #{1 3 2})
       _ => (just [1 2 3] :in-any-order)))
