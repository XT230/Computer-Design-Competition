package com.neuq.campus.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIMessage
{
    private String model;
    private List<Message> messages = new ArrayList<>();
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message
    {
        public String role;
        public String content;
    }

}
