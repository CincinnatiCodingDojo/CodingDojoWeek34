(ns dojo-week-34.repository
  (:require [monger.core :as mg]
  			[monger.collection :as mc]
  			[monger.query :as mq]))

(defn save-document [document collection]
	(let [conn (mg/connect)
		  db (mg/get-db conn "dojo")]
		
		(let [mongo-doc (mc/insert-and-return db collection document)]
			(mg/disconnect conn)
			mongo-doc)))

(defn get-tweets []
	(let [conn (mg/connect)
		  db (mg/get-db conn "dojo")]
	    (mq/with-collection db "tweets"
	    	(mq/find {}))))
