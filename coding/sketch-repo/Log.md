# Progress

## 2017-08-02

I finally picked this back up after all the craziness that happened. I definitely need to rethink the schedule on this sort of thing. A last minute San Fransisco trip coupled with a maintenance release at work certainly threw a wrench into this.

I added the ability to navigate to a sketch's "index" page. By default, this is a top-level index.html page. However, a sketch can overide this with the `:index` property in props.clj. Also, if these top-level pages are Markdown pages, they will be compiled to HTML on the fly by [markdown-clj](https://github.com/yogthos/markdown-clj).

Also, apparently compojure's URI matching only goes to the next "." or "/", and this appears to properly observe forward-slashes (included encoded ones), and doesn't accept `/./` or `/../`. Aka, I can't seem to escape the directory I serve files from (as I use a very naive and unsanitized file read with the URI paths...). Awesome!

## 2017-08-16

I intended to work on the landing page, and had researched that a bit. However, I figured the navigation bar would be easier to knock out, and make testing the landing page easier.

### Landing Page

I had thought about how I want to handle this. For the purpose of getting this done simple and quick, I intended to just watch for new files (or read on startup) to populate the "updates". Java has a file watcher API and there is a plethora of Clojure wrappers for this--this is a very achievable path. I keep getting distracted by performance issues I don't need to worry about now. I can always revamp this later in a newer version.

### Navigation bar

I made a new bar with links. Whoo. I didn't style it yet because I hit something.

I wanted to have the navbar indicate what page you were currently on. I knew I could do this server-side as well as client side in Reagent, but the client-side routing would prevent the server side from loading, and I didn't want to write the nav-bar twice. I foresaw similar problems with the page rendering. I still wanted to have a static version available.

I figured out you can have a cljc file refer to a namespace--if you have that namespace in both clj and cljs versions, it will transparently load the one for the platform it's running on. This means I could write generic vectors in a cljc "views" namespace, that calls into modules for the info to fill the response, with a server side mode that will read from the system, and a client-side that uses reagent atoms and makes ajax requests to the server.

I was able to adapt the sketch repo/listing behavior to work this way, and moved most other page/content templates to the cljc views module.

This involved setting up generic REST endpoints in ring/compojure, adding JSON middleware, using the config.core library for system properties and parameterizing the program, and using cljs.ajax for ajax.

Clojure is really awesome :D

...I'll need to style the navbar later and actually make it indicate what page you're on...
