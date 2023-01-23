package cs4760progassign

class Book {

    String title
    int publishyear
    static belongsTo = [author: Author]

    static constraints = {
    }
    String tostatic(){
        "${title}"
    }


}
