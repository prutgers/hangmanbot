/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

/**
 *
 * @author Peter
 */
public class Game {
    
    private Word currentWord;
    private int difficulty;
    private String[] playerNames;
    private String currentPlayer;
    
    
    public Game(String word, int difficulty, String[] playerNames ){
        this.difficulty = difficulty;
        this.playerNames = playerNames;
        this.currentPlayer = 0;
        if(word.equalsIgnoreCase("default")){
            currentWord = new Word();
        } else {
            currentWord = new Word(word);
        }
    }
    
    public Game(int difficulty, String player){
        this.difficulty = 0;
        this.playerNames = new String[]{player};
        this.currentPlayer = player;
        this.currentWord = new Word();
        
    }
    }
    
    //controleren of het spel is gewonnen of verloren
    
    //zet de juiste speler aan de beurt
    
    
    public boolean letterZitErin(Character guess){
        return currentWord.checkGuess(guess);
    }
    
}
