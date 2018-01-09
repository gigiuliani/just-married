(ns just-married.home.handlers
  (:require [re-frame.core :as re-frame :refer [reg-sub dispatch reg-event-db]]
            [just-married.home.db :as db]))

(defn- getter
  [key]
  (fn [db _]
    (key db)))

(defn- setter
  [key]
  (fn [db [_ val]]
    (assoc db key val)))

(reg-sub
 :expanded-story
 (getter :expanded-story))

(reg-sub
 :name
 (getter :name))

(reg-sub
 :email
 (getter :email))

(reg-sub
 :dietary
 (getter :dietary))

(reg-event-db
 :set-name
 (setter :set-name))

(reg-event-db
 :set-email
 (setter :set-email))

(reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(reg-event-db
 :set-expanded-story
 (fn [db [_ expanded-story]]
   (assoc db :expanded-story expanded-story)))
