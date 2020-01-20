package com.example.mq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.mq.AppPropertyBean;

@Component
public class MsgListner {

	@Autowired
	 AppPropertyBean appProp;
	@JmsListener(destination ="test-queue",concurrency = "5")
	public void listen(String msg) {
		System.out.println("-------------->"+msg);
	}
}
