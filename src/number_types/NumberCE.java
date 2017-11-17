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
public abstract class NumberCE {

    /**
     * num
     */
    private double num = 0.0;

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
     * Get hex string
     *
     * @return hex string
     */
    public abstract String toHex();

    /**
     * Get bin string
     *
     * @return bin string
     */
    public abstract String toBin();

    /**
     * Get dec string
     *
     * @return dec string
     */
    public abstract String toDec();

    /**
     * Decode dec string to number
     *
     * @param str - dec string
     */
    public abstract void decodeDec(String str);

    /**
     * Decode hex string to number
     *
     * @param str - hex string
     */
    public abstract void decodeHex(String str);

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public abstract void decodeBin(String str);

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     * @param num_bits - number of bits
     * @param signed - switcher signed/unsigned
     * @return number
     */
    public final double decodeBin(String str, int num_bits, boolean signed) {
        int length = str.length();
        if (length == 0) {
            return this.getValue();
        }

        if (length > num_bits) {
            str = str.substring(length - num_bits);
            length = str.length();
        }

        byte[] bin = str.getBytes();
        length = bin.length;

        for (int i = 0; i < bin.length; i++) {
            if (bin[i] != 48 && bin[i] != 49) {
                return this.getValue();
            }
            bin[i] &= 1;
        }

        int val = 0;
        if ((bin[0] & 1) == 1 && length == num_bits && signed) {
            val = 1 << (num_bits - 1);
            val *= -1;
            length--;
        }
        int multi = 1 << length - 1;
        for (int i = 0; i < length; i++) {
            val += multi * bin[i];
            multi >>= 1;
        }

        return val;
    }
}
