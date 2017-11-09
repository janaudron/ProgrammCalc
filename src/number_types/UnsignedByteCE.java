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
}
