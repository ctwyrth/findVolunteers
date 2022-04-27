package com.amt.findvolunteers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amt.findvolunteers.models.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    // this method retrieves all from the database
    List<UserProfile> findAll();

}