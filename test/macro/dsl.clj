(ns macro.dsl
  (:use midje.sweet)
  (:require [clojure.string :as s]))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Implement a DSL by using macros and regular functions          ;
;                                                                ;
;----------------------------------------------------------------;
;
; We created a Clojure DSL to express Bash programs. We support
; only a few commands and features:
; - echo
; - head
; - piping stdout into stdin
;
; You need to write the piped macro that works as follows:
;
; (macroexpand '(piped (println "foo") (println "bar") (head 1) (println "foo"))
; ->
; (let [stdin ""
;       stdou (with-out-str (println "foo"))]
;   (let [stdin stdout
;         stdout (with-out-str (println "bar"))]
;     (let [stdin stdout
;           stdout (first (split-lines stdin))]
;       stdout)))
;
; Have a look at (source ->) for inspiration

(unfinished piped)

(fact "I can pipe the execution of programs into a single string"
      (piped (println "foo")
             (println "bar")
             (head 1)
             (println "foo")) => "foofoo"

      (piped (head 1) => ""))
