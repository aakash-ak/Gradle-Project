package cs4760progassign

class Book {

    String title
    int publishYear
    byte[] cover
    static belongsTo = [author: Author]

    static constraints = {
        title nullable: false, blank: false
        publishYear nullable: false
        cover nullable: true, maxSize: 1024*1024*2
        author nullable: false, blank: false
    }

    String toString(){
        "${title}"
    }
}
