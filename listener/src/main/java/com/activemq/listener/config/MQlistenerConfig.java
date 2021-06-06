package com.activemq.listener.config;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@EnableJms
@Component
public class MQlistenerConfig {
	
	
	@JmsListener(destination="queue.test")
	public void readMessage(String message) {
		System.out.println("the message is : "+message);
	}

}
