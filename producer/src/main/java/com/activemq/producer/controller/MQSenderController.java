package com.activemq.producer.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableJms
public class MQSenderController {
	
	@Autowired
	public JmsTemplate jmstemplate;
	
	@Qualifier("testQueue")
	@Autowired
	public Queue queue;
	
	@GetMapping("/get")
	public String get() {
		jmstemplate.convertAndSend(queue, "try!!!");
		return "get api";
	}

}
