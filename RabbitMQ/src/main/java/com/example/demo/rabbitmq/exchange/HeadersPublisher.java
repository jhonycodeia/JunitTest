package com.example.demo.rabbitmq.exchange;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**FanoutExchange
 * Trasporta el mensaje a todas las Queues que cumple con cualquiera de los argumentos,argumento indica un 
 * una key -> value, que se debe cumplir para enviar
 * Queue: x-match "any" cualquier argumento se cumpla "all" todos argumentos se cumplan
 * TV->{"x-match":"any","item1":"tv",item2":"television"}
 * Mobile->{"x-match":"any","item1":"mobile",item2":"mob"}
 * AC->{"x-match":"all","item1":"mobile",item2":"ac"}
 * @author jsarria
 *
 */
public class HeadersPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and TV";
		
		Map<String, Object> headersMap = new HashMap<String, Object>();
		
		headersMap.put("item1", "mobile");
		headersMap.put("item2", "ac");
		
		BasicProperties br = new BasicProperties();
		br = br.builder().headers(headersMap).build();
		
		channel.basicPublish("headers-exchange", "", br, message.getBytes());
		
		channel.close();
		connection.close();
	}

}
