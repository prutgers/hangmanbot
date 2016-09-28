/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;

/**
 *
 * @author Peter
 */
public class Main implements ServerSettings{
    protected static GalgjeBot bot;
    public static void main(String[] args){   
       bot = new GalgjeBot();
       try{
        bot.connect(server);
        } catch (IOException | IrcException e) {
            System.out.println("help het gaat mis");
        }
        bot.joinChannel(channel);
        
        
    }
}
