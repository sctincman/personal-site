(ns sketch-repo.views
  (:require [sketch-repo.sketch :as repo]
            [sketch-repo.posts :as posts]))

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

(defn posts-body []
  [:section.posts
   (for [post (posts/posts)]
     ^{:key post}
     [:section.post
      (if (contains? post :title)
        [:h3 (get post :title)]
        [:h3 (str "Update " (get post :created))])
      [:header.timeinfo
       [:p.info
        "Created on"
        [:time {:datetime (get post :created)} (get post :created)]]
       (when (contains? post :edited)
         [:p.info
          "Edited on"
          [:time {:datetime (get post :edited)} (get post :edited)]])]
      [:p (get post :content)]])])

(defn landing-page []
  [:section
   [:h2 "Tincman"]
   [:p "This is my personal site."]
   [:section.updates
    [:h3 "Updates"]
    (posts-body)]])

(def nav-bar
  [:header
   [:nav
    [:ul
     [:li [:a {:href "/"} "Landing"]]
     [:li [:a {:href "/sketches"} "Sketches"]]
     [:li [:a {:href "/about"} "About"]]]]])
