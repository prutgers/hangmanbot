/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.hangmanbot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class GameManagerTest {
    
    public GameManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeAGuess method, of class GameManager.
     */
    @Test
    public void testMakeAGuess() {
        System.out.println("makeAGuess");
        String message = "";
        String sender = "";
        GameManager.makeAGuess(message, sender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGame method, of class GameManager.
     */
    @Test
    public void testAddGame() {
        System.out.println("addGame");
        String word = "";
        int difficulty = 0;
        String[] playerNames = null;
        GameManager.addGame(word, difficulty, playerNames);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class GameManager.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        String message = "";
        String sender = "";
        GameManager.startGame(message, sender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
