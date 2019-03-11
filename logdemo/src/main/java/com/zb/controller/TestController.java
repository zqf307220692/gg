package com.zb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping(value ="/send")
    @ResponseBody
    public String send(){
        for(int i=0;i<10;i++){
            kafkaTemplate.send("dmservice","dm","hello kafuka--->"+i);

        }
        return "ok";
    }
}
