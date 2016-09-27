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
    
    private final Word currentWord;
    private final int difficulty;
    private final String[] playerNames;
    private String currentPlayer;
    
    
    public Game(String word, int difficulty, String[] playerNames ){
        this.difficulty = difficulty;
        this.playerNames = playerNames;
        this.currentPlayer = playerNames[0];
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
    
    public int numberOfTurnsLeft(){
        //implement number of misses depending on game difficulty
        
        return 10 - currentWord.getWrongGuess();
    }
    
    public boolean gameLost(){
        //implement numbers of misses depeding on game difficulty
        boolean gameLost = false;
        if(10-currentWord.getWrongGuess()<= 0){
            gameLost = true;
        }
        return gameLost;
    }

    /**
     * @return the currentWord
     */
    public Word getCurrentWord() {
        return currentWord;
    }

    /**
     * @return the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @return the playerNames
     */
    public String[] getPlayerNames() {
        return playerNames;
    }

    /**
     * @return the currentPlayer
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
    
    //controleren of het spel is gewonnen of verloren
    
    //zet de juiste speler aan de beurt
    
    
    
    

