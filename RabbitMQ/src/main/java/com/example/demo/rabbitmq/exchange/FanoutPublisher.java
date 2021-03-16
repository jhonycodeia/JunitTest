package com.example.demo.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**FanoutExchange
 * Trasporta el mensaje a todas las Queues asociadas no requiere key de referencia
 * Queue: TV, Mobile, AC
 * @author jsarria
 *
 */
public class FanoutPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message For Mobile and AC";
		
		channel.basicPublish("fanout-exchange", "", null, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
