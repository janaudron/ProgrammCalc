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
        Scanner in = new Scanner(System.in);
        CalcEngine calc_engine = new CalcEngine();
        System.out.println("Enter fst num:");
        calc_engine.set_val(in.nextInt());
        calc_engine.command(CalcEngine.Operation.SUB);
        System.out.println("Enter second num:");
        calc_engine.set_val(in.nextInt());
        calc_engine.command(CalcEngine.Operation.EQUAL);

        System.out.println("Result :\n" + calc_engine.get_result());

    }

}
