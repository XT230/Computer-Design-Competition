package com.neuq.campus.Repository;

import com.neuq.campus.Model.Degree;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DegreeRepository extends MongoRepository<Degree, Integer>
{
    public Degree getByDid(int did);
}
