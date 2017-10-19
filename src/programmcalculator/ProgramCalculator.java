/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import java.util.Scanner;

/**
 *
 * @author JAudron
 */
public class ProgramCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsoleInterface cui = new ConsoleInterface();
        cui.StartListen();
        
        System.out.println("Quit");
    }

}
