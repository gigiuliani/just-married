# just-married

Website to collect pictures, share information about a wedding and so on and so forth.

## Usage

## TODO

### Design and features

- [ ] let tests also run on travis, mocking out the HTTP calls for example
- [ ] serve the website behind HTTPS (Heroku's one or another), this actually costs 20$ a month
      with Heroku, even if the certificate itself is free.

- [ ] register a nice DNS name (on [namecheap](https://www.namecheap.com/) or godaddy), possible examples could be:
  - andreaenrica.life
  - andreaenrica.wedding (more expensive)

- [ ] add section about how to get there;
- [ ] handle different ways to do the payment, where the "preferrable" might not be stripe since it's the only choice with a commission fee attached to it
  - [ ] postepay coordinates (EUR only)
  - [ ] bank coordinates (EUR/GDP choice)
  - [ ] stripe integration (EUR/GDP choice)

- [ ] add ways to upload images using various integrations: dropbox/google drive/else?
- [ ] add a link to the amazon wish list, which should not be entirely public
      but should still allow to see something
- [ ] add a countdown feature
- [ ] add a list of suggested hotels people can use, with different ranges of prices
- [ ] add simple support to [https://gist.github.com/andrewsuzuki/fd9edda14296fd03483b0dbe40ee3a99](google analytics)
- [ ] do English and Italian version of the content (changing currency based on the language as well potentially?)

### Tech details

- [ ] add "fork me on github" to the web page somewhere?? (maybe not the usual visible on top)
- [ ] evaluate twillio integration for more interesting way to interact
- [ ] add sentry support
  - [x] backend
  - [ ] frontend
- [x] add google analytics to get insight on the usage of the page
- [x] add newrelic support (if free)
- [ ] set up logentries to get even more insights
- [ ] register right DNS name and link it with Heroku

## Upload feature

Could use [Picasa WEB developer API](https://developers.google.com/picasa-web/) 
For clojure see [clj-dropbox ](https://github.com/aria42/clj-dropbox) instead.

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
