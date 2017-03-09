import com.vardang.Author
import com.vardang.Book
import com.vardang.Genre

class BootStrap {

    def init = { servletContext ->
        Genre programming = new Genre(name: "Programming")
        Author stroustrup = new Author(name: "Bjarne Stroustrup", genre: programming)
        Book c_plus_plus = new Book(title: "The C++ Programming Language (4th Edition)", pages: 1368, price: 61, date: new Date( 2013 , 5 , 19 ), author: stroustrup)
        stroustrup.addToBooks(c_plus_plus)
        Author bloch = new Author(name: "Joshua Bloch", genre: programming)
        Book java = new Book(title: "Effective Java (2nd Edition)", pages: 346, price: 51, date: new Date( 2008 , 5 , 28 ), author: bloch)
        bloch.addToBooks(java)
        programming.addToAuthors(stroustrup).addToAuthors(bloch).save(flush: true)

        Genre electronics = new Genre(name: "Electronics")
        Author razavi = new Author(name: "Behzad Razavi", genre: electronics)
        Book analog = new Book(title: "Design of Analog CMOS Integrated Circuits", pages: 684, price: 284, date: new Date( 2000 , 8 , 15 ), author: razavi)
        razavi.addToBooks(analog)
        electronics.addToAuthors(razavi).save(flush: true)


    }
    def destroy = {
    }
}
