(ns dojo-week-34.core-test
	(:require [midje.sweet :refer :all]
        	  [dojo-week-34.core :refer :all]))

(fact "try-parse returns empty map for parsing failures"
	(try-parse "") => {}
	(try-parse "fdshjkdsfdsgfjksdf") => {}
	(try-parse "{ \"key\": \"value\" }") => { :key "value" })

(fact "filter info returns text"
	(filter-info-from-json {:text "prateek is awesome", :ignored "ignore Dan"}) => { :text "prateek is awesome"}
)

(fact "get tweets from mongo"
	(empty? (get-tweets)) => false)


(fact "filters text from saved documents"
	(vector?  (get-filtered-tweets)) => true)

(fact "split gets all words in sequence"
	(split-into-words '("Five minutes left") => '("Five" "minutes" "left"))