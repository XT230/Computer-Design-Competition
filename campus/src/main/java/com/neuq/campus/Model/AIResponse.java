package com.neuq.campus.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIResponse
{
    private String id;
    private String object;
    private long created;
    private String model;
    private Usage usage = new Usage();
    private List<Choice> choices = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage
    {
        private String prompt_tokens;
        private String completion_tokens;
        private String total_tokens;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice
    {
        private AIMessage.Message message = new AIMessage.Message();
        private String finish_reason;
        private int index;
    }
}
