package com.neuq.campus.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Article")
public class Article
{
    @Id
    private ObjectId _id;
    private long aid;
    private int uid;
    private String content;
    private String title;
    private int type;
    private List<String> tags = new ArrayList<>();
    private long timestamp;
}
