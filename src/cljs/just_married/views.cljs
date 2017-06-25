(ns just-married.views
  (:require
   [re-frame.core :as re-frame :refer [dispatch subscribe]]
   [just-married.language :refer [make-lang AVAILABLE-LANGUAGES]]))

(defn payment
  []
  "Gift section, using stripe or something similar
for the integration")

(defn lang-selection
  "Define all the possible languages as sequences of clickable images"
  []
  (let [current-language (subscribe [:current-language])]
    (fn []
      (into
       [:div {:class "language-group"}]
       (for [lang AVAILABLE-LANGUAGES]
         (make-lang lang @current-language))))))

(defn main-panel
  []
  (fn []
    [:g [lang-selection]]))
