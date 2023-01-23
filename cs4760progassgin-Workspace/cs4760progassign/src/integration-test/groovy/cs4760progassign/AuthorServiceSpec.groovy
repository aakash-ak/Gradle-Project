package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorServiceSpec extends Specification {

    AuthorService authorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save(flush: true, failOnError: true)
        new Author(name:"Mark Twain")
                .addToBooks(new Book(title:"Tom Sawyer", publishYear:1876))
                .addToBooks(new Book(title:"Huckelberry Finn", publishYear:1884))
                .save(flush: true, failOnError: true)
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save(flush: true, failOnError: true)
        new Author(name:"Mark Twain")
                .addToBooks(new Book(title:"Tom Sawyer", publishYear:1876))
                .addToBooks(new Book(title:"Huckelberry Finn", publishYear:1884))
                .save(flush: true, failOnError: true)
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save(flush: true, failOnError: true)
    }
    void "test basic Author Book persistence"(){
        setup:
        new Author(name:"Stephen King")
                .addToBooks(new Book(title:"The Stand", publishYear:1978))
                .addToBooks(new Book(title:"The Shining", publishYear:1977))
                .save(flush: true, failOnError: true)
        new Author(name:"Mark Twain")
                .addToBooks(new Book(title:"Tom Sawyer", publishYear:1876))
                .addToBooks(new Book(title:"Huckelberry Finn", publishYear:1884))
                .save(flush: true, failOnError: true)
        expect:
        Author.count == 2
        Book.count == 4
        Author.findByName("Stephen King").books.size() == 2
        Author.findByName("Mark Twain").books.size() == 2
    }
    void "test get"() {
        setupData()

        expect:
        authorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Author> authorList = authorService.list(max: 2, offset: 2)

        then:
        authorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        authorService.count() == 5
    }

    void "test delete"() {
        Long authorId = setupData()

        expect:
        authorService.count() == 5

        when:
        authorService.delete(authorId)
        sessionFactory.currentSession.flush()

        then:
        authorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Author author = new Author()
        authorService.save(author)

        then:
        author.id != null
    }
}
