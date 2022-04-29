package com.amt.findvolunteers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amt.findvolunteers.models.EventPic;

@Repository
public interface EventPicRepository extends CrudRepository<EventPic, Long>{
	List<EventPic> findAll();
}
