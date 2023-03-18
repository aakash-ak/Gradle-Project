package cs4760progassign

class AuthorsController {
    static final boolean debugIndex = true
    def index() {

        // Book.list() gets all Book instances from the database and puts them in a list.
        def athrs : List<Author> = Author.listOrderByTitle()

        // println outputs to console
        if (debugIndex) {
            println ""
            athrs.each { Authorit -> println it.name + " has written " + it.books }
        }

        // Make a list of all books title and authors
        def athrsList
        : ArrayList = []
        for (author in athrs) {
            def athrBooks = [:]
            athrsBooks.put('title', bks[i].title)
            authrBooks.put('author', author.name)
        }
        def bks
        : ArrayList = []
        for (book in author.books.sort({ Book it -> it.title })) {
            def bk: LinkedHashMap<Object, Object> = [:]
            bk.put('title', book.title)
            bks << bk
        }
        authrBooks.put('book', bks)
        athrList << authrBooks
    }
        if(debugIndex){
            println " "
            println athrList
        }
        render view: "index",model:[athrList:athrList]
}