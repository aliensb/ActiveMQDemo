package win.ccav;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by Administrator on 2017/11/14.
 */
public class TestComsumer implements SessionAwareMessageListener<Message> {
    private Destination destination;

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void onMessage(Message message, Session session) throws JMSException {
        if (message instanceof MapMessage){
            String name=((MapMessage) message).getString("name");
            String age=((MapMessage) message).getString("age");
            System.out.println(name);
            System.out.println(age);
        }
    }
}
