(ns tdd.romans
  (:use midje.sweet))

;------------------;
; Clojure Workshop ;
;----------------------------------------------------------------;
;                                                                ;
; Implement a converter from Roman numerals up to 1000           ;
;                                                                ;
;----------------------------------------------------------------;

; Quick recap on Roman numerals:
;
; I => 1
; V => 5
; X => 10
; L => 50
; C => 100
; D => 500
; M => 100
;
; Symbols are places next to each other in value order, then summed up:
;
; MDCLXVI => 1666
;
; There can be only up to three repeated symbols in a row:
;
; XI     => 11
; XII    => 12
; XIII   => 13
; XIIII  => WRONG!
;
; When a symbol is preceded by a symbol of a lesser value, you subtract it:
;
; IX => 8
;
; There can be only up to one subtractive symbol in a row:
;
; IX   => 9
; IIX  => WRONG!
; VIII => 8

; Write the function roman->int
(unfinished roman->int)

; Add test cases here and proceed using the top-down TDD methodology
(fact
  (roman->int "I") => 1)
