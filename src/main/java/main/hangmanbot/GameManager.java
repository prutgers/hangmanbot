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
    private static Set<Game> gameSet = new HashSet<Game>();
     

    
    
    private GameManager(){
        
    }
    
    static void makeAGuess(String message, String sender) {
        //kijk door de gameSets en vind game met Speler naam
        Game game = findGameWithPlayer(sender);
        String[] splitMessage = message.split(" ");
        if(!(game == null)){
            Word currentWord = game.getCurrentWord();
            if(splitMessage.length >= 2){
                if(splitMessage[1].length() == 1){
                    if(currentWord.checkGuess(splitMessage[1].charAt(0))){
                        currentWord.guessFound(splitMessage[1].charAt(0));
                        Main.bot.sendMessage(channel, "Je hebt een letter geraden");
                        Main.bot.sendMessage(channel, currentWord.getGuessed());
                        Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                    } else if(game.gameLost()){
                        Main.bot.sendMessage(channel, sender + " je hebt het spel verloren!");
                        gameSet.remove(game);
                    }else{
                        Main.bot.sendMessage(channel, "Er zijn nog " + game.numberOfTurnsLeft() + " pogingen over ");
                        Main.bot.sendMessage(channel, currentWord.getGuessed());
                        Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                    }
                }else if(currentWord.checkWord(splitMessage[1])){
                    Main.bot.sendMessage(channel, sender + " je hebt het spel gewonnen!");
                    gameSet.remove(game);
                } else if(game.gameLost()){
                    Main.bot.sendMessage(channel, sender + " je hebt het spel verloren!");
                    gameSet.remove(game);
                } else {
                    Main.bot.sendMessage(channel, "Er zijn nog " + game.numberOfTurnsLeft() + " pogingen over ");
                    Main.bot.sendMessage(channel, currentWord.getGuessed());
                    Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                }
            } 
        }
    }
    
    
    
    public static void startGame(String message, String sender){
        String[] splitMessage = message.split(" ");
        //Check if it is just the !start command and if so start a game with 1 player
        if(splitMessage.length == 1){
            Game game = new Game(0, sender);
            gameSet.add(game);
        Main.bot.sendMessage(channel, "Galgje is gestart hier onder staat het woord");
        Main.bot.sendMessage(channel, game.getCurrentWord().getGuessed());
        Main.bot.sendMessage(channel, sender + " het is jou beurt gok een letter of een woord.");
      } 
      
      //More game modus should be implemented here for example !start [2] shoudl be a 2 player game
    }
    
    
    //Search if a player who is trying to guess a letter/word is actually an active player in a game
    private static Game findGameWithPlayer(String player){
        Game findGame = null;
        for(Game game:gameSet){
            if(player.equalsIgnoreCase(game.getCurrentPlayer())){
                findGame = game;
            }
        }
        return findGame;
    }
    
    
    
    
    
}

