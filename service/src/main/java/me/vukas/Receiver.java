package me.vukas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @StreamListener(Sink.INPUT)
    public void exc(String str){
        System.out.println(str);
    }
}
