/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Peter
 */
public final class Word {
    private final String toGuess;
    private String guessedBot = "";
    private String guessed = "";
    private int wrongGuess = 0;
    private Set<Character> guessedLetters = new HashSet<Character>();
    
    public Word(){
        //dit is nu nog standaard maar moet straks uit een document komen
         System.out.println("hallo");
        toGuess = WordGenerator.kiesRandomWoord(Math.random());
        System.out.println(toGuess);
        countGuessed(toGuess);
    }    
    
    public Word(String word){
        this.toGuess = word;
        countGuessed(word);
    }
    
    public int getWrongGuess(){
        return this.wrongGuess;
    }
    
    public String getGuessed(){
        return this.guessed;
    }
    
    public Set<Character> getGuessedLetters(){
        return guessedLetters;
    }
        
    
    //volgens mij kan deze ook wel private
    private void countGuessed(String toGuess){
        for(int i=0 ; i < toGuess.length() ;i++){
            this.guessed = this.guessed + "* ";
            this.guessedBot = this.guessedBot + "*";
        }
    }
    
    public boolean checkWord(String guess){
        Boolean goodGuess = false;
        if(guess.equalsIgnoreCase(toGuess)){
            goodGuess = true;
        }
        else{
            wrongGuess = ++wrongGuess;
        }
        
        return goodGuess;
    }
    
    //Checks if a guessed character is in the word.
    public boolean checkGuess(char guess){
        boolean goodGuess = false;
        guessedLetters.add(guess);
        for(int i = 0; i < toGuess.length();i++){
            if(guess == toGuess.charAt(i)){
                goodGuess = true;
            }
        }
        if(goodGuess == false){
            wrongGuess = ++wrongGuess;
        }
        return goodGuess;
    }
    
    public void guessFound(char guess){
        String newGuess = "";
        for(int i = 0; i < toGuess.length();i++){
            if(toGuess.charAt(i) == guess){
                newGuess = newGuess + guess;
            }
            else {
                newGuess = newGuess + guessedBot.charAt(i);
            }
        }
        guessedBot = newGuess;
        formatGuessedBot(newGuess);
    }

    private void formatGuessedBot(String guess){
        String guessed = "";
        for(int i =0;i<guess.length();i++){
            if(i == 0){
            guessed = "" + guess.charAt(i);
            }
            else{
                guessed = guessed + " " + guess.charAt(i);
            }
        }
        this.guessed = guessed;
    }
}
