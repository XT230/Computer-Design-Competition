package com.neuq.campus.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuq.campus.Model.AIMessage;
import com.neuq.campus.Model.AIResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Service
@ServerEndpoint("/websocket/{uid}")
public class WebSocketServer
{
    private static int onlineCount = 0;
    private static Map<Integer, WebSocketServer> webSocketServerMap = new HashMap<>();
    private Session session;
    private Integer uid;

    @OnOpen
    public void onOpen(@PathParam("uid") Integer uid, Session session)
    {
        this.session = session;
        this.uid = uid;
        webSocketServerMap.put(uid, this);
        addOnlineCount();
    }

    @OnClose
    public void onClose()
    {
        webSocketServerMap.remove(this.uid);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message, Session session)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(message + ":" + uid);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer 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");
        headers.add("Content-Type", "application/json");
        try
        {
            AIMessage aiMessage = objectMapper.readValue(message, AIMessage.class);
            HttpEntity<AIMessage> httpEntity = new HttpEntity<>(aiMessage, headers);
            AIResponse aiResponse = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", httpEntity, AIResponse.class).getBody();
            if(aiResponse == null)
            {
                AIMessage.Message message1 = new AIMessage.Message("assistant", "抱歉，出错了");
            }
            else
            {
                AIMessage.Message message1 = aiResponse.getChoices().get(0).getMessage();

                session.getBasicRemote().sendText(objectMapper.writeValueAsString(message1));
                System.out.println(aiResponse);
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void addOnlineCount()
    {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount()
    {
        WebSocketServer.onlineCount--;
    }
}
