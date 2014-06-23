(ns dojo-week-34.twitter-client
  (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)))

(def my-creds (make-oauth-creds "ZQma0UzZ3BuLzAGZSwdxLxAEl"
                                "AhSC16O7KJKTBNbhMNe1QqRZ4nsgyKJHv1VHpZajruBUrBBVAk"
                                "15864271-gaqbOQ48cHOFc3vBk4lbuvholdg1tP4EoJun75MqC"
                                "yPdEzNuAeVglAAyEE8KzMspktCUEp7KLoyqWRjjo3TrMr"))