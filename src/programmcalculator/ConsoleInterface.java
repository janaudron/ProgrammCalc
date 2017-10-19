/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import java.util.Scanner;

/**
 * Консольный интерфейс
 * @author JAudron
 */
public class ConsoleInterface {
    private boolean quit;
    private Scanner in;
    private CalcEngine calculator;

    /**
     * Class construct
     */
    ConsoleInterface() {
        quit = false;
        in = new Scanner (System.in);
        calculator = new CalcEngine();
    }
    
    /**
     * Запуск прослушивания потока ввода
     */
    public void StartListen() {
        do {
            String str = in.next();
            listener (str);
        } while (quit == false);
    }   
    
    /**
     * Расшифровка прослушанного потока
     * @param input - считанная строка
     */
    private void listener(String input){
        if (input.isEmpty())
            return;
        
        if (input.compareTo("quit")==0 || input.compareTo("q")==0) {
            quit = true;
        }

        //if (Integer.parseInt(input))
    }
    
}
