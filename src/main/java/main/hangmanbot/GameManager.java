/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Peter
 */
public class GameManager implements ServerSettings {
    private static Set<Game> gameSet;
     

    
    
    private GameManager(){
        this.gameSet = new HashSet<Game>();
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
        System.out.println("ben hier");
              
      //Check if it is just the !start command and if so start a game with 1 player
      if(splitMessage.length == 1){
          System.out.println("ben hier nu");
        Game game = new Game(0, sender);
          System.out.println(game);
          System.out.println(gameSet.add(game));
          System.out.println("en nu hier");
        Main.bot.sendMessage(channel, "Galgje is gestart hier onder staat het woord");
        Main.bot.sendMessage(channel, game.getCurrentWord().getGuessed());
        Main.bot.sendMessage(channel, sender + " het is jou beurt gok een letter of een woord.");
          
      }
    }
    
    private Game findGameWithPlayer(String player){
        Game findGame = null;
        for(Game game:gameSet){
            if(player.equalsIgnoreCase(game.getCurrentPlayer())){
                findGame = game;
            }
        
        }
        return findGame;
    }
    
    
    
    
    
}

