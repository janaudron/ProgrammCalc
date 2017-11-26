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
     * Constructor
     */
    public DoubleCE() {
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }

    /**
     * Get hex string of the number
     *
     * @return string of the number
     */
    public String toHex() {
        long long_bits = Double.doubleToLongBits((double) super.getValue());
        String hex_str = Long.toHexString(long_bits);

        hex_str = hex_str.toUpperCase();
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

    /**
     * Set value from the dec string
     *
     * @param str - dec sring
     */
    public void decodeDec(String str) 
            throws NullPointerException, NumberFormatException {
        double val = 0;
        try {
            val = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (NullPointerException e){
            throw new NullPointerException();
        }
        super.setValue(val);
    }

    /**
     * Decode hex string to number
     *
     * @param str - hex string
     */
    public void decodeHex(String str) 
            throws NumberFormatException, NullPointerException{
        LongCE lval = new LongCE();

        try {
            lval.decodeHex(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        
        long tmp = (long)lval.getValue();
        
        double val = (double) Double.longBitsToDouble(tmp);

        super.setValue(val);
    }

    /**
     * Decode bin string to number
     *
     * @param str - bin string
     */
    public void decodeBin(String str) 
            throws NullPointerException, NumberFormatException{
        LongCE lval = new LongCE();
        
        try {
            lval.decodeBin(str);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        } catch (NumberFormatException e){
            throw new NumberFormatException();
        }
        
        long tmp = (long)lval.getValue();
        
        double val = (double) Double.longBitsToDouble(tmp);

        super.setValue(val);
    }
}
