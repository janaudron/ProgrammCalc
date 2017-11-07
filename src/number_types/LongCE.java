/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class LongCE
 *
 * @author JAudron
 */
public class LongCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Long.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Long.MIN_VALUE;

    /**
     * Max length for hex-string
     */
    private final int HEX_LENGTH = 2 * Long.BYTES;

    /**
     * Max length for bin_string
     */
    private final int BIN_LENGTH = 8 * Long.BYTES;

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
        String hex_str = new String();
        hex_str = Long.toHexString((long) super.getValue());
        int len_str = hex_str.length();
        if (len_str > HEX_LENGTH) {
            hex_str = hex_str.substring(len_str - HEX_LENGTH);
        }

        hex_str = "0x" + hex_str;

        return hex_str;
    }

    /**
     * Get bin string of the number
     *
     * @return string of the number
     */
    public String toBin() {
        String bin_str = new String();
        bin_str = Long.toBinaryString((long) super.getValue());
        int len_str = bin_str.length();
        if (len_str > BIN_LENGTH) {
            bin_str = bin_str.substring(len_str - BIN_LENGTH);
        }
        return bin_str;
    }
}
