# NOTE

**Please, this project is transferred to a new repository, we invite you to follow this [link](https://github.com/osscameroon/js-generator) to get in touch with updates.**

# jsGenerator
Generates JS code from syntatically correct HTML code... following the DOM mapping methods of JS 

## todo
* Fix to recognise open-ended tags e.g ``<img src="" alt="">`` should be treated as ``<img src="" alt=""></img>`` - behaviour now is functions like sibling attribute is child
* ~~Fix to refactor tag names so multiple tags don't end up with the same name when appending~~



# About

JsGenerator is a proposed solution to generating Javascript code from HTML code following the JavaScript DOM structure.

# Code Info

Language: JAVA

Build Tool: Maven

Dependencies: jsoup 

# Build

1. Clone

2. Import into your IDE

    2.1. Build -> `mvn clean package`

3. Browse through source codes and find Main file

4. Paste HTML code and test... should output some JS for you...
