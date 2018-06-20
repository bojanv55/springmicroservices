package me.vukas;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().authenticated(); //allow anyone that is authenticated

        //allow only to admin role GET methods in this path
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/comments/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }
}
