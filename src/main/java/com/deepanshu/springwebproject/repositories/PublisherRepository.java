package com.deepanshu.springwebproject.repositories;

import com.deepanshu.springwebproject.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
