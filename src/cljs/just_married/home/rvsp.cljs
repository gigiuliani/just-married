(ns just-married.home.rvsp
  (:require [just-married.home.language :refer [translate]]
            [re-frame.core :refer [dispatch subscribe]]))

(def ^:private rvsp-dict
  {:en {:rvsp "RVSP"
        :coming "I'll be there"
        :not-coming "Can't make it"}

   :it {:rvsp "RVSP"
        :coming "Contaci"
        :not-coming "Non posso"}})

(def ^:private tr (partial translate rvsp-dict))

(defn rvsp
  []
  (let [name @(subscribe [:name])
        email @(subscribe [:email])
        dietary-problems @(subscribe [:dietary])])

  [:div.rvsp {:id "rvsp"}
   [:h3 (tr :rvsp)]

   [:div.rvsp__form
    [:input.rvsp__name {:type "text"
                        :placeholder "Name"
                        :on-change #(dispatch [:set-name (-> % .-target .-value)])}]

    [:input.rvsp__email {:type "email"
                         :placeholder "Email Address"
                         :on-change #(dispatch [:set-email (-> % .-target .-value)])}]


    [:button.rvsp__coming {:on-click #(dispatch [:send-notification true])} (tr :coming)]
    [:button.rvsp__not_coming {:on-click #(dispatch [:send-notification false])} (tr :not-coming)]]])
