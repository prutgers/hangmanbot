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
    
    //This huge method check if a guess either a word or a letter is correct and it does a lot more
    //It would be good to split this up but thats for the next person :D
    static void makeAGuess(String message, String sender) {
        //Scroll trhough the onGoing games to check if the sender is in a a game and if it is his turn.
        Game game = findGameWithThisPlayerTurn(sender);
        String[] splitMessage = message.split(" ");
        if(!(game == null)){
            Word currentWord = game.getCurrentWord();
            //check if there is actually something else then [!raad] in the message
            if(splitMessage.length >= 2){
                //Check if the guess is a single character or a word
                if(splitMessage[1].length() == 1){
                    //check if the character isnt already guessed 
                    if(!(currentWord.getGuessedLetters().contains(splitMessage[1].charAt(0)))){
                        //check if the word contains the character
                        if(currentWord.checkGuess(splitMessage[1].charAt(0))){
                            //The character is in the word so update the word with the new letter and pass the turn to the next player
                            currentWord.guessFound(splitMessage[1].charAt(0));
                            Main.bot.sendMessage(channel, "Je hebt een letter geraden");
                            //HangmanPrinter.printHangman(game.getCurrentWord().getWrongGuess());
                            Main.bot.sendMessage(channel, currentWord.getGuessed());
                            Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                            
                            // Check if the game is lost and ifso remove the game
                        } else if(game.gameLost()){ 
                            Main.bot.sendMessage(channel, sender + " je hebt het spel verloren!");
                            HangmanPrinter.printHangman(game.getCurrentWord().getWrongGuess());
                            gameSet.remove(game);
                            //if the game is not lost continue
                        }else{
                            //HangmanPrinter.printHangman(game.getCurrentWord().getWrongGuess());
                            Main.bot.sendMessage(channel, "Er zijn nog " + game.numberOfTurnsLeft() + " pogingen over ");
                            Main.bot.sendMessage(channel, currentWord.getGuessed());
                            Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                        }
                        //The character was guessed so inform the player that this happend and continue
                    } else {
                        Main.bot.sendMessage(channel, sender + " deze letter is al geraden!");
                        Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                    }
                    //the message contains a word which is guessed check if it is the winning word if so congratulate player and remove the game
                }else if(currentWord.checkWord(splitMessage[1])){
                    //HangmanPrinter.printHangman(game.getCurrentWord().getWrongGuess());
                    Main.bot.sendMessage(channel, sender + " je hebt het spel gewonnen!");
                    gameSet.remove(game);
                    //if not hte word check if the game is lost if so inform the player and remove the game
                } else if(game.gameLost()){
                    HangmanPrinter.printHangman(game.getCurrentWord().getWrongGuess());
                    Main.bot.sendMessage(channel, sender + " je hebt het spel verloren!");
                    gameSet.remove(game);
                    //since the player didnt win or lose continue the game
                } else {
                    Main.bot.sendMessage(channel, "Er zijn nog " + game.numberOfTurnsLeft() + " pogingen over ");
                    Main.bot.sendMessage(channel, currentWord.getGuessed());
                    Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
                }
            } 
        }
    }
    
    public static void joinAGame(String message, String Sender){
        String[] splitMessage = message.split(" ");
        if(splitMessage.length == 2){
            String gameID = splitMessage[1];
            System.out.println("gameID " +gameID);
            Game game = findGameWithID(gameID);
            int playerSlot = game.getMaxNumberOfPlayers();
            System.out.println("playerSlot " + playerSlot);
            if(!(game == null) & !(game.getCurrentNumberOfPlayers()== game.getMaxNumberOfPlayers())){
                System.out.println("hey ik ben hier");
                String[] playerList = game.getPlayerList();
                for(int i = game.getMaxNumberOfPlayers(); i <0 ; i--){
                    if(playerList[i-1]==null){
                        playerSlot = i-1;
                    }
                }
                playerList[playerSlot] = gameID;
                game.updateCurrentNumberOfPlayers();
            if(game.getCurrentNumberOfPlayers() == game.getMaxNumberOfPlayers()){
                Main.bot.sendMessage(channel, "Galgje is gestart hier onder staat het woord (type !raad [letter of woord] om te raden");
                Main.bot.sendMessage(channel, game.getCurrentWord().getGuessed());
                Main.bot.sendMessage(channel, game.getCurrentPlayer() + " het is jou beurt gok een letter of een woord.");
            }
                
                
            } else {
                Main.bot.sendMessage(channel, "Het spel bestaat niet of zit al vol");
            }
        }

    }
    
    
    public static void startGame(String message, String sender){
        String[] splitMessage = message.split(" ");
        //deze methode werkt nog niet goed want als de speler een spel start die niet aan de beurt is dan lukt het wel
        Game game = findGameWithPlayer(sender);
        if((game == null)){
            //Check if it is just the !start command and if so start a game with 1 player
            if(splitMessage.length == 1){
                game = new Game(0, sender);
                gameSet.add(game);
                Main.bot.sendMessage(channel, "Galgje is gestart hier onder staat het woord (type !raad [letter of woord] om te raden");
                Main.bot.sendMessage(channel, game.getCurrentWord().getGuessed());
                Main.bot.sendMessage(channel, sender + " het is jou beurt gok een letter of een woord.");
            } else {
                String number = splitMessage[1];
                int numberOfPlayers = Integer.parseInt(number);
                game = new Game(0, sender, numberOfPlayers);
                gameSet.add(game);
                Main.bot.sendMessage(channel, "De game zal beginnen als er nog " + (numberOfPlayers-1) + " zich aanmelden type: !doemee " + sender);
            }
        } else{
                Main.bot.sendMessage(channel, sender + " je zit al in een spelletje!");
        }
      
      //More game modus should be implemented here for example !start [2] shoudl be a 2 player game
    }
    
    
    //Search if a player who is trying to guess a letter/word is actually an active player in a game
    private static Game findGameWithThisPlayerTurn(String player){
        Game findGame = null;
        for(Game game:gameSet){
            if(player.equalsIgnoreCase(game.getCurrentPlayer())){
                findGame = game;
            }
        }
        return findGame;
    }
    
    private static Game findGameWithPlayer(String player){
        Game findGame = null;
        for(Game game:gameSet){
            String[] playerList = game.getPlayerList();
            for(String playerName:playerList){
                if(playerName.equalsIgnoreCase(player)){
                    findGame = game;
                }
            }
        }
        
        return findGame;
    }
    
    private static Game findGameWithID(String player){
         Game findGame = null;
        for(Game game:gameSet){
            if(game.getGameID().equalsIgnoreCase(player)){
                findGame = game;
            }
        }
        return findGame;
    }
    
    //removes all games so you can have a fresh start
    public static void resetAllGames(){
        gameSet.removeAll(gameSet);
    }
    
    
    
}

