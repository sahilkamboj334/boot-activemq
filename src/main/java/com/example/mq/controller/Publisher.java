package com.example.mq.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

	@Autowired
	JmsTemplate tmp;
	@Autowired
	Queue queue;
	
	@GetMapping(value="/publish/{msg}")
	public ResponseEntity<String> publish(@PathVariable("msg") String msg){
		tmp.convertAndSend(queue, msg);
		return new ResponseEntity<String>("Published-->"+msg, HttpStatus.OK);
	}
}
