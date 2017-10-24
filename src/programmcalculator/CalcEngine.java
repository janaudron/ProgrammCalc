/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

/**
 * Класс калькулятор
 * @author JAudron
 */
public class CalcEngine {
    public enum Operation {
        NOT_INIT, INIT, EQUAL, ADD, SUB, DIV, MULTI,
    };

    //Результат вычислений
    private Value res;
    //Новое значение
    private Value val;

    //Выключатель отладочного режима
    private boolean dbg;

    /* Операция */
    private Operation op;
    
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
     * Ввод комманды 
     * @param operation операция
     */
    public void command(Operation operation) {
        if (operation == Operation.EQUAL) {
            this._start_calc();
        } else {
            val.setValue(res.getValue());
            op = operation;
        }
        _debug_message();
    }

    /**
     * Получение результата
     * @return Возврат результата
     */
    public String get_result() {
        return res.getStr();
    }

    /**
     * Установка нового значения
     * @param value - устанавливаемое значение
     */
    public void set_val(int value) {
        res.setValue(value);
        _debug_message();
    }
    
    /**
     * Установить режим отображения числа
     * @param view_mode 
     */
    public void set_view_mod(Value.view_mode_e view_mode) {
        res.setViewMode(view_mode);
    }

    
    /**
     * Начинает считать
     */
    private void _start_calc() {
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
     * @return - возвращает результат
     */
    private int add() {
        return (int) val.getValue() + (int) res.getValue();
    }
    
    /**
     * Операция вычитания
     * @return - возвращает результат
     */
    private int sub() {
        return (int) val.getValue() - (int) res.getValue();
    }

    /**
     * Операция деления
     * @return - возвращает результат
     */
    private int div() {
        return (int) val.getValue() / (int) res.getValue();
    }

    /**
     * Операция умножения
     * @return - возвращает результат
     */
    private int multi() {
        return (int) val.getValue() * (int) res.getValue();
    }

    
    /**
     * Отладочное сообщение
     */
    private void _debug_message() {
        if (dbg) {
            System.out.println("val = " + val.getValue());
            System.out.println("res = " + res.getValue());
            System.out.println("op = " + op);
        }
    }
}
