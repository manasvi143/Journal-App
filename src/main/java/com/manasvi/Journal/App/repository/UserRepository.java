package com.manasvi.Journal.App.repository;

import com.manasvi.Journal.App.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUsername(String username);

    void deleteByUsername(String username);
}
