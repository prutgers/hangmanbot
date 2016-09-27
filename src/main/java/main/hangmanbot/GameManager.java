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
public class GameManager {
    private static Set<GameSettings> gameSets;
    
    private GameManager(){
        
    }
    
    public static void addGame(String word, int difficulty, String[] playerNames){
        gameSets.add(new GameSettings(word, difficulty, playerNames));
    }
    
}

