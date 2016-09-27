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
public class GameSettings {
    
    private Word currentWord;
    private int difficulty;
    private String[] playerNames;
    
    
    public GameSettings(String word, int difficulty, String[] playerNames ){
        this.difficulty = difficulty;
        this.playerNames = playerNames;
        if(word.equalsIgnoreCase("default")){
            currentWord = new Word();
        } else {
            currentWord = new Word(word);
        }
    }
    
    
    
    
    
}
