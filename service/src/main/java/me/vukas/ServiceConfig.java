package me.vukas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//@RefreshScope	//accessing this via POST to /actuator/refresh endpoint. Refreshes someProp if there is new value on config server.
public class ServiceConfig {
	@Value("${some.prop}")
	private String someProp;

	public String getSomeProp() {
		return someProp;
	}
}
