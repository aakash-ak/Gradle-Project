package cs4760progassign

class Author {

    String name
    static hasMany = [books : Book]

    static constraints= {
    }

    String tostring(){
        "${name}"

    }
}
