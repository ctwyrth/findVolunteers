package com.amt.findvolunteers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amt.findvolunteers.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    // this method retrieves all from the database
    List<Category> findAll();

}