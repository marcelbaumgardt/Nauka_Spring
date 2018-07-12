package pl.javastart.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Random;

@Configuration
@PropertySource("classpath:appConfig.properties")
public class AppConfig {

    /*
    @Bean
    @Qualifier("messageFile")
    public String configFileName()
    {
        return"/message.txt";
    }*/

    @Bean
    @Qualifier("randomNumber")
    public int getRandomNumber()
    {
        return new Random().nextInt();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
