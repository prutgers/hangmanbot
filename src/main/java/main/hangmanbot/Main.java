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
public class Main {
    //settings
    private final static String connectToChannel = "#rsvier";
    private final static String connectToServer ="irc.xs4all.nl";
    
    public static void main(String[] args){   
       GalgjeBot bot = new GalgjeBot();
       try{
        bot.connect(connectToServer);
        } catch (IOException | IrcException e) {
            System.out.println("help het gaat mis");
        }
        bot.joinChannel(connectToChannel);
    }
}
