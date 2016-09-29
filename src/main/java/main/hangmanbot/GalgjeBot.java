/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import org.jibble.pircbot.PircBot;

/**
 *
 * @author Peter
 */
public class GalgjeBot extends PircBot {
    public GalgjeBot(){
        this.setName("GalgjeBot");
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        //For speed and processor control checks if a message starts with a ! otherwise ignore the message
        if(message.startsWith("!")){
            
            if(message.startsWith("!raad")){
                //doe raad functie
                GameManager.makeAGuess(message, sender);
            } else if(message.startsWith("!start")){
                //Starts a new game of Hangman depending on the given arguments
                GameManager.startGame(message, sender);
            } else if(message.startsWith("!help")){
                sendMessage(sender, "Ik ondersteun de volgende commando's [!start] om een spel galgje te starten, [!raad [letter of woord]] om een letter of woord te raden");
            } else if(message.startsWith("!doemee")){
              GameManager.joinAGame(message, sender);
            } else if(message.startsWith("!reset")){
                GameManager.resetAllGames();
            } else if(message.startsWith("!ops")){
                op(channel, sender);
            }else {
                //leeg
            }
        }
    }
    
    @Override
    public void onJoin(String channel, String sender, String login, String hostname){
        sendMessage(channel, "Welkom " + sender + "! Voor meer informatie over de commando's type [!help].");
        
    }
    
}