package com.example.demo.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**FanoutExchange
 * Trasporta el mensaje a todas las Queues asociadas al patron que se envia,key indica un patron de validacion
 * Queue: TV->*.tv.* , Mobile->*.mobile.*, AC->#.ac
 * @author jsarria
 *
 */
public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and AC";
		
		channel.basicPublish("topic-exchange", "tv.mobile.ac", null, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
