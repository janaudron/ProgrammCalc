/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

import java.math.BigInteger;

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
     * Count of the bytes
     */
    final public int BYTES = Long.BYTES;

    public LongCE() {
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }

    /**
     * Decode hex string to number
     *
     * @param str - hex string
     */
    public void decodeHex(String str) 
            throws NumberFormatException, NullPointerException {
        if (str.startsWith("-") || str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.startsWith("0X") || str.startsWith("0x")) {
            str = str.substring(2);
        }

        try {
            str = to_bin(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        super.decodeBin(str);
    }

    private String to_bin(String str) 
            throws NumberFormatException, NullPointerException {
        int length = str.length();
        
        if (length == 0) {
            throw new NullPointerException();
        }
        
        if (length > 2 * BYTES) {
            str = str.substring(length - 2 * BYTES);
            length = 2 * BYTES;
        }

        if (length == 2 * BYTES) {
            String a = str.substring(0, 2);
            String b = str.substring(2, length);

            long tmp = 0;
            try {
                tmp = Long.parseLong(b, 0x10);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }

            String b_bin = Long.toBinaryString(tmp);
            int b_length = b_bin.length();
            for (int i = 0; i < 8 * (BYTES - 1) - b_length; i++) {
                b_bin = "0" + b_bin;
            }

            try {
                tmp = Long.parseLong(a, 0x10);
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
            String a_bin = Long.toBinaryString(tmp);

            str = a_bin + b_bin;
        }

        return str;
    }
}
