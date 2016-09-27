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
        //Kijk of de message start met een ! anders hoeft de bot niks te doen
        if(message.startsWith("!")){
            
            if(message.startsWith("!raad")){
                //doe raad functie
                GameManager.makeAGuess(message, sender);
            } else if(message.startsWith("!start")){
                System.out.println("wordt nu naar de gameages gestuurd");
                GameManager.startGame(message, sender);
            }
        }
    }
    
    
    /**
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
        
        if(message.equalsIgnoreCase("!begin")){
            String[] playerNames = new String[1];
            playerNames[0] = sender;
            GameManager.addGame("default", 0, playerNames);
        }
        
        
        
        
    }
    */
        
       
        



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
