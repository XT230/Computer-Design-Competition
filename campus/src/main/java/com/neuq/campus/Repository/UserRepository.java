package com.neuq.campus.Repository;

import com.neuq.campus.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>
{
    public Integer countByUsername(String username);

    public User findByUsernameAndPassword(String username, String password);
    public User findUserByUid(int uid);

    public User deleteUserByUid(int uid);

}
