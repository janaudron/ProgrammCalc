/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class UnsignedByteCE
 *
 * @author JAudron
 */
public class SignedByteCE extends ByteCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Byte.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Byte.MIN_VALUE;

    /**
     * Count of the bytes
     */
    final public int BYTES = Byte.BYTES;

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
     * Decode hex string to number
     *
     * @param str - hex string
     */
    public void decodeHex(String str) {
        if (str.startsWith("0X") || str.startsWith("0x")) {
            str = str.substring(2);
        }
        if (str.startsWith("-") || str.startsWith("+")) {
            str = str.substring(1);
        }

        int length = str.length();
        if (length > 2 * BYTES) {
            str = str.substring(length - 2 * BYTES);
        }

//
//        if (sbin.length() == 8) {
//            sbin = "11111111" + sbin;
//        }
//        double val = 0;
//        try {
//            val = Short.parseShort(sbin, 2);
//        } catch (NumberFormatException e) {
//            val = this.getValue();
//        }
//
//        this.setValue(val);
    }

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public void decodeBin(String str) {
        double val = super.decodeBin(str, 8*BYTES, true);
        this.setValue(val);
    }
}
