package ravi.gaurav.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ravi.gaurav.Game;
import ravi.gaurav.MessageGenerator;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            game.setGuess(guess);
            game.check();
            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n");
                String playAgainString = scanner.nextLine();
                if (playAgainString.equalsIgnoreCase("y")){
                    game.reset();
                } else break;
            }
        }
    }
}
