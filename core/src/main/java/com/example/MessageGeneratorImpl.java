package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    // == constants ==
    public static final String MAIN_MESSAGE = "game.main.message";
    public static final String  WIN_MESSAGE = "game.win";
    public static final String LOST_MESSAGE = "game.lost";
    public static final String GAME_INVALID = "game.invalid";
    public static final String FIRST_CHOICE = "game.first.choice";
    public static final String GAME_HIGHER = "game.higher.dir";
    public static final String GAME_LOWER = "game.lower.dir";
    public static final String GAME_GUESSES_LEFT = "game.left.guess";

    //@Autowired
    private final Game game;
    private final MessageSource messageSource;

    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        log.info("The game = {} ", this.game);
    }
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
//        return "Number is between " +
//                game.getSmallest() + " and " +
//                game.getBiggest() +
//                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            //return "You guessed it! The number was " + game.getNumber();
            return getMessage(WIN_MESSAGE, game.getNumber());
        }
        else if(game.isGameLost()) {
            //return "You lost. The number was " + game.getNumber();
            return getMessage(LOST_MESSAGE, game.getNumber());
        }
        else if(!game.isValidNumberRange()) {
            //return "Invalid number range";
            return getMessage(GAME_INVALID);
        }
        else if(game.getRemainingGuesses() == game.getGuessCount()) {
            //return "What is your first guess?";
            return getMessage(FIRST_CHOICE);
        }
        else {
            String direction = getMessage(GAME_LOWER);//"Lower";
            if(game.getGuess() < game.getNumber()) {
                direction = getMessage(GAME_HIGHER);//"Higher";
            }
            //return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
            return getMessage(GAME_GUESSES_LEFT, direction, game.getRemainingGuesses());
        }
    }
    // == private messages ==
    private String getMessage(String code, Object...args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
