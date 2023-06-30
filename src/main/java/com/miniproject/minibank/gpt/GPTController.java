package com.miniproject.minibank.gpt;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/api/gpt")
@RequiredArgsConstructor
public class GPTController {

    private final ChatService chatService;
    private final ChatgptService chatgptService;

    @PostMapping("/test")
    public String test(@RequestBody String question) throws ParseException, JsonProcessingException {
        String answer = chatService.getChatResponse(question);
        JSONParser jsonParser = new JSONParser();

        Object obj = jsonParser.parse(answer);
        JSONObject jsonObject = (JSONObject) obj;
        Map<String, Object> map = new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);
        for(String key : map.keySet()) {
            System.out.println("key : " + key + " value : " + map.get(key));
        }

        return answer;
    }


}
