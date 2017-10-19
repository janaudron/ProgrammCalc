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

    
    public enum Operation {
        NOT_INIT, INIT, EQUAL, ADD, SUB, DIV, MULTI,
    };

    private Operation op;

    /**
     * Constructor for class CalcEngine
     */
    CalcEngine() {
        op = Operation.NOT_INIT;
    }

    
    public void command(Operation operation) {
        if (operation == Operation.EQUAL) {
            this._start_calc();
        }
        op = operation;
    }

    public int get_result() {
        return res;
    }

    public void set_val(int value) {
        if (op == Operation.NOT_INIT) {
            res = value;
            op = Operation.INIT;
        } else {
            val = value;
        }
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
}
