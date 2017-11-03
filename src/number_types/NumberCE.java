/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * class NumberCE
 *
 * @author JAudron
 */
public class NumberCE {

    /**
     * num
     */
    private double num = 0.0;

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Double.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Double.MIN_VALUE;

    /**
     * Sets the value for the number
     *
     * @param value - settable value
     */
    public void setValue(double value) {
        this.num = value;
    }

    /**
     * Get value of the number
     *
     * @return value of the number
     */
    public double getValue() {
        return this.num;
    }

    /**
     * Get hex string of the number
     *
     * @return string of the number
     */
    public String toHex() {
        long long_bits = Double.doubleToLongBits(this.num);
        String str_hex = Long.toHexString(long_bits);
        str_hex = String.format("0x%s", str_hex);
        return str_hex;
    }

    /**
     * Get bin string of the number
     *
     * @return string of the number
     */
    public String toBin() {
        long long_bits = Double.doubleToLongBits(this.num);
        String str_bin = Long.toBinaryString(long_bits);
//        str_bin = String.format("%064s", str_bin);
        return str_bin;
    }

}
