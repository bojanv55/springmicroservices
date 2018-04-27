package me.vukas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
	@Value("${some.prop}")
	private String someProp;

	public String getSomeProp() {
		return someProp;
	}
}
