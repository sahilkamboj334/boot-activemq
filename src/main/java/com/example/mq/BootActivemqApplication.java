package com.example.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableJms
public class BootActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootActivemqApplication.class, args);
	}
	@Autowired
	AppPropertyBean appProp;
	
	@Bean 
	public ActiveMQConnectionFactory factory() {
		return new ActiveMQConnectionFactory(appProp.brokerUrl);
	}
	
	@Bean
	@Autowired
	public JmsTemplate registerTemplate(ActiveMQConnectionFactory connectionFactory) {
		return new JmsTemplate(connectionFactory);
	}
	@Bean
	public javax.jms.Queue queue() {
		return new ActiveMQQueue(appProp.queueName);
	}
}
