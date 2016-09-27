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
    String[] hangmanBelow5 = new String[]{
        "   _______\n" +
"     |/      |\n" +
"     |      (_)\n" +
"     |      \\|/\n" +
"     |       |\n" +
"     |      / \\\n" +
"     |\n" +
" ____|___"
    }
}
