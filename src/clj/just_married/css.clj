(ns just-married.css
  (:require [garden.def :refer [defstyles defcssfn]]
            [garden.core :refer [css]]))

;; for some reason this is not already available but at least it's
;; very easy to define
(defcssfn url)

(def COLOR-PALLETTE
  {:amaranth "#E52B50"
   ;; :light-background "#dcdcdc"
   :light-background "#f9eef0"
   :dark-red "#8B0000"
   :blue "#4444FF"
   :marsala "#955251"
   :royal-blue "#4169e1"
   :deep-blue "#00bfff"
   :electric-blue "#2C75FF"
   :deep-electric-blue "#035096"
   :quote-background "#f9f9f9"
   :quote-border-left "#ccc"
   :map-background "#fff"})

(def FONT-FAMILIES
  {:open-sans "'Open Sans', sans-serif"
   :alex-brush "'Alex Brush', cursive"
   :rancho "'Rancho', cursive"})

(def FONT-STYLES
  {:big
   {:font-weight "bolder"
    :font-family (:open-sans FONT-FAMILIES)}})

;; define various font styles that can be used here

;; the base path in this case refers to where the css will be
;; generated into
(def IMAGES
  {:bw-cats "../images/cats_heart.jpg"
   :small-cats "../images/small_cats.jpg"})

;; each style defines a new file, could simply also generate
;; many different files ideally
(defstyles screen
  ;;TODO: make it actually still look nice though
  [:a {:color "inherit"
       :text-decoration "none"}]

  [:a:hover {:text-decoration "none"
             :color "inherit"}]

  [:blockquote:before {:color (:quote-border-left COLOR-PALLETTE)
                       :content "open-quote"
                       :font-size "4em"
                       :line-height "0.2em"
                       :margin-right "0.25em"
                       :vertical-align "-0.4em"}]

  [:blockquote {;;:display "inline" ;; TODO: check if we need this as well
                :background (:quote-background COLOR-PALLETTE)
                :padding "0.5em 10px"
                :border-left (format "10px solid %s" (:quote-border-left COLOR-PALLETTE))
                :quotes "\201C\201D\2018\2019"}]

  [:blockquote:after {:color "#B2AFCD"
                      :content "close-quote"
                      :font-size "4em"
                      :line-height ".1em"
                      :margin-right ".25em"
                      :vertical-align "-.4em"}]

  ;; various language settings
  [:.language-group {:padding-right "20px"}]
  [:.language.selected {:padding-right "20px"}]
  [:.language.not-selected {:padding-right "20px"}]

  [:app {:background-color (:marsala COLOR-PALLETTE)}]
  ;; maybe the image containing the rest should actually be an element
  ;; by itself?
  [:#countdown {;; find a more suitable image for the background
                ;; if possible
                ;; :background-image
                ;;[(url (format "'%s'" (:bw-cats IMAGES)))]
                :background-repeat "no-repeat"
                :text-align "center"
                :font-weight "bold"
                :font-family (:alex-brush FONT-FAMILIES)
                :font-size "x-large"
                :color (:marsala COLOR-PALLETTE)}]

  ;; countdown settings
  [:.timer {;:background-color (:marsala COLOR-PALLETTE)
            :font-weight "bolder"
            :color (:deep-blue COLOR-PALLETTE)}]

  [:body {:background (:light-background COLOR-PALLETTE)}]
  ;; find us settings
  [:#map {:width "400px"
          :height "400px"
          :background (:amaranth COLOR-PALLETTE)
          :padding "15px"
          :box-shadow "0 0 20px #999"
          :border-radius "2px"}])
