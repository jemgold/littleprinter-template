# littleprinter-template

A Leiningen template for LittlePrinter publications. Sets up your etags and servers assets from the right place etc.

Would love contributions if I've messed things up awfully!

## Usage

Run this to create a new publication.

```lein new littleprinter <your sweet publication name>```


1. ```lein new littleprinter my-sweet-publication-name```
1. Edit ```project.clj``` & ```static/meta.json``` with your project information
1. ```lein ring server``` (will livereload when you edit things!)
1. Add a 55x55px .png to ```/static/images/icon.png```
1. Edit your logic in ```src/<publication name>/ server.clj   views/edition.clj```
1. ```lein heroku-deploy```

## License

Copyright © {{year}} @jongold

Distributed under the Eclipse Public License, the same as Clojure.
