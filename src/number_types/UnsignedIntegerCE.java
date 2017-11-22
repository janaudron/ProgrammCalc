/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class UnsignedIntegerCE
 *
 * @author JAudron
 */
public class UnsignedIntegerCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = 4294967295.0;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = 0.0;
    /**
     * Count of the bytes
     */
    final public int BYTES = Integer.BYTES;

    /**
     * Constructor
     */
    public UnsignedIntegerCE(){
        super.setSize(BYTES);
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }    
}
