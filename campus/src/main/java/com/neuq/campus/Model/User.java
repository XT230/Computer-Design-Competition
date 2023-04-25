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
@Document(collection = "User")
public class User
{
    @Id
    private ObjectId _id;
    private int uid;
    private String username;
    private String nickname;
    private String userPhone;
    private String password;
    private int sid;
    private int did;
    private boolean first;
    private long timestamp;
    private List<String> prefGenres = new ArrayList<>();
}
