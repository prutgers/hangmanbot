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
        //For speed an processor control check if a message starts with a ! otherwise ignore the message
        if(message.startsWith("!")){
            
            if(message.startsWith("!raad")){
                //doe raad functie
                GameManager.makeAGuess(message, sender);
            } else if(message.startsWith("!start")){
                //Starts a new game of Hangman depending on the given arguments
                GameManager.startGame(message, sender);
            } else if(message.startsWith("!help")){
                sendMessage(sender, "Ik ondersteun de volgende commando's [!start] om een spel galgje te starten, [!raad [letter of woord]] om een letter of woord te raden");
            } else {
                //leeg
            }
        }
    }
    
    @Override
    public void onJoin(String channel, String sender, String login, String hostname){
        sendMessage(channel, "Welkom " + sender + "! Voor meer informatie over de commando's type [!help].");
    }
    
}
  
    
    

    //oude code moet nog verwijdered worden
        /**
        * if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        if (message.equalsIgnoreCase("!help")) {
            
            sendMessage(channel, "!help !galgje !bo");
        }
        if (message.equalsIgnoreCase("!bo")) {
            
            sendMessage(channel, "Bo wat gezellig dat je er bent!");
        }
        if (message.equalsIgnoreCase("!galgje")) {
            
                                sendMessage(channel, "      _______\n") ;
            sendMessage(channel,                    "     |/      |\n" );
            sendMessage(channel,                    "     |      (_)\n" );
                    sendMessage(channel,              "     |      \\|/\n" );
                                sendMessage(channel, "     |       |\n" );
                                sendMessage(channel, "     |      / \\\n" );
                                sendMessage(channel, "     |\n" );
                                sendMessage(channel, " ____|____");
        }
        * */
     
    

