# Progress

## 2017-08-02

I finally picked this back up after all the craziness that happened. I definitely need to rethink the schedule on this sort of thing. A last minute San Fransisco trip coupled with a maintenance release at work certainly threw a wrench into this.

I added the ability to navigate to a sketch's "index" page. By default, this is a top-level index.html page. However, a sketch can overide this with the `:index` property in props.clj. Also, if these top-level pages are Markdown pages, they will be compiled to HTML on the fly by [markdown-clj](https://github.com/yogthos/markdown-clj).

Also, apparently compojure's URI matching only goes to the next "." or "/", and this appears to properly observe forward-slashes (included encoded ones), and doesn't accept `/./` or `/../`. Aka, I can't seem to escape the directory I serve files from (as I use a very naive and unsanitized file read with the URI paths...). Awesome!
