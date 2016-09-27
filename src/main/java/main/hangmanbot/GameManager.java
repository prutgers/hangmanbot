/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.util.Set;

/**
 *
 * @author Peter
 */
public class GameManager implements ServerSettings {
    private static Set<Game> gameSet;
     

    
    
    private GameManager(){
        
    }
    
    static void makeAGuess(String message, String sender) {
        //kijk door de gameSets en vind game met Speler naam
        
        //als gevonden
            //haal die game uit de set, en Game.letterZitErin().
        
           Main.bot.sendMessage(channel, sender);
            
    }
    
    
    public static void addGame(String word, int difficulty, String[] playerNames){
        gameSet.add(new Game(word, difficulty, playerNames));
    }
    
    public static void startGame(String message, String sender){
      String[] splitMessage = message.split(" ");
      
      //Check if it is just the !start command and if so start a game with 1 player
      if(splitMessage.length == 1){
          gameSet.add(new Game(0, sender));
          
      }
    }
    
    private Game findGameWithPlayer(String player){
        for(Game game:gameSet){
            if(player.equalsIgnoreCase(game.g))
        
        }
        
        return 
    }
    
    
    
    
    
}

