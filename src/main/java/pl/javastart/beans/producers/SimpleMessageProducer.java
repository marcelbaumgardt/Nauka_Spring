package pl.javastart.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Message(type = Message.messageType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

    @Autowired
    @Qualifier("randomNumber")
    private  int random;

    @Override
    public String getMessage() {

        return "Test Message : "+ this + random;
    }
}