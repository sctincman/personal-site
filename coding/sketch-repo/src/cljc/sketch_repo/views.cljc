(ns sketch-repo.views
  (:require [sketch-repo.sketch :as repo]))

(defn sketch-page []
  [:ul
   (for [sketch (repo/sketches)]
     ^{:key sketch}
     [:li 
      [:a {:href (str "sketches/" (get sketch :path) "/" (get sketch :index))} (get sketch :title)]
      [:img.thumbnail {:src (str "sketches/" (get sketch :path) "/" (get sketch :image))}]
      [:p (get sketch :theme)]
      [:p (get sketch :description)]])])

(defn about-page []
  [:h3 "About me!"])

(defn landing-page []
  [:h3 "Tincman - Landing"])

(def nav-bar
  [:header
   [:nav
    [:ul
     [:li [:a {:href "/"} "Landing"]]
     [:li [:a {:href "/sketches"} "Sketches"]]
     [:li [:a {:href "/about"} "About"]]]]])
