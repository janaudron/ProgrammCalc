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
        calculator = new CalcEngine(true);
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
            return;
        }
        
        int val;
        try {
            val = Integer.parseInt(input);
            calculator.set_val(val);
            //calculator.command(CalcEngine.Operation.EQUAL);
            
        } catch (NumberFormatException e) {
        
            if (input.contains("+")){
                calculator.command(CalcEngine.Operation.ADD);
                return;
            }
            if (input.contains("-")){
                calculator.command(CalcEngine.Operation.SUB);
                return;
            }
            if (input.contains("*")){
                calculator.command(CalcEngine.Operation.MULTI);
                return;
            }
            if (input.contains("/")){
                calculator.command(CalcEngine.Operation.DIV);
                return;
            }
            if (input.contains("=")){
                calculator.command(CalcEngine.Operation.EQUAL);
                System.out.println(calculator.get_result());
                return;
            }
        }
        

        

        //if (Integer.parseInt(input))
    }
    
}
