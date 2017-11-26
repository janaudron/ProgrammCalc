/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class FloatCE
 *
 * @author JAudron
 */
public class FloatCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Float.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = -Float.MAX_VALUE;
    /**
     * Count of the bytes
     */
    final public int BYTES = Float.BYTES;

    /**
     * Constructor
     */
    public FloatCE() {
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }

    /**
     * Get hex string of the number
     *
     * @return string of the number
     */
    public String toHex() {
        int int_bits = Float.floatToIntBits((float) super.getValue());
        String hex_str = Integer.toHexString(int_bits);
        hex_str = hex_str.toUpperCase();

        hex_str = "0x" + hex_str;

        return hex_str;
    }

    /**
     * Get bin string of the number
     *
     * @return string of the number
     */
    public String toBin() {
        int int_bits = Float.floatToIntBits((float) super.getValue());
        String bin_str = new String();
        bin_str = Integer.toBinaryString(int_bits);
        return bin_str;
    }

    /**
     * Get dec string of the number
     *
     * @return string of the number
     */
    public String toDec() {
        return Float.toString((float) super.getValue());
    }

    /**
     * Set value from the dec string
     *
     * @param str - dec sring
     */
    public void decodeDec(String str) 
            throws NumberFormatException, NullPointerException {
        if (str.length() == 0) {
            throw new NullPointerException();
        }
        
        double val = 0;
        try {
            val = Float.valueOf(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        super.setValue(val);
    }

    /**
     * Decode hex string to number
     *
     * @param str - hex string
     */
    public void decodeHex(String str) 
            throws NumberFormatException, NullPointerException {
        if (str.startsWith("0X") || str.startsWith("0x")) {
            str = str.substring(2);
        }
        if (str.startsWith("-") || str.startsWith("+")) {
            str = str.substring(1);
        }
        
        int length = str.length();
        if (length == 0) {
            throw new NullPointerException();
        }

        if (length > 2*BYTES) {
            str = str.substring(length - 2*BYTES);
            length = str.length();
        }
        
        long tmp = 0;
        try {
            tmp = Long.parseLong(str, 0x10);
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        double val = (double)Float.intBitsToFloat((int)tmp);
        
        super.setValue(val);
    }
    
    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public void decodeBin(String str) 
            throws NumberFormatException, NullPointerException {
        int length = str.length();
        if (length == 0) {
            throw new NullPointerException();
        }

        if (length > 8*BYTES) {
            str = str.substring(length - 8*BYTES);
            length = str.length();
        }
        
        long tmp = 0;
        try {
            tmp = Long.parseLong(str, 0x2);
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        double val = (double)Float.intBitsToFloat((int)tmp);
        
        super.setValue(val);
    }
}
