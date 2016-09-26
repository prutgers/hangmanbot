/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;

/**
 *
 * @author Peter
 */
public class GalgjeBot extends PircBot {
    private Word currentWord;
    private boolean onGoingGame = false;
    private String player;
    private static String connectToChannel = "#rsvier";
            
    public static void main(String[] args){   
        GalgjeBot bot = new GalgjeBot();
       
        
       try{
        bot.connect("irc.xs4all.nl");
        } catch (IOException | IrcException e) {
            System.out.println("help het gaat mis");
        }
        bot.joinChannel(connectToChannel);
        
    }
    
    public GalgjeBot(){
        this.setName("GalgjeBot");
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        String[] splitMessage = message.split(" ");
        if(onGoingGame & sender.equalsIgnoreCase(player) & message.startsWith("!raad")){
            if(splitMessage[1].length() == 1){
                if(currentWord.checkGuess(splitMessage[1].charAt(0))){
                    currentWord.guessFound(splitMessage[1].charAt(0));
                    sendMessage(channel, "Je hebt een letter geraden");
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
                } else {
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, checkLoss());
                    if(!checkLoss().contains("je hebt het spel verloren")){ 
                        sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
                    }
                    
                }
            } else {
                if(currentWord.checkWord(splitMessage[1])){
                    sendMessage(channel, player + " je hebt het spel gewonnen!");
                    onGoingGame = false;
                } else {
                    sendMessage(channel, currentWord.getGuessed());
                    sendMessage(channel, checkLoss());
                    if(!checkLoss().contains("je hebt het spel verloren")){ 
                        sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
                    }
                    
                }
                
            }
        }
               
        if(!onGoingGame & message.startsWith("!start")){
            boolean userNotFound = true;
            if(splitMessage.length == 1){
                currentWord = new Word();
                onGoingGame = true;
                player = sender;
                sendMessage(channel, "Galgje is gestart hier onder staat het woord");
                sendMessage(channel, currentWord.getGuessed());
                sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
            } else {
                User[] user = getUsers(connectToChannel);
                
                for(int i = 0; i < user.length;i++){
                    if(user[i].equals(splitMessage[2])){
                        
                        currentWord = new Word(splitMessage[1]);
                        
                        onGoingGame = true;
                        
                        player = user[i].toString();
                        
                        sendMessage(channel, "Galgje is gestart hier onder staat het woord");
                        
                        sendMessage(channel, currentWord.getGuessed());
                        sendMessage(channel, this.player + " het is jou beurt gok een letter of een woord.");
                        userNotFound = false;
                    } 
                }
            }
            if(userNotFound){
                sendMessage(channel, " De opgegeven gebruiker is niet gevonden. Is de naam wel goed geschreven?");
            }
        }
    }
    
        
        public String checkLoss(){
            String lost;
            if(currentWord.getWrongGuess()<10){
                lost = "Je hebt nog " + (10-currentWord.getWrongGuess()) + " pogingen over.";

            }
            else {
                lost = player + " je hebt het spel verloren!";
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
