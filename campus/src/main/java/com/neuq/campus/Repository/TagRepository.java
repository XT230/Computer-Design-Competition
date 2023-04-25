package com.neuq.campus.Repository;

import com.neuq.campus.Model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String>
{

}
