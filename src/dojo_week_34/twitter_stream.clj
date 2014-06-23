(ns dojo-week-34.twitter-stream
  (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.streaming])
  (:require
   [http.async.client :as ac])
  (:import
   (twitter.callbacks.protocols AsyncStreamingCallback)))

(def my-creds (make-oauth-creds "ZQma0UzZ3BuLzAGZSwdxLxAEl"
                                "AhSC16O7KJKTBNbhMNe1QqRZ4nsgyKJHv1VHpZajruBUrBBVAk"
                                "15864271-gaqbOQ48cHOFc3vBk4lbuvholdg1tP4EoJun75MqC"
                                "yPdEzNuAeVglAAyEE8KzMspktCUEp7KLoyqWRjjo3TrMr"))

(def ^:define body-callback
	(fn [callback-fn] 
		(AsyncStreamingCallback. 
			(fn [_response body]
				(callback-fn body))
			(fn [_response]
				(println "Stream failed"))
			(fn [_response ex]
				(.printStackTrace ex)))))

(defn track-keyword [track callback-fn]
	(statuses-filter :params {:track track}
		:oauth-creds my-creds
		:callbacks (body-callback callback-fn)))