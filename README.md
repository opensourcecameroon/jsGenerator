# jsGenerator
Generates JS code from syntatically correct HTML code... following the DOM mapping methods of JS 

## todo
* Fix to recognise open-ended tags e.g ``<img src="" alt="">`` should be treated as ``<img src="" alt=""></img>`` - behaviour now is functions like sibling attribute is child
* ~~Fix to refactor tag names so multiple tags don't end up with the same name when appending~~