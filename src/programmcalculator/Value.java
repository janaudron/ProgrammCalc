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
    /** 
     * Enumeration data type 
     * <li>{@link #CHAR}</li>
     */
    public enum data_type_e {
        /**
         * Byte
         */
        CHAR,
        /* Unsigned byte */
        UCHAR,
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
    private float float_val = 0.0f;
    /* Value of number in int */
    private long long_val = 0;
    /* Data type*/
    private data_type_e type = data_type_e.INT;

    /**
     * max value for current data type
     */
    private long MAX_VALUE;
    /**
     * min value for current data type
     */
    private long MIN_VALUE;
    

    /**
     * Конструктор класс Value
     */
    public Value() {
        this.float_val = 0.0f;
        this.long_val = 0;
        this.type = Value.data_type_e.INT;
        this.MAX_VALUE = _get_upper_depth(type);
        this.MIN_VALUE = _get_lower_depth(type);
    }

    /**
     * Устанавливает значение типа int
     *
     * @param value - устанавливаемое значение
     */
    public void setValue(long value) {
        long _value = (long) value;
                
        long lower_depth = _get_lower_depth(this.type);
        long upper_depth = _get_upper_depth(this.type);
        if (_value < lower_depth) {
            this.long_val = lower_depth;
        } else if (_value > upper_depth) {
            this.long_val = upper_depth;
        } else {
            this.long_val = (int)_value;
        }
    }

    /**
     * Устанавливает значение типа float
     *
     * @param value - устанавливаемое значение
     */
    public void setValue(float value) {
        this.float_val = value;
        this.type = Value.data_type_e.FLOAT;
    }

    /**
     * Set data type
     *
     * @param type - data type
     */
    public void setDataType(data_type_e type) {
        this.type = type;
        
        this.MIN_VALUE = _get_lower_depth(type);
        this.MAX_VALUE = _get_upper_depth(type);
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
     * Получение значений
     *
     * @return возвращает значение
     */
    public long getValue() {
        long val = 0; 
        switch(this.type){
            case CHAR:
            case UCHAR:
            case SHORT:
            case USHORT:
            case INT:
            case UINT:
            case LONG:
                val = this.long_val;
                break;
//            case FLOAT:
//            case DOUBLE:
//                return this.float_val;
        }
        return val; 
    }
    
    /**
     * Get min value for class type
     * @return Return value
     */
    public long getMinValue() {
        return this.MIN_VALUE;
    }
    
    /**
     * Get min value for current type 
     * 
     * @param type - data type
     * @return Return value
     */
    public static long getMinValue(Value.data_type_e type) {
        return _get_lower_depth(type);
    }
    
    /**
     * Get max value for class type
     * @return Return value
     */
    public long getMaxValue() {
        return this.MAX_VALUE;
    }
    
    /**
     * Get max value for current type 
     * 
     * @param type - data type
     * @return Return value
     */
    public static long getMaxValue(Value.data_type_e type) {
        long val = _get_upper_depth(type);
        return val;
    }

    /**
     * Get lower data depth
     *
     * @param type - data type
     * @return return depth value
     */
    private static long _get_lower_depth(Value.data_type_e type) {
        switch (type) {
            case CHAR:
                return 0xffffffffffffff80L;
            case UCHAR:
                return 0x0;
            case SHORT:
                return 0xffffffffffff8000L;
            case USHORT:
                return 0x0;
            case INT:
                return 0xffffffff80000000L;
            case UINT:
                return 0x0;
            case LONG:
                return 0x8000000000000000L;
        }
        return 0;
    }

    /**
     * Get upper data depth
     *
     * @param type - data type
     * @return return depth value
     */
    private static long _get_upper_depth(Value.data_type_e type) {
        switch (type) {
            case CHAR:
                return 0x7fL;
            case UCHAR:
                return 0xffL;
            case SHORT:
                return 0x7fffL;
            case USHORT:
                return 0xffffL;
            case INT:
                return 0x7fffffffL;
            case UINT:
                return 0xffffffffL;
            case LONG:
                return 0x7fffffffffffffffL;
        }
        return 0;
    }
}
