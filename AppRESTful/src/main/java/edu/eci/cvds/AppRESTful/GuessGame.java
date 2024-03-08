package edu.eci.cvds.AppRESTful;

import java.util.concurrent.ThreadLocalRandom;

public class GuessGame {
    private int prize;
    private int attempts;

    private int numberToGuess;


    public GuessGame() {
        prize = 0;
        attempts= 0;
        numberToGuess = generateRandomNumer();
    }

    private int generateRandomNumer(){
        return ThreadLocalRandom.current().nextInt(1, 11);
    }

    public void makeGuess(int guess) throws IllegalArgumentException{
        if (guess > 10 || guess < 1){
            throw new IllegalArgumentException("Número fuera de rango [1,10]. Intente nuevamente.");
        }
        attempts += 1;
        if (numberToGuess == guess){
            prize += 100000;
        }
        else {
            prize -= 10000;
        }
        numberToGuess = generateRandomNumer();
    }

    public int getPrize() {
        return prize;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public void reset(){
        prize = 0;
        attempts = 0;
    }
}
