/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

/**
 * Класс с числами различных форматов
 *
 * @author JAudron
 */
public class Value {

    private enum value_type_e {
        INT, FLOAT
    };

    public enum view_mode_e {
        DEC, BIN, HEX
    }

    /* Значение в формате float */
    private float float_val;
    /* Значение в формате int */
    private int int_val;
    /* Тип значения*/
    private value_type_e type;
    /* Режим отображения числа */
    private view_mode_e vmode = view_mode_e.DEC;

    /**
     * Конструктор класс Value
     */
    Value() {
        this.float_val = 0.0f;
        this.int_val = 0;
        this.type = Value.value_type_e.INT;
    }

    /**
     * Устанавливает значение типа int
     *
     * @param value - устанавливаемое значение
     */
    public void setValue(int value) {
        this.int_val = value;
        this.type = Value.value_type_e.INT;
    }

    /**
     * Устанавливает значение типа float
     *
     * @param value - устанавливаемое значение
     */
    public void setValue(float value) {
        this.float_val = value;
        this.type = Value.value_type_e.FLOAT;
    }
    
    /**
     * Устанавливает режим отображения числа
     * @param view_mode - режим отображения числа
     */
    public void setViewMode(Value.view_mode_e view_mode) {
        this.vmode = view_mode;
    }

    /**
     * Получение значений
     *
     * @return возвращает значение
     */
    public float getValue() {
        if (this.type == Value.value_type_e.INT) {
            return (float) this.int_val;
        } else {
            return this.float_val;
        }
    }

    /**
     * Выводит значение в нужном формате
     *
     * @return Возвращает значение в виде строке
     */
    public String getStr(){
        String result = new String();
        switch (vmode) {
            case DEC:
                result = Integer.toString(int_val);
                break;
            case HEX:
                result = "0x"+Integer.toHexString(int_val);
                break;
            case BIN:
                result = Integer.toBinaryString(int_val);
                break;
        }
        
        return result;
    }
}
