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
public class SignedByteCE extends NumberCE {

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
     * Constractor
     */
    public SignedByteCE() {
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }
}
