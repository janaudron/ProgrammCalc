/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 *
 * @author JAudron
 */
public class ByteCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Byte.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Byte.MIN_VALUE;

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
        hex_str = Integer.toHexString((int) super.getValue());
        int len_str = hex_str.length();
        int indx = len_str - 2;
        if (len_str < 2) {
            indx = 0;
        }

        hex_str = hex_str.substring(indx);
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
        bin_str = Integer.toBinaryString((int) super.getValue());
        int len_str = bin_str.length();
        if (len_str > 8) {
            bin_str = bin_str.substring(len_str - 8);
        }
        return bin_str;
    }
}
