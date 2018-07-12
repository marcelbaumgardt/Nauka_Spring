package pl.javastart.app;

import pl.javastart.beans.printers.MessagePrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pl.javastart")
//@ComponentScan(basePackageClasses = MessagePrinter.class)
public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiApplication.class);
        MessagePrinter printer=ctx.getBean(MessagePrinter.class);
        printer.print();
        ctx.close();
    }
}
