package main;

import entities.OrderDTO;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

/**
 * Created by Deniel on 30.09.2014.
 */
public class OrderProducer {

    public static void main(String[] args) throws NamingException{
        // Arrange - create an orderDTO with a total amount parameter
        Float totalAmount = Float.valueOf("1700");
        OrderDTO order = new OrderDTO(1234l, new Date(),"Bla Bla", totalAmount);

        // Arrange - get the JNDI context
        Context jndiContext = new InitialContext();

        // Act - looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination)jndiContext.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
            // Act - sends an object message to the topic
            jmsContext.createProducer().setProperty("orderAmount", totalAmount).send(topic, order);
            System.out.println("\nOrder sent : " + order.toString());
        }
    }
}
