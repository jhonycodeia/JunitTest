package com.example.demo.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**DirectExchange
 * Trasporta el mensaje a la Queues la cual corresponde el key que se hace referencia
 * Queue: TV->tv , Mobile->mobile, AC->ac
 * @author jsarria
 *
 */
public class DirectConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String (delivery.getBody());
			System.out.println("Message received = " + message);
		};
		channel.basicConsume("TV", true, deliverCallback, consumerTag -> {});
	}

}
