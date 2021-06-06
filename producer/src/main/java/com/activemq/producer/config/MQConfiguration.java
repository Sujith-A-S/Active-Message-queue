package com.activemq.producer.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * MQ config class
 *
 */
@Configuration
public class MQConfiguration {
	
	@Value("${spring.activemq.broker-url}")
	public String url;
	
	/**
	 * Queue name configuration
	 * 
	 * @return queue
	 */
	@Bean(name="testQueue")
	public Queue setupQueue() {
		return new ActiveMQQueue("queue.test");
	}
	
	/**
	 * Configuring connection factory 
	 * 
	 * @return active Mq connection factory
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory= new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(url);
		return activeMQConnectionFactory;
	}
	
	/**
	 * bean creation for JmsTemplate to transmit the message to listener
	 * 
	 * @return JmsTemplate
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}

	
	

}
