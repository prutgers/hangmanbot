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
    private final String[] playerList;
    private String currentPlayer;
    private final String gameID;
    private int currentNumberOfPlayers;
    private final int maxNumberOfPlayers;
    
    
    public Game(int difficulty, String player, int numberOfPlayers){
        this.difficulty = 0;
        this.playerList = new String[numberOfPlayers];
        this.playerList[0] = player;
        currentWord = new Word();
        this.gameID = player;
        this.maxNumberOfPlayers = numberOfPlayers;
        this.currentNumberOfPlayers = 1;
    }
    
    public Game(int difficulty, String player){
        this.difficulty = 0;
        this.playerList = new String[]{player};
        this.currentPlayer = player;
        this.currentWord = new Word();
        this.gameID = player;
        this.maxNumberOfPlayers = 1;
        this.currentNumberOfPlayers = 1;
        
    }
    
    public int numberOfTurnsLeft(){
        //implement number of misses depending on game difficulty
        
        return 10 - currentWord.getWrongGuess();
    }
    
    public void updateCurrentNumberOfPlayers(){
        currentNumberOfPlayers = currentNumberOfPlayers +1;
        if(currentNumberOfPlayers == maxNumberOfPlayers){
            currentPlayer = playerList[0];
        }
    }
    
    public boolean gameLost(){
        //implement numbers of misses depeding on game difficulty
        boolean gameLost = false;
        if(10-currentWord.getWrongGuess()<= 0){
            gameLost = true;
        }
        return gameLost;
    }
    
    public String getGameID(){
        return gameID;
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
    public String[] getPlayerList() {
        return playerList;
    }

    /**
     * @return the currentPlayer
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @return the currentNumberOfPlayers
     */
    public int getCurrentNumberOfPlayers() {
        return currentNumberOfPlayers;
    }

    /**
     * @param currentNumberOfPlayers the currentNumberOfPlayers to set
     */
    public void setCurrentNumberOfPlayers(int currentNumberOfPlayers) {
        this.currentNumberOfPlayers = currentNumberOfPlayers;
    }

    /**
     * @return the maxNumberOfPlayers
     */
    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }
}
    
    //controleren of het spel is gewonnen of verloren
    
    //zet de juiste speler aan de beurt
    
    
    
    

