package me.vukas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private Source source;

    public void pub(){
        source.output().send(MessageBuilder.withPayload("pyld").build());
    }

}
