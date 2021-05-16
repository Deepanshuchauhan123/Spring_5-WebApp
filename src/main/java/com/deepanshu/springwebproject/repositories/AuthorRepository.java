package com.deepanshu.springwebproject.repositories;

import com.deepanshu.springwebproject.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Book, Long> {
}
