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
public class NumberCE {

    /**
     * num
     */
    private double num = 0.0;

    /**
     * Sets the value for the number
     *
     * @param value - settable value
     */
    public void setValue(double value) {
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
}
