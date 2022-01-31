package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {

//    private static final Logger log = LoggerFactory.getLogger(Main.class);
    //private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");
        SpringApplication.run(Main.class, args);

        // == create context(container)
//        ConfigurableApplicationContext context =
//                new ClassPathXmlApplicationContext(CONFIG_LOCATION);
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        new AnnotationConfigApplicationContext(GameConfig.class);
        // get number generator bean from context(container)
//        NumberGenerator generator = context.getBean(NumberGenerator.class);
        // == call method next() to get a random number
//        int number = generator.next();
        // == log generated number ==
//        log.debug("number = {}", number);

        // get game bean from context(container)
//        Game game = context.getBean(Game.class);
//        game.reset();
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("getMainMessage = {} ", messageGenerator.getMainMessage());
//        log.info("getResultMessage = {} ", messageGenerator.getResultMessage());


        // close context(container)
//        context.close();
    }

}
