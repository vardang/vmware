package com.vardang

class Book {

    String title
    int pages
    int price
    Date date
    static belongsTo = [author: Author]

    static constraints = {
    }
}
