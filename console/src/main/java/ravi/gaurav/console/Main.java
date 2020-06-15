package ravi.gaurav.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ravi.gaurav.config.AppConfig;
import ravi.gaurav.Game;
import ravi.gaurav.MessageGenerator;
import ravi.gaurav.NumberGenerator;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        // == create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       /* NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next to gea a random number

        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get the game bean context (container)
        Game game = context.getBean(Game.class);

        //get the message generator
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("Message generator fun getMainMessage == {} ", messageGenerator.getMainMessage());
        log.info("Message generator fun getResultMessage == {} ", messageGenerator.getResultMessage());

        //Close context*/
        context.close();


    }
}
