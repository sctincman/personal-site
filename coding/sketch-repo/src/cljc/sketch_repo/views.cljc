(ns sketch-repo.views
  (:require [sketch-repo.sketch :as repo]
            [sketch-repo.posts :as posts]))

(defn sketch-page []
  [:section.sketches
   [:ul.sketches
    (for [sketch (repo/sketches)]
      ^{:key sketch}
      [:li.sketch
       [:figure.thumbnail
        [:img {:src (str "sketches/" (get sketch :path) "/" (get sketch :image))}]]
       [:div.details
        [:h3.sketch-title [:a {:href (str "sketches/" (get sketch :path) "/" (get sketch :index))}
                         (get sketch :title)]
         [:span (get sketch :theme)]]
        [:p (get sketch :description)]
        [:footer.timeinfo "Added" [:time {:dateTime (get sketch :created)}
                                   (get sketch :created)]]]])]])

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
       [:span "Created on"
        [:time {:dateTime (get post :created)} (get post :created)]]
       (when (contains? post :edited)
         [:span
          "Edited on"
          [:time {:dateTime (get post :edited)} (get post :edited)]])]
      [:p (get post :content)]])])

(defn landing-page []
  [:section
   [:h2 "Tincman"]
   [:p "This is my personal site."]
   (posts-body)])

(def nav-bar
  [:header
   [:nav
    [:ul
     [:li [:a {:href "/"} "Landing"]]
     [:li [:a {:href "/sketches"} "Sketches"]]
     [:li [:a {:href "/about"} "About"]]]]])
