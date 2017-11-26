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
    private NumberCE num = new SignedIntegerCE();
    /* Data type*/
    private data_type_e type = data_type_e.INT;

    /**
     * Constructor or class Value;
     */
    public Value() {
        this.setDataType(data_type_e.INT);
        this.num.setValue(0);
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
     * Get value
     *
     * @return value
     */
    public double getValue() {
        double val = this.num.getValue();
        return val;
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

    /**
     * Decode dec string to number value
     *
     * @param str dec string
     * @throws NullPointerException if str == NULL
     * @throws NumberFormatException if string is invalid
     */
    public void DecodeDec(String str)
            throws NullPointerException, NumberFormatException {
        try {
            num.decodeDec(str);
        } catch (NumberFormatException | NullPointerException e) {
            throw e;
        }
    }
    
    /**
     * Decode hex string to number value
     *
     * @param str hex string
     * @throws NullPointerException if str == NULL
     * @throws NumberFormatException if string is invalid
     */
    public void DecodeHex(String str)
            throws NullPointerException, NumberFormatException {
        try {
            num.decodeHex(str);
        } catch (NumberFormatException | NullPointerException e) {
            throw e;
        }
    }
    
    /**
     * Decode bin string to number value
     *
     * @param str bin string
     * @throws NullPointerException if str == NULL
     * @throws NumberFormatException if string is invalid
     */
    public void DecodeBin(String str)
            throws NullPointerException, NumberFormatException {
        try {
            num.decodeBin(str);
        } catch (NumberFormatException | NullPointerException e) {
            throw e;
        }
    }
}
