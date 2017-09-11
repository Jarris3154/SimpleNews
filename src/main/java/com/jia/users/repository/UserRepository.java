package com.jia.users.repository;

import com.jia.users.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    public List<User> findAll();
}
