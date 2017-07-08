# SELF

## Intro

This month, I'm working on me. I'm going to make a personal site.

This one is a little meta, as I hope to use this as the platform to facilitate future projects. A personal site is the perfect safe space for me to put it all out there.

I need a space, separate from my PC and world viewable. I need to express myself. I need a place to preserve and track my progress. I need accountability.

I need a portfolio ;D

## Description

This will be a website for others, and a platform for me.

I want three things.

	1. Landing page with updates
	2. Sketch page--where I put the monthly sketches
	3. About Page

## Acceptance criteria

### Users
Visitors arriving at the page will be greeted by a short description of my personal site. A list of updates/posts from me follows. A navigation bar/panel is used to navigate between the 3 pages, and includes a custom personal logo and title. 

The sketch page begins with a description of what this is and why I'm doing it, followed by a list of entries listed in reverse chronological order, each with a thumbnail of my choosing to best represent the sketch. One can click into projects to either view (if it is something web related), or browse (if it is not).

The about page will give an overview of me. It will include [h-card](http://microformats.org/wiki/h-card) information, including links to my other accounts and profiles, as well as contact information and public key fingerprints. It will also include a past/present/future section, briefly describing where I've been, what I'm doing now, and where I hope to be.

### Myself

I need a way to update the front pages with new posts. I don't care if this is me manually editing a static source file and pushing with git.

I need a way to add new sketches without mucking about with this source too much. I should be able to upload the month's directory to the webserver and at most add a new image and link to the page. An index.html file will serve as the landing page. The sketch's landing page will have the month's theme, a description of the sketch, a link to the sketch itself, and post-mortem. The link can either be the sketch itself (if it's a web project), or will navigate to a directory listing (this can be ugly and from nginx).

The about page can be static. This will not change much and can be updated less frequently.

## Implementation

I am writing this in Clojurescript as a Reagent/React application. I do not care if it's excessive--it's fun.

This should be a standalone webapp, but other webstack tools are acceptable. For example, I will likely have this behind nginx (to handle proxy and TLS).

I will be using git to manage sketches and this one itself. However, this should be able to fallback to plain old cp/scp.

I need a way to backup everything. Since this is public, I am allowed to use cloud based platforms. However, as I support the indie web and self-hosting, they should be considered backups. This is my primary site.

### Week 1
Planning and experiments and preliminary work.

1. Create design document and have schedule worked out.

### Week 2
Have sketch page implemented and navigation bar/panel working. Recycle sketch page for landing page.

#### Sketch page
1. See if getting a directory listing is feasible
2. Populate some dummy entries
3. Be able to navigate to each sketch's landing page

#### Navigation
1. Each link navigates to each page and indicates which page your on.
2. Just make a sticky bar (panel is nice, but potential time getting it working).

#### Landing page
1. Include short description
2. Include some updates, use technique from sketch page to populate
   * Filename -> title
   * creation date for timestampe
   * content added directly

### Week 3
This week is writing and drawing. Design a logo and populate the about page.

1. Create a nice logo
2. Write 500 words each on
   * What you've done
   * What you're doing now
   * What you want to be doing

### Week 4

Finalize!

1. Deploy on server
2. Create index.html
3. Write post-mortem.
4. Stylize if time permitting.

## Skills/Media

Breakdown of what work/skills I'm developing

### Coding
Web development, Clojure[script], React/Reagent.

My goal is to become more comfortable developing webapps and keep using a language I love, while learning a new and awesome framework.

### Drawing/Design
Logo creation (graphic design), layout of website, typography, colors.

My goal is get better at making pleasing layouts and become more comfortable with what CSS can do, as well as revisiting my more cartoon/graphic style of drawing. Both of these should reflect my taste.

### Writing
There is a lot of bio information here: I will be writing a treatise on myself and this idea I had while watching a youtube video on "inspiration and staying motivated".

My goal here it to become more comfortable talking about myself, and not being ashamed of who I am now. Time to dig deep and put yourself out there.
