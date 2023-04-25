package com.neuq.campus.Repository;

import com.neuq.campus.Model.School;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<School, Integer>
{
    public School getBySid(int sid);
}
