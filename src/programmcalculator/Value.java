/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

/**
 * Класс с числами различных форматов
 * @author JAudron
 */
public class Value {

    private enum value_type {
        INT, FLOAT
    };

    private float float_val;
    private int int_val;
    private value_type type;

    Value() {
        this.float_val = 0.0f;
        this.int_val = 0;
        this.type = Value.value_type.INT;
    }

    public void setValue(int value) {
        this.int_val = value;
        this.type = Value.value_type.INT;
    }

    public void setValue(float value) {
        this.float_val = value;
        this.type = Value.value_type.FLOAT;
    }

    public float getValue() {
        if (this.type == Value.value_type.INT) {
            return (float) this.int_val;
        } else {
            return this.float_val;
        }
    }

}
