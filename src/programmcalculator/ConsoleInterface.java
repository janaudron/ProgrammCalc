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
        }
        if (input.equals("quit") || input.equals("q")) {
            quit = true;
            return;
        }
        if (input.equals("HEX") || input.equals("hex")) {
            calculator.set_view_mod(Value.view_mode_e.HEX);
            return;
        }
        if (input.equals("DEC") || input.equals("dec")) {
            calculator.set_view_mod(Value.view_mode_e.DEC);
            return;
        }
        if (input.equals("BIN") || input.equals("bin")) {
            calculator.set_view_mod(Value.view_mode_e.BIN);
            return;
        }
        if (input.equals("+")) {
            calculator.command(CalcEngine.Operation.ADD);
            return;
        }
        if (input.equals("-")) {
            calculator.command(CalcEngine.Operation.SUB);
            return;
        }
        if (input.equals("*")) {
            calculator.command(CalcEngine.Operation.MULTI);
            return;
        }
        if (input.equals("/")) {
            calculator.command(CalcEngine.Operation.DIV);
            return;
        }
        if (input.equals("=")) {
            calculator.command(CalcEngine.Operation.EQUAL);
            System.out.println(calculator.get_result());
            return;
        }
        try {
            int val = Integer.parseInt(input);
            calculator.set_val(val);
        } catch (NumberFormatException e) {
            return;
        }
    }
}
