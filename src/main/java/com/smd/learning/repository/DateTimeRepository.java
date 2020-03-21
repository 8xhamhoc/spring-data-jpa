package com.smd.learning.repository;

import com.smd.learning.entity.DateTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DateTimeRepository extends CrudRepository<DateTime, Long> {

    List<DateTime> findByValue(String value);

}
