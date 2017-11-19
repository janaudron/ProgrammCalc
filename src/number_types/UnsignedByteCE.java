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
public class UnsignedByteCE extends ByteCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = 255.0;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = 0.0;
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

        long ival = 0;
        try {
            ival = Long.parseLong(str, 16);
        } catch (NumberFormatException e) {
            double val = this.getValue();
            this.setValue(val);
            return;
        }
        
        String bin = Long.toBinaryString(ival);
        double val = this.decodeBin(bin, 8*BYTES, false);
        this.setValue(val);
    }

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public void decodeBin(String str) {
        double val = super.decodeBin(str, 8 * BYTES, false);
//        int length = str.length();
//        if (length > 8 * BYTES) {
//            str = str.substring(length - 8 * BYTES);
//        }
//        
//        double val = 0;
//        try {
//            val = (double) Integer.parseInt(str, 2);
//        } catch (NumberFormatException e) {
//            val = this.getValue();
//        }
//        
        this.setValue(val);
    }
}
