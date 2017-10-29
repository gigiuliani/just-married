(ns just-married.api
  (:require [ring.middleware.defaults :as r-def]
            [ring.util.response :as resp]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resources]
            [compojure.core :refer [defroutes GET]]
            [environ.core :refer [env]]))

(def default-port 3000)

(defn get-port
  []
  (Integer. (or (env :port) default-port)))

(def home
  (resp/file-response "index.html" {:root "resources/public"}))

(defroutes app-routes
  (GET "/" [] home))

(def app
  (-> app-routes
      (resources/wrap-resource "public")
      (r-def/wrap-defaults r-def/site-defaults)))

(defn -main [& args]
  (jetty/run-jetty app {:port (get-port)}))
