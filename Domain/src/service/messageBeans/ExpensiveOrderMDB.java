package service.messageBeans;

import entities.OrderDTO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Deniel on 30.09.2014.
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",propertyValue ="Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector",propertyValue ="orderAmount > 1000"),
})
public class ExpensiveOrderMDB implements MessageListener {

    public void onMessage(Message message) {
        try{
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Expensive order received: " + order.toString());
        }catch (JMSException exception){
            exception.printStackTrace();
        }
    }
}
