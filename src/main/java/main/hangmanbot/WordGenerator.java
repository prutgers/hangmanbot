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
     private static File woordenlijst;

    public WordGenerator() {
        woordenlijst = new File("woordenlijst.txt");
    }
    
    //tool om een korte woordenlijst te genereren, die alleen woorden heeft van min tot max aantal letters
    protected static void decreaseList(File file, int min, int max){
        try(Scanner input = new Scanner(file); FileWriter fw = new FileWriter("woordenlijst.txt");){
            while(input.hasNextLine()){
                String woord = input.nextLine();
                woord = woord.trim();
                if(woord.matches("\\w{" + min + "," + max + "}")){//als het woord bestaat uit min tot max aantal letters (exclusief letters met speciale tekens, zoals een trema)
                    System.out.println("Woord gevonden: " + woord);
                    String newline = String.format("%n");//omdat verschillende OS'en een andere definitie hebben van een newline, dient men deze methode te gebruiken
                    fw.write(woord + newline);
                    fw.flush();
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.err.println("Bestand niet gevonden: " + ex.getMessage());
        }
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }
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
        System.out.println("hallo");
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
