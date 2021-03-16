package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@GetMapping("/testExample/{name}")
	public String testAPIExample(@PathVariable("name") String name) {
		Person p = new Person(1L, name);
		rabbitTemplate.convertAndSend("Mobile", p);
		rabbitTemplate.convertAndSend("direct-exchange", "mobile", p);
		rabbitTemplate.convertAndSend("fanout-exchange", "", p);
		rabbitTemplate.convertAndSend("topic-exchange", "tv.mobile.ac", p);
		
		return "Success";
	}
	
	@GetMapping("/test/{name}")
	public String testAPI(@PathVariable("name") String name) throws IOException {
		Person p = new Person(1L, name);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject(p);
		out.flush();
		out.close();
		
		byte[] byteMessage = bos.toByteArray();
		bos.close();
		
		Message message = MessageBuilder.withBody(byteMessage)
				.setHeader("item1", "mobile")
				.setHeader("item2", "television").build();
		
		rabbitTemplate.send("headers-exchange", "", message);
		
		return "Success";
	}
	
	@GetMapping("/defaultExchange/{name}")
	public String defaultExchange (@PathVariable String name) {
		Person p = new Person(1L, name);
		rabbitTemplate.convertAndSend("Mobile", p);
		
		return "Success";
	}
}
