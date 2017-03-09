package com.vardang

class Author {

    String name
    List<Book> books
    static hasMany = [books: Book]
    static belongsTo = [genre: Genre]

    static constraints = {
    }
}
