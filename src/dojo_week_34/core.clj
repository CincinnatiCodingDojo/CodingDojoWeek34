(ns dojo-week-34.core
	(:use [dojo-week-34.twitter-stream]
		  [dojo-week-34.repository])
	(:require 
   		[clojure.data.json :as json]))

(defn try-parse [json-str]
	(try
		(json/read-json json-str)
		(catch Exception e {})))

(defn filter-info-from-json [parsed-json]
	(select-keys parsed-json [:text]))

(defn parse-and-save [json-str] 
	(if (clojure.string/blank? json-str)
		"Waiting for data"
		(let [parsed-doc (try-parse json-str)]
			(if (or (empty? parsed-doc) (string? parsed-doc)) "Waiting for data" 
			  (filter-info-from-json (save-document parsed-doc "tweets"))))))

(defn get-filtered-tweets [tweets] 
	(map :text tweets))

(defn split-into-words [text]
	(map #(clojure.string/split % #"\s+") text)))

(defn -main [& args] 
	(track-keyword "Kroger" #((comp println parse-and-save) (str %)))

	(while true (Thread/sleep 1000)))

