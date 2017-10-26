/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import java.util.Scanner;

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
        } else if (input.equals("quit") || input.equals("q")) {
            quit = true;
            return;
        } else if (input.equals("HEX") || input.equals("hex")) {
            calculator.setViewMode(Value.view_mode_e.HEX);
            return;
        } else if (input.equals("DEC") || input.equals("dec")) {
            calculator.setViewMode(Value.view_mode_e.DEC);
            return;
        } else if (input.equals("BIN") || input.equals("bin")) {
            calculator.setViewMode(Value.view_mode_e.BIN);
            return;
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
        try {
            int val = Integer.decode(input);
            calculator.setVal(val);
        } catch (NumberFormatException e) {
            return;
        }
    }
}
