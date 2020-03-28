package com.smd.learning.repository;

import com.smd.learning.entity.BoxTurtle;
import com.smd.learning.entity.BoxTurtleId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxTurtleRepository extends CrudRepository<BoxTurtle, BoxTurtleId> {

    List<BoxTurtle> findByName(String name);

}
