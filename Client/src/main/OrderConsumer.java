package main;

import entities.OrderDTO;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Deniel on 30.09.2014.
 */
public class OrderConsumer {

    public static void main(String[] args) throws NamingException{
        // Arrange - get the JNDI context
        Context jndiContext = new InitialContext();

        // Act - looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

        // Act - loops to receive the messages
        System.out.println("\nInfinite loop. Waiting for a message...");
        try(JMSContext jmsContext = connectionFactory.createContext()){
            while (true){
                OrderDTO order = jmsContext.createConsumer(topic).receiveBody(OrderDTO.class);
                System.out.println("Order received: " + order);
            }
        }
    }
}
