/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

/**
 * Class CalcEngine
 *
 * @author JAudron
 */
public class CalcEngine {

    //Operations enumerations
    public enum Operation {
        NOT_INIT,
        INIT,
        EQUAL,
        ADD,
        SUB,
        DIV,
        MULTI
    };

    /* Enumeration View mode */
    public enum view_mode_e {
        DEC,
        BIN,
        HEX
    }

    //The result of the calculation
    private Value res;
    //New value
    private Value val;
    //View mode
    private view_mode_e vmode = view_mode_e.DEC;
    /* Operation */
    private Operation op;

    //Switch debug mode
    private boolean dbg;

    /**
     * Constructor for class CalcEngine
     */
    public CalcEngine(boolean debug) {
        res = new Value();
        val = new Value();

        op = Operation.NOT_INIT;
        dbg = debug;
    }

    public CalcEngine() {
        res = new Value();
        val = new Value();

        op = Operation.NOT_INIT;
        dbg = false;
    }

    /**
     * Enter command
     *
     * @param operation command
     */
    public void setCommand(Operation operation) {
        if (operation == Operation.EQUAL) {
            this.start_calc();
        } else {
            val.setValue(res.getValue());
            op = operation;
        }
        _debug_message();
    }
    
    /**
     * Get current command
     */
    public Operation getCommand() {
        return this.op;
    }

    public void parseString(String str)
            throws NullPointerException, NumberFormatException {
        switch (vmode) {
            case BIN:
                try {
                    res.DecodeBin(str);
                } catch (NullPointerException | NumberFormatException e) {
                    throw e;
                }
                break;
            case DEC:
                try {
                    res.DecodeDec(str);
                } catch (NullPointerException | NumberFormatException e) {
                    throw e;
                }
                break;
            case HEX:
                try {
                    res.DecodeHex(str);
                } catch (NullPointerException | NumberFormatException e) {
                    throw e;
                }
                break;
            default:
                break;
        }
    }

    /**
     * Get string with result in current view mode
     *
     * @return string result
     */
    public String toString() {
        String result = new String();
        switch (vmode) {
            case DEC:
                result = res.toDec();
                break;
            case HEX:
                result = res.toHex();
                break;
            case BIN:
                result = res.toBin();
                break;
        }
        return result;
    }
    
    /**
     * Get result value
     * @return result value
     */
    public Double getValue() {
        return res.getValue();
    }
    
    /**
     * Set value
     * @param val settable value
     */
    public void setValue(Double val){
        res.setValue(val);
    }

    /**
     * Set view mode
     *
     * @param view_mode - view type
     */
    public void setViewMode(view_mode_e view_mode) {
        this.vmode = view_mode;
    }

    /**
     * Get view mode
     *
     * @return view type
     */
    public view_mode_e getViewMode() {
        return this.vmode;
    }

    /**
     * Set data type for res and val
     *
     * @param data_type - data type
     */
    public void setDataType(Value.data_type_e data_type) {
        this.val.setDataType(data_type);
        this.res.setDataType(data_type);
    }

    /**
     * Get current data type
     *
     * @return data type
     */
    public Value.data_type_e getDataType() {
        return res.getDataType();
    }

    /**
     * Начинает считать
     */
    private void start_calc() {
        switch (op) {
            case ADD:
                res.setValue(this.add());
                break;
            case SUB:
                res.setValue(this.sub());
                break;
            case DIV:
                res.setValue(this.div());
                break;
            case MULTI:
                res.setValue(this.multi());
                break;
            default:
                break;
        }
    }

    /**
     * Операция сложения
     *
     * @return - возвращает результат
     */
    private double add() {
        return val.getValue() + res.getValue();
    }

    /**
     * Операция вычитания
     *
     * @return - возвращает результат
     */
    private double sub() {
        return val.getValue() - res.getValue();
    }

    /**
     * Операция деления
     *
     * @return - возвращает результат
     */
    private double div() {
        double calc = 0;
        double _val = val.getValue();
        double _res = res.getValue();
        if (_res == 0) {
            return 0.0;
        }
        calc = _val / _res;
        return calc;
    }

    /**
     * Операция умножения
     *
     * @return - возвращает результат
     */
    private double multi() {
        return val.getValue() * res.getValue();
    }

    /**
     * Отладочное сообщение
     */
    private void _debug_message() {
        if (dbg) {
            System.out.println("val = " + val.getValue());
            System.out.println("res = " + res.getValue());
            System.out.println("op = " + op);
            System.out.println("get data type res = " + res.getDataType());
            System.out.println("get data type val = " + val.getDataType());
        }
    }
}
