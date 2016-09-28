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
public class HangmanPrinter implements ServerSettings{
    
    
    
    private HangmanPrinter(){
       
    }
    //Probably the most ugly method ever written this prints out the state of the Hangman depending on how many wrong guesses you made.
    //would be nice to implement a difficulty modus
    public static void printHangman(int wrongGuesses){
        String[] hangman; 
        
        if(wrongGuesses == 10){
            hangman = new String[8];
            hangman[7]= "      _______";
            hangman[6]= "     |/      |" ;
            hangman[5]= "     |      (_)" ;
            hangman[4]= "     |      \\|/" ;
            hangman[3]= "     |       |"; 
            hangman[2]= "     |      / \\ ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        } else if(wrongGuesses == 9){
            hangman = new String[8];
            hangman[7]= "      _______";
            hangman[6]= "     |/      |" ;
            hangman[5]= "     |      (_)" ;
            hangman[4]= "     |      \\|/" ;
            hangman[3]= "     |       |"; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        } else if(wrongGuesses == 8){
            hangman = new String[8];
            hangman[7]= "      _______";
            hangman[6]= "     |/      |" ;
            hangman[5]= "     |      (_)" ;
            hangman[4]= "     |      \\|/" ;
            hangman[3]= "     |       "; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 7){
            hangman = new String[8];
            hangman[7]= "      _______";
            hangman[6]= "     |/      |" ;
            hangman[5]= "     |      (_)" ;
            hangman[4]= "     |    " ;
            hangman[3]= "     |    "; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 6){
            hangman = new String[8];
            hangman[7]= "      _______";
            hangman[6]= "     |/      " ;
            hangman[5]= "     |      " ;
            hangman[4]= "     |     " ;
            hangman[3]= "     |       "; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 5){
            hangman = new String[7];
            hangman[6]= "     |/      " ;
            hangman[5]= "     |      " ;
            hangman[4]= "     |     " ;
            hangman[3]= "     |       "; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 4){
            hangman = new String[6];
            hangman[5]= "     |      " ;
            hangman[4]= "     |     " ;
            hangman[3]= "     |       "; 
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 3){
            hangman = new String[3];
            hangman[2]= "     |       ";
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 2){
            hangman = new String[2];
            hangman[1]= "     |";
            hangman[0]= " ____|___";
        }else if(wrongGuesses == 1){
            hangman = new String[1];
            hangman[0]= " ____ ___";
        }else {
            hangman = new String[1];
            hangman[0]= "Work in progress";
        }
        
        for(int i = hangman.length; i>0;i--){
            
            Main.bot.sendMessage(channel, " " + hangman[i-1]);
        }
        
        
    }
    
    
            
            
}
