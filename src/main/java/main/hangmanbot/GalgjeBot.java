/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author Peter
 */
public class GalgjeBot extends PircBot {
    private Word currentWord;
    private boolean onGoingGame = false;
    private String player;
            
            
    public static void main(String[] args){   
        GalgjeBot bot = new GalgjeBot();
       
        
       try{
        bot.connect("irc.xs4all.nl");
        } catch (IOException | IrcException e) {
            System.out.println("help het gaat mis");
        }
        bot.joinChannel("#rsvier");
        
    }
    
    public GalgjeBot(){
        this.setName("GalgjeBot");
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        if(onGoingGame & sender.equalsIgnoreCase(player)){
            if(message.length() == 1){
                if(currentWord.checkGuess(message.charAt(0))){
                    currentWord.guessFound(message.charAt(0));
                    sendMessage(channel, "Je hebt een letter geraden");
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
                } else {
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, checkLoss());
                }
            } else {
                if(currentWord.checkWord(message)){
                    sendMessage(channel, "Gefeliciteerd je hebt gewonnen");
                    onGoingGame = false;
                } else {
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, checkLoss());
                    
                }
                
            }
        }
        
        if(!onGoingGame & message.equalsIgnoreCase("!start")){
            currentWord = new Word();
            onGoingGame = true;
            player = sender;
            sendMessage(channel, "Galgje is gestart hier onder staat het woord");
            sendMessage(channel, currentWord.getGuessed());
            sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
        }
        
        
    }
        
        public String checkLoss(){
            String lost;
            if(currentWord.getWrongGuess()<10){
                lost = "Je hebt nog " + (10-currentWord.getWrongGuess()) + " pogingen over. Raad nog een letter of een woord.";

            }
            else {
                lost = "Je hebt verloren";
                onGoingGame = false;
            }

            return lost;
        }

        



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
     
    
}
