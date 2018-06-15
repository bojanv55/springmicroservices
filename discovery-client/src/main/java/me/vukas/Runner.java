package me.vukas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        //licsrv is replaced with actual server address fetched from eureka
        ResponseEntity<String> rspns =
        restTemplate.exchange("http://licsrv/comments/text", HttpMethod.GET
        ,null, String.class);

        System.out.println(rspns.getBody());
    }
}
