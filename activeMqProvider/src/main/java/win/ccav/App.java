package win.ccav;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * Hello world!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-mq.xml"})
public class App {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Destination testQueueDestination;

    @Test
    public void test(){
        jmsTemplate.send(testQueueDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage=session.createMapMessage();
                mapMessage.setString("name","tom");
                mapMessage.setString("age","1086");
                return mapMessage;
            }
        });
    }
}
