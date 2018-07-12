package pl.javastart.beans.printers;


import pl.javastart.beans.decorators.MessageDecorator;
import pl.javastart.beans.producers.Message;
import pl.javastart.beans.producers.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessagePrinter {


   MessageProducer producer;
   MessageDecorator decorator;

    @Autowired
    public MessagePrinter(@Message(type=Message.messageType.FILE) MessageProducer producer) {
        this.producer = producer;
    }


    public MessageDecorator getDecorator() {
        return decorator;
    }

    @Autowired(required = false)
    public void setDecorator(MessageDecorator decorator) {
        this.decorator = decorator;
    }

    public void print() {

        String message=producer.getMessage();
        message = decorator!=null?decorator.decorate(message):message;
        System.out.println(message);
    }
}
