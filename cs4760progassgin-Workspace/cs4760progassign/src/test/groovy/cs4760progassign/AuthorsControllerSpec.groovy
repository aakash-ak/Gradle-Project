package cs4760progassign

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AuthorsControllerSpec extends Specification implements ControllerUnitTest <AuthorsController>, DataTest {
    def setupSpec(){
        mockDomains Author, Book
    }
    void 'Test the index method returns the correct model'(){
        given:
        new Author(name:"Author A")
                .addToBooks(new Book(title:"Title A", publishYear:1978))
                .addToBooks(new Book(title:"Title B", publishYear:1876))
                .save(flush: true, failOnError: true)
        new Author(name:"Author B")
                .addToBooks(new Book(title:"Title C", publishYear:1978))
                .addToBooks(new Book(title:"Title D", publishYear:1876))
                .save(flush: true, failOnError: true)

        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        model.athrList
        model.athrList.size() == 2
        model.athrList == [
                [author: "Author A",books:[
                [title: "Title A"],
                [title: "Title B"]]
        ],
        [author: "Author B", books:[
                [title: "Title C"],
                [title: "Title D"]],
        ]
    ]
    } // End 'Test the index method returns the correct model'
}