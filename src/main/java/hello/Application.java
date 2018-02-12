package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application{
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

     @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context){
        return args -> {
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName: beanNames){
                System.out.println(beanName);
            }
        };

    }
}