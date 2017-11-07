/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class UnsignedIntegerCE
 * @author JAudron
 */
public class UnsignedIntegerCE extends IntegerCE{
    /**
     * Max value for this type
     */
    final public double MAX_VALUE = 4294967295.0;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = 0.0;

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
