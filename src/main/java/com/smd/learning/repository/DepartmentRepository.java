package com.smd.learning.repository;

import com.smd.learning.entity.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    List<Department> findByName(String name);

}
