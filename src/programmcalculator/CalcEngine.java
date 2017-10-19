/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

/**
 *
 * @author JAudron
 */
public class CalcEngine {

    //class variables
    private int res;
    private int val;

    private boolean dbg;

    public enum Operation {
        NOT_INIT, INIT, EQUAL, ADD, SUB, DIV, MULTI,
    };

    private Operation op;

    /**
     * Constructor for class CalcEngine
     */
    public CalcEngine(boolean debug) {
        op = Operation.NOT_INIT;
        dbg = debug;
    }
    
    public CalcEngine() {
        op = Operation.NOT_INIT;
        dbg = false;
    }

    public void command(Operation operation) {
        if (operation == Operation.EQUAL) {
            this._start_calc();
        } else {
            val = res;
            op = operation;
        }
        _debug_message();
    }

    public int get_result() {
        return res;
    }

    public void set_val(int value) {
        res = value;
        _debug_message();
    }

    private void _start_calc() {
        switch (op) {
            case ADD:
                res = this.add();
                break;
            case SUB:
                res = this.sub();
                break;
            case DIV:
                res = this.div();
                break;
            case MULTI:
                res = this.multi();
                break;
            default:
                break;
        }
    }

    private int add() {
        return res + val;
    }

    private int sub() {
        return res - val;
    }

    private int div() {
        return res / val;
    }

    private int multi() {
        return res * val;
    }

    private void _debug_message() {
        if (dbg) {
            System.out.println("val = " + val);
            System.out.println("res = " + res);
            System.out.println("op = " + op);
        }
    }
}
