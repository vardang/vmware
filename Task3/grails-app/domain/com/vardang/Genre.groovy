package com.vardang

class Genre {

    String name
    List<Author> authors
    static hasMany = [authors: Author]

    static constraints = {
    }
}
