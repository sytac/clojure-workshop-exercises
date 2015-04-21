(ns async.rocks
  (:require [clojure.core.async :refer :all]))

;------------------;
; Clojure Workshop ;
;---------------------------------------------------------------;
;                                                               ;
; Write down a rock-paper-scissors player with core.async       ;
;                                                               ;
;---------------------------------------------------------------;

; To run the exercise, load this file into a running REPL then use:
; (play (init))

(def MOVES [:rock :paper :scissors])
(def BEATS {:rock :scissors, :paper :rock, :scissors :paper})

(defn random-move
  "Picks a random move from the available ones"
  []
  (rand-nth MOVES))

; Create this function so that it returns a channel. The channel will deliver
; new moves from the player
(defn rand-player
  "Create a named player and return a channel to report moves."
  [name])

(defn winner
  "Based on two moves, return the name of the winner."
  [[name1 move1] [name2 move2]]
  (cond
   (= move1 move2) "no one"
   (= move2 (BEATS move1)) name1
   :else name2))

(defn judge
  "Given two channels on which players report moves, create and return an
   output channel to report the results of each match as [move1 move2 winner]."
  [p1 p2]
  (let [out (chan)]
    (go
     (while true
       (let [m1 (<! p1)
             m2 (<! p2)]
         (>! out [m1 m2 (winner m1 m2)]))))
    out))

(defn init
  "Create 2 players (by default Alice and Bob) and return an output channel of match results."
  ([] (init "Alice" "Bob"))
  ([n1 n2] (judge (rand-player n1) (rand-player n2))))

(defn report
  "Report results of a match to the console."
  [[name1 move1] [name2 move2] winner]
  (println)
  (println name1 "throws" move1)
  (println name2 "throws" move2)
  (println winner "wins!"))

(defn play
  "Play by taking a match reporting channel and reporting the results of the latest match."
  [out-chan]
  (apply report (<!! out-chan)))
