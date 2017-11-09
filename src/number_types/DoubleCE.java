/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class DoubleCE
 *
 * @author JAudron
 */
public class DoubleCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Double.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = -Double.MAX_VALUE;
    /**
     * Count of the bytes
     */
    final public int BYTES = Double.BYTES;

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
        long long_bits = Double.doubleToLongBits((double) super.getValue());
        String hex_str = Long.toHexString(long_bits);

        hex_str = "0x" + hex_str;

        return hex_str;
    }

    /**
     * Get bin string of the number
     *
     * @return string of the number
     */
    public String toBin() {
        long long_bits = Double.doubleToLongBits((double) super.getValue());
        String bin_str = Long.toBinaryString(long_bits);
        return bin_str;
    }

    /**
     * Get dec string of the number
     *
     * @return string of the number
     */
    public String toDec() {
        return Double.toString(super.getValue());
    }
}
