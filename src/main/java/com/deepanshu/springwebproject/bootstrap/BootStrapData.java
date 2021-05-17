package com.deepanshu.springwebproject.bootstrap;

import com.deepanshu.springwebproject.model.Author;
import com.deepanshu.springwebproject.model.Book;
import com.deepanshu.springwebproject.model.Publisher;
import com.deepanshu.springwebproject.repositories.AuthorRepository;
import com.deepanshu.springwebproject.repositories.BookRepository;
import com.deepanshu.springwebproject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap is running..");

        Publisher publisher = new Publisher("Jk Boss", "b-322", "Alwar", "Rajasthan", "301001");

        publisherRepository.save(publisher);

        System.out.println("Total Number of Publishers = " + publisherRepository.count());

        Author wells = new Author("H.G.", "Wells");
        Book book = new Book("Time Machine", "5678");

        wells.getBooks().add(book);
        book.getAuthors().add(wells);

        book.setPublisher(publisher);
        publisher.getBookSet().add(book);

        authorRepository.save(wells);
        bookRepository.save(book);
        publisherRepository.save(publisher);


        Author d = new Author("Deepanshu", "Chauhan");
        Book book1 = new Book("The Time", "1119765");

        d.getBooks().add(book1);
        book1.getAuthors().add(wells);

        book1.setPublisher(publisher);
        publisher.getBookSet().add(book1);

        authorRepository.save(d);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        System.out.println("Number of Books are = " + bookRepository.count());
        System.out.println("Number of Books of publisher = " + publisher.getBookSet().size());


    }
}
