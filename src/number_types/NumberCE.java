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
     * The bits number in the byte
     */
    public final int BITS_IN_BYTE = 8;

    /**
     * Number of the bytes
     */
    private int bytes;

    /**
     * Number of the bites
     */
    private int bits;

    /**
     * Sign flag
     */
    private boolean signed = false;

    /**
     * Max value for current type
     */
    private double max_value;

    /**
     * Min value for current type
     */
    private double min_value;

    /**
     * Value of number
     */
    private double num = 0.0;

    /**
     * Set bytes and bits number
     *
     * @param nbytes - number of the bytes
     */
    protected void setSize(int nbytes) {
        this.bits = nbytes * BITS_IN_BYTE;
        this.bytes = nbytes;
    }

    /**
     * Set sign flag
     *
     * @param sign
     */
    protected void setSign() {
        this.signed = true;
    }

    /**
     * Set max value for current type
     *
     * @param max - max value
     */
    protected void setMaxValue(double max) {
        this.max_value = max;
    }

    /**
     * Set min value for current type
     *
     * @param min - min value
     */
    protected void setMinValue(double min) {
        this.min_value = min;
    }

    /**
     * Sets the value for the number
     *
     * @param value - settable value
     */
    public void setValue(double value) {
        if (value > max_value) {
            value = max_value;
        } else if (value < min_value) {
            value = min_value;
        }

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
    public String toHex() {
        long val = (long) this.num;

        String str = Long.toHexString(val);
        int length = str.length();
        if (length > 2 * this.bytes) {
            str = str.substring(length - 2 * this.bytes, length);
        }
        str = str.toUpperCase();
        str = "0x" + str;

        return str;
    }

    /**
     * Get bin string
     *
     * @return bin string
     */
    public String toBin() {
        long val = (long) this.num;

        String str = Long.toBinaryString(val);
        int length = str.length();
        if (length > this.bits) {
            str = str.substring(length - this.bits, length);
        }
        return str;
    }

    /**
     * Get dec string
     *
     * @return dec string
     */
    public String toDec() {
        long val = (long) this.num;

        String str = Long.toString(val);
        return str;
    }

    /**
     * Decode dec string to number
     *
     * @param str - dec string
     */
    public void decodeDec(String str) 
            throws NumberFormatException, NullPointerException {
        double val;

        try {
            val = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        this.setValue(val);
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

        if (str.length() == 0) {
            throw new NullPointerException();
        }

        long ibin = 0;
        try {
            ibin = Long.parseLong(str, 0x10);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        String bin = Long.toBinaryString(ibin);
        double val = this.decode_bin(bin, this.bits, this.signed);
        this.setValue(val);
    }

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public void decodeBin(String str) 
            throws NullPointerException, NumberFormatException{
        double val = decode_bin(str, this.bits, this.signed);

        this.setValue(val);
    }

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     * @param num_bits - number of bits
     * @param signed - switcher signed/unsigned
     * @return number
     */
    private double decode_bin(String str, int num_bits, boolean signed)
            throws NullPointerException, NumberFormatException {
        int length = str.length();
        if (length == 0) {
            throw new NullPointerException();
        }

        if (length > num_bits) {
            str = str.substring(length - num_bits);
            length = str.length();
        }

        byte[] bin = str.getBytes();
        length = bin.length;

        for (int i = 0; i < bin.length; i++) {
            if (bin[i] != 48 && bin[i] != 49) {
                throw new NumberFormatException();
            }
            bin[i] &= 1;
        }

        long val = 0;
        int indx_start = 0;
        int tail = 1;
        if ((bin[0] & 1) == 1 && length == num_bits && signed) {
            val = 1L << (num_bits - 1);
            val *= -1;
            tail++;
            indx_start++;
        }
        long multi = 1L << length - tail;
        for (int i = indx_start; i < length; i++) {
            val += multi * bin[i];
            multi >>= 1;
        }

        return val;
    }
}
