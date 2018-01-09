(ns just-married.api-test
  (:require [clojure.test :refer :all]
            [clojure.string :refer [includes?]]
            [ring.mock.request :as mock]
            [just-married.api :refer [app]]
            [just-married.utils :refer [db-reachable?]]
            [clojure.java.io :as jio]))

(deftest homepage-test
  (let [req (mock/request :get "/")
        resp (app req)]

    (testing "Homepage returns 200"
      (is (= 200 (-> resp :status))))

    (testing "Homepage contains some valid content"
      (is (true? (includes?
                    (-> resp :body)
                    "Andrea"))))))

(deftest authentication-helpers-test
  (testing "Can happily authenticate"
    (let [req (mock/request :get "/login" {:password "wrong"})
          resp (app req)]))
  (testing "Not able to authenticate"
    (let [req (mock/request :get "/login" {:password "secure-password"})
          resp (app req)])))

(deftest notify-test
  (testing "Send a notification"
    (let [req
          (-> (mock/request :post "/notify")
              (mock/json-body {:email "friend@mail.com"
                               :name "friend"}))
          resp (app req)]

      (is (= (-> resp :status) 201)))))

(when db-reachable?
  (deftest guest-list-test
    (testing "Without being authenticated we get 401"
      (let [req (mock/request :get "/guests")
            resp (app req)]
        (is (= 401 (-> resp :status)))))

    (testing "With authentication we get a 200"
      (let [req (mock/request :get "/guests")
            authed-req (assoc req :identity "admin")
            resp (app authed-req)]
        (is (= 200 (-> resp :status)))
        (is (clojure.string/includes? (-> resp :body) "init_guests()"))))))
