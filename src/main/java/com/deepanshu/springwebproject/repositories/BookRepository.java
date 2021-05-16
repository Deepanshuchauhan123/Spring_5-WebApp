package com.deepanshu.springwebproject.repositories;

import com.deepanshu.springwebproject.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Author,Long> {

}
