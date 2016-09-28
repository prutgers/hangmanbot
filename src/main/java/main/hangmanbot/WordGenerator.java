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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class WordGenerator {
    private static File woordenlijst;
    private List<String> woorden;
    
    
    private WordGenerator(){
        woordenlijst = new File("woordenlijst.txt");
    }
    
    private void readFile(){
        try(Scanner input = new Scanner(file); FileWriter fw = new FileWriter("woordenlijst.txt");){
            
            while(input.hasNextLine()){
                
            }
        }
        catch (FileNotFoundException ex) {
            System.err.println("Bestand niet gevonden: " + ex.getMessage());
        }
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }
    }
    
    private int telWoorden(){
        int aantalWoorden = 0;
        try(Scanner input = new Scanner(woordenlijst)){
            while(input.hasNextLine()){
                input.nextLine();
                aantalWoorden++;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Bestand niet gevonden: " + ex.getMessage());
        }
        return aantalWoorden;
    }
    
}
