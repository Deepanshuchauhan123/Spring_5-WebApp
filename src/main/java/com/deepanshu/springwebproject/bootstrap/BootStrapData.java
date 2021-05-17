package com.deepanshu.springwebproject.bootstrap;

import com.deepanshu.springwebproject.model.Author;
import com.deepanshu.springwebproject.model.Book;
import com.deepanshu.springwebproject.repositories.AuthorRepository;
import com.deepanshu.springwebproject.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author wells = new Author("H.G.", "Wells");
        Book book = new Book("Time Machine", "5678");

        wells.getBooks().add(book);
        book.getAuthors().add(wells);

        authorRepository.save(wells);
        bookRepository.save(book);

        Author d = new Author("Deepanshu", "Chauhan");
        Book book1 = new Book("The Time", "1119765");

        d.getBooks().add(book);
        book1.getAuthors().add(wells);

        authorRepository.save(d);
        bookRepository.save(book1);

        System.out.println("Bootstrap is running..");
        System.out.println("Number of Books are = " + bookRepository.count());

    }
}
