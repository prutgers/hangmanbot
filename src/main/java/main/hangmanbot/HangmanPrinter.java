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
public class HangmanPrinter {
    
    
    
    /**
    public String printHangman(int wrongGuesses){
        for(wrongGuesses; >0;wrongGuesses--){
            
        }
        
        return String "" + wrongGuesses;
        
    }
    */
    
    
    public String checkLoss(Word word){
        String lost = "";
        if(word.getWrongGuess()<10){
            lost = "Je hebt nog " + (10-word.getWrongGuess()) + " pogingen over.";
                    
        }
        else {
            lost = "Je hebt verloren";
        }
        
        return lost;
    }
}
