/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import number_types.*;

/**
 * Class Value
 *
 * @author JAudron
 */
public class Value {

    /**
     * Enumeration data type
     * <li>{@link #BYTE}</li>
     */
    public enum data_type_e {
        /**
         * Byte
         */
        BYTE,
        /* Unsigned byte */
        UBYTE,
        /* Half word*/
        SHORT,
        /* Unsigned half word*/
        USHORT,
        /* word */
        INT,
        /* Unsigned word*/
        UINT,
        /* double word*/
        LONG,
        /* float */
        FLOAT,
        /* double */
        DOUBLE
    };

    /* Value of number in float */
    private NumberCE num = new IntegerCE();
    /* Data type*/
    private data_type_e type = data_type_e.INT;

    /**
     * Constructor or class Value;
     */
    public Value() {
//        this.setDataType(data_type_e.INT);
//        this.num.setValue(0);
    }

    /**
     * Set value;
     *
     * @param value - settable value
     */
    public void setValue(double value) {
        num.setValue(value);
    }

    /**
     * Set data type
     *
     * @param type - data type
     */
    public void setDataType(data_type_e type) {
        this.type = type;
        NumberCE tmp_num = this.num;
        switch (type) {
            case BYTE:
                this.num = new SignedByteCE();
                break;
            case UBYTE:
                this.num = new UnsignedByteCE();
                break;
            case SHORT:
                this.num = new SignedShortCE();
                break;
            case USHORT:
                this.num = new UnsignedShortCE();
                break;
            case INT:
                this.num = new SignedIntegerCE();
                break;
            case UINT:
                this.num = new UnsignedIntegerCE();
                break;
            case LONG:
                this.num = new LongCE();
                break;
            case FLOAT:
                this.num = new FloatCE();
                break;
            case DOUBLE:
                this.num = new DoubleCE();
                break;
            default:
                this.num = new SignedIntegerCE();
                break;
        }

        this.num.setValue(tmp_num.getValue());
    }

    /**
     * Get data type
     *
     * @return - data type
     */
    public Value.data_type_e getDataType() {
        return type;
    }

    /**
     * Get value
     *
     * @return value
     */
    public double getValue() {
        double val = this.num.getValue();
        return val;
    }

    /**
     * Get hex string
     *
     * @return hex string
     */
    public String toHex() {
        return num.toHex();
    }

    /**
     * Get bin string
     *
     * @return hex string
     */
    public String toBin() {
        return num.toBin();
    }

    /**
     * Get dec string
     *
     * @return hex string
     */
    public String toDec() {
        return num.toDec();
    }
}
