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
   [:div.scrim-top
    [:img.u-photo {:src "assets/about/profile.jpg"
                   :alt "Photo of Jonathan Tinkham"
                   :style {:width "100%"}}]
    [:h2.urls
     [:a.u-url {:rel "me"
                :href "https://zincfox.red"}
      [:span.p-name [:span.p-given-name "Jonathan"] " "
       [:span.p-family-name "Tinkham"]] " "
      [:span.p-nickname "(Tincman)"]]]]
   [:h4 [:span.p-job-title "Software Engineer I"] " at "
    [:span.p-org "FICO"]]
   [:ul.urls
    [:li [:a.u-email {:href "mailto:jonathan.tinkham@gmail.com"}
          [:i {:class "fa fa-envelope-o"
               :aria-hidden true}]
          "Main: jonathan.tinkham@gmail.com"]]
    [:li [:a.u-email {:href "mailto:sctincman@gmail.com"}
          [:i {:class "fa fa-envelope-o"
               :aria-hidden true}]
          "Devel: sctincman@gmail.com"]]
    [:li [:a.u-url {:href "https://twitter.com/sctincman"
                     :rel "me"}
          [:i {:class "fa fa-twitter"
               :aria-hidden true}]
          "Twitter"]]
    [:li [:a.u-url {:href "https://github.com/sctincman"
                     :rel "me"}
          [:i {:class "fa fa-github"
               :aria-hidden true}]
          "Github"]]
    [:li [:a.u-url {:href "https://google.com/+JonathanTinkhams/about"
                     :rel "me"}
          [:i {:class "fa fa-google"
               :aria-hidden true}]
          "Google"]]
    [:li [:a.u-url {:href "https://facebook.com/jonathan.scott.tinkham/about"
                    :rel "me"}
          [:i {:class "fa fa-facebook"
               :aria-hidden true}]
          "Facebook"]]
    [:li [:a.u-url {:href "https://www.linkedin.com/in/jonathantinkham"
                    :rel "me"}
          [:i {:class "fa fa-linkedin"
               :aria-hidden true}]
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
    " Curriculum Vitae"]

   [:section.p-summary
    [:p "Former computational chemist turned software engineer. Polyglot with experience in systems and full-stack development. Avid Linux user and overall computer and electronics enthusiast."]]
   
   [:section {:class "p-affiliation h-card"}
    [:p
     [:span.p-title "Software Engineer I"] " at "
     [:span.p-name "FICO"] " in "
     [:span.p-locality "Denver"] ", "
     [:span.p-region "CO"]]]

   [:section
    [:h3 "Skills"]
    [:section [:h4 "Systems"]
     [:p "Avid " [:span.p-skill "Linux"] "/" [:span.p-skill "BSD"] " user and admin. I have been using it exclusively since 2000."]
     [:ul
      [:li "Personal Desktops/Laptops"]
      [:li "Embedded systems"
       [:ul [:li "Raspberry Pi, Beaglebone Black, Odroid U3, Parallella, Acer Chromebook [Tegra]"]]]
      [:li "Server and Virtualized environments"
       [:ul
        [:li
         [:span.p-skill "AWS"] ", "
         [:span.p-skill "Docker"] ", "
         [:span.p-skill "libvirt"]]
        [:li
         [:span.p-skill "Nginx"] " (with "
         [:span.p-skill "Let's Encrypt"] " based TLS)"]]]]]

    [:section [:h4 "Programming"]
     [:p "Polyglot that enjoys learning new languages and paradigms. Favors Lisps and functional/immutable programming."]
     [:section
      [:h5 "Languages"]
      [:ul
       [:li.p-skill "Clojure"]
       [:li.p-skill "Java"]
       [:li.p-skill "Javascript"]
       [:li.p-skill "Python"]
       [:li.p-skill "C/C++"]
       [:li.p-skill "Shell scripting (Bash)"]]]
     [:section
      [:h5 "Frameworks/APIs"]
      [:ul
       [:li [:span.p-skill "Reagent"] " (Clojurescript React framework)"]
       [:li.p-skill "Angular"]
       [:li [:span.p-skill "OpenGL"] ", " [:span.p-skill "WebGL"] ", " [:span.p-skill "OpenCL"] ", and " [:span.p-skill "SDL"]]
       [:li.p-skill "d3.js"]
       [:li.p-skill "matplotlib"]]]]
    
    [:section [:h4 "Design"]
     [:p "Experience with layout and authoring."]
     [:p [:span.p-skill "LaTeX"] " typesetting and mathematics"]
     [:p.p-skill "HTML/CSS"]
     [:p "Familiar with raster, vector, and 3D design programs"]
     [:ul
      [:li.p-skill "GIMP"]
      [:li.p-skill "Inkscape"]
      [:li.p-skill "Blender"]]]]
   
   [:section
    [:h3 "Experience"]
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2016-10-28"} "Oct 2016"] "--"
     [:time.dt-end "Present"]
     [:p.p-summary "Software Engineer I"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "FICO"] ": "
       [:span.p-locality "Denver"] ", "
       [:span.p-region "CO"]]]
     [:div.p-description
      [:p "Integrated Zeppelin into Analytics Workbench, a big-data analytics and machine learning suite."]
      [:ul
       [:li "Worked on a large open-source project, adding custom features and contributing patches upstream."]
       [:li "Worked with a large remote team from across the globe."]
       [:li "Received SPOT award for work during initial release."]]]]
    
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2015-02-01"} "Feb 2015"] "--"
     [:time.dt-end   {:dateTime "2016-10-26"} "Oct 2016"]
     [:p.p-summary "Postdoctoral Chemistry Researcher"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "Colorado School of Mines"] " "
       [:span.p-locality "Golden"] ", "
       [:span.p-region "CO"]]]
     [:div.p-description
      [:p "Designed, synthesized, and characterized novel organic/polymer/hybrid semi-conductors for application in thin film-based photovoltaics."]
      [:ul
       [:li "Trained, mentored, and supervised graduate and undergraduate students performing research in our group."]
       [:li "Performed Density-Functional Theory based computations to predict properties of new materials and model behavior of existing ones."]
       [:li "Published articles in peer-reviewed journals."]
       [:li "Peer-reviewed papers for publication."]]]]
    
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2009-08-26"} "Aug 2009"] "--"
     [:time.dt-end   {:dateTime "2015-02-01"} "Feb 2015"]
     [:p.p-summary "Graduate Research Fellow and Teaching Assistant"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "University of Massachusetts Amherst"] " "
       [:span.p-locality "Amherst"] ", "
       [:span.p-region "MA"]]]
     [:div.p-description
      [:p "PHaSE Energy Frontier Research Center funded research assistant under Professor Lahti. Performed research to design and synthesize new conjugated polymers for applications in organic photovoltaic devices and applications."]
      [:ul
       [:li "Computationally modeled a series of thienothiophene containing low-bandgap copolymers with [non]-fluorinated and [non]-conjugated pendant units."]
       [:li "Trained, mentored, and supervised undergraduate students performing research in our group."]
       [:li "Performed Density-Functional Theory based computations to predict properties of new materials and model behavior of existing ones."]
       [:li "Supervised multiple laboratory sections of organic chemistry course--teaching good organic laboratory practices, along with grading lab reports, and supervising exams for corresponding course."]]]]
    
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2009-06-01"} "Jun 2009"] "--"
     [:time.dt-end   {:dateTime "2009-08-01"} "Aug 2009"]
     [:p.p-summary "Consultant"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "Innovations in Optics"] " "
       [:span.p-locality "Woburn"] ", "
       [:span.p-region "MA"]]]
     [:p.p-description "Debug, implement, and expand accelerated lifetime testing setup."]]
    
    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2008-06-01"} "Jun 2008"] "--"
     [:time.dt-end   {:dateTime "2008-08-01"} "Aug 2008"]
     [:p.p-summary "Intern"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "Innovations in Optics"] " "
       [:span.p-locality "Woburn"] ", "
       [:span.p-region "MA"]]]
     [:div.p-description
      [:p "One of two interns tasked to design and implement an automated accelerated lifetime testing system for LED devices."]
      [:ul
       [:li "Gained experience in circuit design, optics, and LabView programming."]]]]

    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2008-09-01"} "Sep 2008"] "--"
     [:time.dt-end   {:dateTime "2008-12-15"} "Dec 2008"]
     [:p.p-summary "Teaching Assistant"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "University of Vermont"] " "
       [:span.p-locality "Burlington"] ", "
       [:span.p-region "VT"]]]
     [:div.p-description
      [:p "General Chemistry laboratory teaching assistant. Supervised laboratory portion of course--teaching basic laboratory practices, grading lab reports, and supervising and grading exams for lecture section."]]]

    [:section {:class "p-experience h-event"}
     [:time.dt-start {:dateTime "2006-09-01"} "Sep 2006"] "--"
     [:time.dt-end   {:dateTime "2006-12-15"} "Dec 2006"]
     [:p.p-summary "Teaching Assistant"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "University of Vermont"] " "
       [:span.p-locality "Burlington"] ", "
       [:span.p-region "VT"]]]
     [:div.p-description
      [:p "Introductory Computer Science teaching lab assistant. As a sophomore, I supervised the laboratory portion of course--aiding students with problems and grading weekly assignments."]]]]

   [:section
    [:h3 "Education"]
    [:section {:class "p-education h-event"}
     [:time.dt-start {:dateTime "2009-08-26"} "Aug 2009"] "--"
     [:time.dt-end   {:dateTime "2015-02-01"} "Feb 2015"]
     [:p.p-summary "Ph.D. in Chemistry"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "University of Massachusetts Amherst"] " "
       [:span.p-locality "Amherst"] ", "
       [:span.p-region "MA"]]]
     [:div.p-description
      [:p "Advised by Professor Paul M. Lahti."]
      [:p "Thesis: Design, Synthesis, and Application of Dithienylpyrrole-based Polymers in Organic Electronic Materials."]]]
    
    [:section {:class "p-education h-event"}
     [:time.dt-start {:dateTime "2005-08-28"} "Aug 2005"] "--"
     [:time.dt-end   {:dateTime "2009-05-20"} "May 2009"]
     [:p.p-summary "B.S. in Chemistry"]
     [:address {:class "p-location h-card"}
      [:p
       [:span.p-name "University of Vermont"] " "
       [:span.p-locality "Burlington"] ", "
       [:span.p-region "VT"]]]
     [:div.p-description
      [:p "ACS Certified Chemistry Program."]
      [:ul
       [:li "Graduated " [:em "cum laude"]]
       [:li "Minor in Mathematics"]
       [:li "Member of the Japanese House language program (organized cultural events, movie nights, and practice sessions for the associated class)."]]]]]])

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
