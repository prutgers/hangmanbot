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
        System.out.println("hanglength " + hangman.length + " hangman 0 " + hangman[0]);
        for(int i = hangman.length; i>0;i--){
            System.out.println("hey " + i);
            Main.bot.sendMessage(channel, " " + hangman[i-1]);
        }
        
        
    }
    
    
            
            
}
