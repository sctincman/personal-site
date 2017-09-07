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

(defn h-card []
  [:section.h-card
   [:a.u-url {:rel "me"
              :href "https://zincfox.red"}
    [:div.scrim-top
     [:h2 [:span.p-name [:span.p-given-name "Jonathan"] " "
           [:span.p-family-name "Tinkham"]]
      ": "
      [:span.p-nickname "(Tincman)"]]
     [:img.u-photo {:src "assets/about/profile.jpg"
                    :alt "Photo of Jonathan Tinkham"
                    :style {:width "100%"}}]]]
   [:p [:span.p-job-title "Software Engineer I"] " at "
    [:span.p-org "FICO"]]
   [:ul.urls
    [:li [:a.u-email {:href "mailto:jonathan.tinkham@gmail.com"}
    "Main: jonathan.tinkham@gmail.com"]]
    [:li [:a.u-email {:href "mailto:sctincman@gmail.com"}
    "Devel sctincman@gmail.com"]]
    [:li [:a.u-url {:href "https://twitter.com/sctincman"
                     :rel "me"}
          "Twitter"]]
    [:li [:a.u-url {:href "https://github.com/sctincman"
                     :rel "me"}
          "Github"]]
    [:li [:a.u-url {:href "https://google.com/+JonathanTinkhams/about"
                     :rel "me"}
          "Google"]]
    [:li [:a.u-url {:href "https://facebook.com/jonathan.scott.tinkham/about"
                     :rel "me"}
          "Facebook"]]
    [:li [:a.u-url {:href "https://www.linkedin.com/in/jonathantinkham"
                     :rel "me"}
          "LinkedIn"]]]])

(defn profile []
  [:section.profile
   [:h2 "Bio"]
   
   [:section
    [:h3 "Currently"]
    [:p "Open-source junkie and avid Linux user. I am interested in a wide-range of computer and programming topics. I've worked with platform and systems programming by porting Linux and applications to various ARM platforms. I self-host a variety of services on my own network. I've contributed to OpenCL CPU implementations, and intrigued by multi-threading and parallel programming. Recently embracing the Web as a fascinating platform, especially after discovering Clojurescript. Polyglot that thrives on learning new things. I spend my spare time developing and dissecting games. There is nothing quite as versatile and encompassing as the technology and skill that goes into creating games. It is also a wonderful way to fuel my more creative urges. When that is too demanding for my energy: reading, drawing, crocheting, and cosplay are all good distractions." ]
    [:p "I currently work as a Software Engineer at FICO. I started there in October of 2016, and have been working on integrating and extending Zeppelin into our product as a interactive data science exploration platform. This has allowed me to work on open-source software while growing as a new software developer."]]
   
   [:section
    [:h3 "Previously"]
    [:p "I have always wanted to make games. I had a deep obsession with games when I was young and fascinated by how they work. I dearly wanted to make my own games. I learned to program specifically to accomplish this goal. My school did not offer any programming courses during this period, and the internet at the time had a good chunk of resources, but not that many. I struggled to teach myself \"programming\" dabbling in BASIC/Java/C/C++ and [yes] ...actionscript. By the time I finished high school I had made a small number of tech demos for platformers and RPGs. I entered university as a computer science major intending to make video games and other amazing things."]
    [:p "However, I have also always had a great interest in mathematics and science. I felt remiss not continuing my studies of them as well as I moved away from the extremely liberal high school curriculum I subjected myself to, and over the summer I studied Chemistry in my leisure. This science captured my imagination--it felt to hold secrets to the underpinnings of the world."]
    [:p "Disenfranchised with the computer science courses I was taking, and the lack of exciting employment post-dotcom bubble, I jumped ship to Chemistry. I stayed on this path all through Bachelor's and my PhD. I was good at this, and discovering 'Computational Chemistry' kept me hooked, as I could use my skills to model and predict chemical and photophysical properties of molecules. However, academia is a difficult place to stay in, and I found myself burnt out. My spare time was wonderfully filled with various computer and programming projects, and I yearned for this life again."]]
   
   [:section
    [:h3 "To Be Determined."]
    [:p "I enjoy the path I am on, even though I don't know exactly where it's taking me. I am focusing on making myself a better developer and engineer. I want to make the software I want to use, and make the world a better place through open-source software. Whether that is chemistry and scientific software, or the next great game is still to be determined."]]])

(defn h-resume []
  [:section.h-resume
   [:h2.p-name
    [:a {:class "p-contact h-card"
         :href "https://zincfox.red/about"}
     "Jonathan Tinkham"]
    " Resume"]
   [:section.p-affiliation
    [:p "Software Engineer I at FICO."]]

   [:section.p-summary
    [:p "Former computational chemist turned software engineer. Polyglot with experience in systems and full-stack development. Avid Linux user and overall computer and electronics enthusiast."]]

   [:section
    [:h3 "Skills"]
    [:section [:h4 "Systems"]
     [:p "Avid Linux user. I have been using it exclusively since 2000."]
     [:ul
      [:li "Personal Desktops/Laptops"]
      [:li "Embedded systems"
       [:ul [:li "Raspberry Pi, Beaglebone Black, Odroid U3, Parallella, Acer Chromebook [Tegra]"]]]
      [:li "Server and Virtualized environments"
       [:ul [:li "AWS, Docker, libvirt"]]]]]

    [:section [:h4 "Programming"]
     [:p "Polyglot that enjoys learning new languages and paradigms. Favors Lisps and functional/immutable programming."]
     [:ul
      [:li "Clojure"]
      [:li "Java"]
      [:li "Javascript"]
      [:li "Python"]
      [:li "C/C++"]
      [:li "Shell scripting (Bash)"]]]
    [:section [:h4 "Design"]
     [:p "Experience with layout and authoring."]
     [:p "LaTeX typesetting and mathematics"]
     [:p "HTML/CSS webdesign."]
     [:p "Familiar with raster, vector, and 3D design programs"]
     [:ul
      [:li "GIMP"]
      [:li "Inkscape"]
      [:li "Blender"]]]]
   [:section
    [:h3 "Experience"]
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:datetime "2016-10-28"} "Oct 2016"] "--"
     [:time.dt-end "Present"]
     [:p.p-summary "Software Engineer I"]
     [:p.p-description "Integrated Zeppelin into Analytics Workbench, a big-data analytics and machine learning suite."]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "FICO"] " "
       [:span.p-locality "Denver"] ", "
       [:span.p-region "CO"]]]]]])

(defn about-page []
  [:div.about
   (h-card)
   (profile)
   (h-resume)])

(defn posts-body []
  [:section.posts
   (for [post (posts/posts)]
     ^{:key post}
     [:section.post
      (println post)
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
