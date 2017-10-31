/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import java.util.Scanner;
import programmcalculator.Value.data_type_e;

/**
 * Консольный интерфейс
 *
 * @author JAudron
 */
public class ConsoleInterface {

    /* Флаг сигнализирующий о выходе */
    private boolean quit;
    /* Чтение из stdin */
    private Scanner in;
    /* Объект класса калькулятор */
    private CalcEngine calculator;

    /**
     * Class construct
     */
    ConsoleInterface() {
        quit = false;
        in = new Scanner(System.in);
        calculator = new CalcEngine(true);
    }

    /**
     * Запуск прослушивания потока ввода
     */
    public void StartListen() {
        do {
            String str = in.next();
            listener(str);
        } while (quit == false);
    }

    /**
     * Расшифровка прослушанного потока
     *
     * @param input - считанная строка
     */
    private void listener(String input) {
        if (input.isEmpty()) {
            return;
            //Management commands
        } else if (input.equals("quit") || input.equals("q")) {
            quit = true;
            return;
            //Data type
        } else if (input.equals("CHAR") || input.equals("char")) {
            calculator.setDataType(data_type_e.CHAR);
            return;
        } else if (input.equals("SHORT") || input.equals("SHORT")) {
            calculator.setDataType(data_type_e.SHORT);
            return;
        } else if (input.equals("INT") || input.equals("INT")) {
            calculator.setDataType(data_type_e.INT);
            return;
//        } else if (input.equals("LONG") || input.equals("LONG")) {
//            calculator.setDataType(data_type_e.LONG);
//            return;
//        } else if (input.equals("FLOAT") || input.equals("FLOAT")) {
//            calculator.setDataType(data_type_e.FLOAT);
//            return;
//        } else if (input.equals("DOUBLE") || input.equals("DOUBLE")) {
//            calculator.setDataType(data_type_e.DOUBLE);
//            return;
            //Number view mode
        } else if (input.equals("HEX") || input.equals("hex")) {
            calculator.setViewMode(Value.view_mode_e.HEX);
            return;
        } else if (input.equals("DEC") || input.equals("dec")) {
            calculator.setViewMode(Value.view_mode_e.DEC);
            return;
        } else if (input.equals("BIN") || input.equals("bin")) {
            calculator.setViewMode(Value.view_mode_e.BIN);
            return;
            //Operations
        } else if (input.equals("+")) {
            calculator.command(CalcEngine.Operation.ADD);
            return;
        } else if (input.equals("-")) {
            calculator.command(CalcEngine.Operation.SUB);
            return;
        } else if (input.equals("*")) {
            calculator.command(CalcEngine.Operation.MULTI);
            return;
        } else if (input.equals("/")) {
            calculator.command(CalcEngine.Operation.DIV);
            return;
        } else if (input.equals("=")) {
            calculator.command(CalcEngine.Operation.EQUAL);
            System.out.println(calculator.getResult());
            return;
        }
        //Input number
        //TODO Enter input in long
        try {
            long val = Long.decode(input);
           
            calculator.setVal(val);
        } catch (NumberFormatException e) {
            return;
        }
    }
}
