package pl.javastart.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Message(type = Message.messageType.FILE)
//@PropertySource("classpath:appConfig.properties")
public class FileMessageProducer implements MessageProducer {

    @Value("${messageFileProperty}")
    private String messageFile;

    //@Autowired
   // Environment env;    inny sposob na dostanie zmiennej z pliku konfiguracyjnego

    @Override
    public String getMessage() {
        List<String> lines = null;
        try {
            //String fileName=env.getProperty("messageFileProperty");
            Path path = new File(getClass().getResource(messageFile).toURI()).toPath();
            lines = Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        String result = "";
        if (lines != null)
            result = lines.stream().reduce(result, (a, b) -> a + b);
        return result;
    }
}