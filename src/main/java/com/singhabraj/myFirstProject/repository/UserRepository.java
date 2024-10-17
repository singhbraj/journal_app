package com.singhabraj.myFirstProject.repository;

import com.singhabraj.myFirstProject.entity.JournalEntry;
import com.singhabraj.myFirstProject.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
    void deleteByUserName(String userName);
}
