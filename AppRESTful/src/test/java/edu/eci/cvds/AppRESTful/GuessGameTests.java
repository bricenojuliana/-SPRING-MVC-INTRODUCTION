package edu.eci.cvds.AppRESTful;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GuessGameTests {
    @Test
    public void should_addScore_when_correctGuess(){
        //Given
        GuessGame guessGame = new GuessGame();
        int numberToGuess = 1;
        int guess = 1;
        int price = 100000;

        //When
        guessGame.setNumberToGuess(numberToGuess);
        guessGame.makeGuess(guess);

        //Assert
        assertEquals(price, guessGame.getPrize());
    }

    @Test
    public void should_penalize_when_incorrectGuess(){
        //Given
        GuessGame guessGame = new GuessGame();
        int numberToGuess = 1;
        int guess = 2;
        int price = -10000;

        //When
        guessGame.setNumberToGuess(numberToGuess);
        guessGame.makeGuess(guess);

        //Assert
        assertEquals(price, guessGame.getPrize());
    }
    

    @Test
    public void should_addAttempt_when_makeGuess(){
        //Given
        GuessGame guessGame = new GuessGame();
        int guess = 1;
        int attempts = 1;

        //When
        guessGame.makeGuess(guess);

        //Assert
        assertEquals(attempts, guessGame.getAttempts());
    }

    @Test
    public void should_guess_when_numberBetween1And10(){
        //Given
        GuessGame guessGame = new GuessGame();
        int guess1 = 1;
        int guess2 = 10;
        int attempts = 2;

        //When
        guessGame.makeGuess(guess1);
        guessGame.makeGuess(guess2);

        //Assert
        assertEquals(attempts, guessGame.getAttempts());
    }

    @Test
    public void should_throwException_when_numberOutOfRange(){
        //Given
        GuessGame guessGame = new GuessGame();
        int guess1 = 0;
        int guess2 = 11;
        int guess3 = -1000;
        int guess4 = 1000;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> guessGame.makeGuess(guess1));
        Assert.assertThrows(IllegalArgumentException.class, () -> guessGame.makeGuess(guess2));
        Assert.assertThrows(IllegalArgumentException.class, () -> guessGame.makeGuess(guess3));
        Assert.assertThrows(IllegalArgumentException.class, () -> guessGame.makeGuess(guess4));
    }
}
