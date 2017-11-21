/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class UnsignedShortCE
 *
 * @author JAudron
 */
public class SignedShortCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Short.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Short.MIN_VALUE;
    /**
     * Count of the bytes
     */
    final public int BYTES = Short.BYTES;

    /**
     * Constractor
     */
    public SignedShortCE() {
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }    
}
