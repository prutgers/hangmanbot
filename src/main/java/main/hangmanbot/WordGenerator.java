/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ian en een beetje Peter
 */
public class WordGenerator {
     private final static File woordenlijst = new File("woordenlijst.txt");

    private WordGenerator() {
        
    }
    
    //tel het aantal woorden in de woordenlijst
    private static int telWoorden(){
        int aantalWoorden = 0;
        try(Scanner input = new Scanner(woordenlijst)){
            while(input.hasNextLine()){
                input.nextLine();
                aantalWoorden++;
            }
            return aantalWoorden;
        } catch (FileNotFoundException ex) {
            System.err.println("Bestand niet gevonden: " + ex.getMessage());
        }
        return 0;
    }
    //zoek een woord op een bepaald lijnnummer (dit is nodig voor een random woord kiezen)
    private static String zoekWoord(int lijnNummer){
        try(Scanner input = new Scanner(woordenlijst);){
            for (int line = 0; line < (lijnNummer - 1); line++){ //loop tot aan het lijnNummer
                input.nextLine();//ga naar de volgende lijn (tot dat we bij de lijn zijn van het woord die we willen)
            }
            return input.nextLine(); //return het volgende woord (die dus op de lijn #lijnNummer zit)
        }catch (FileNotFoundException ex) {
            System.err.println("Bestand niet gevonden: " + ex.getMessage());
        }
        return "";
    }
    //kies een random woord uit de woordenlijst
    public static String kiesRandomWoord(double randomGetal){
        if(woordenlijst.exists()){
            int randomIndex = (int) (randomGetal * telWoorden());//dit bepaald het random woord, de int die gegenereerd is staat voor het # van het woord in de lijst
            return zoekWoord(randomIndex);
        }
        else{
            System.err.println("Geen bestand gevonden!");
            return null;
        }
}
    
}
