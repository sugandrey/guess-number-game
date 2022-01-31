package com.example.console;

import com.example.Game;
import com.example.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {
    // public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> { // the first way
// == constants ==
//    public static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    // == fields ==
    //@Autowired
    private final Game game;
    //@Autowired
    private final MessageGenerator messageGenerator;

    // == constructor ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == events ==
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) { // the first way
//        log.info("Container is ready for use.");
//    }

    @EventListener(ContextRefreshedEvent.class) // another way
    public void start() {
        log.info("start() --> Container is ready for use.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? Y/N");
                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }
                game.reset();
            }

        }
    }
}
