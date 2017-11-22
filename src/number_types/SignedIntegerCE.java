/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

/**
 * Class SignedIntegerCE
 *
 * @author JAudron
 */
public class SignedIntegerCE extends NumberCE {

    /**
     * Max value for this type
     */
    final public double MAX_VALUE = Integer.MAX_VALUE;
    /**
     * Min value for this type
     */
    final public double MIN_VALUE = Integer.MIN_VALUE;
    /**
     * Count of the bytes
     */
    final public int BYTES = Integer.BYTES;

    /**
     * Constructor
     */
    public SignedIntegerCE(){
        super.setSize(BYTES);
        super.setSign();
        super.setMaxValue(MAX_VALUE);
        super.setMinValue(MIN_VALUE);
    }    
}
