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
     * Max length for hex-string
     */
    private final int HEX_LENGTH = 2 * Float.BYTES;

    /**
     * Max length for bin_string
     */
    private final int BIN_LENGTH = 8 * Float.BYTES;

    /**
     * Sets the value for the number
     *
     * @param value - settable value
     */
    public void setValue(double value) {
        if (value > MAX_VALUE) {
            value = MAX_VALUE;
        } else if (value < MIN_VALUE) {
            value = MIN_VALUE;
        }

        super.setValue(value);
    }

    /**
     * Get hex string of the number
     *
     * @return string of the number
     */
    public String toHex() {
        int int_bits = Float.floatToIntBits((float) super.getValue());
        String hex_str = Integer.toHexString(int_bits);
//        int len_str = hex_str.length();
//        if (len_str > HEX_LENGTH) {
//            hex_str = hex_str.substring(len_str - HEX_LENGTH);
//        }

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
}
