/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_types;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JAudron
 */
public class NumberCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public NumberCETest() {
        error_count = 0;
        case_count = 0;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class NumberCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class NumberCE test finish");
    }

    @Before
    public void setUp() {
        error_count = 0;
        case_count = 0;
        System.out.println("Test " + test_indx + " start");
    }

    @After
    public void tearDown() {
        case_result(error_count, case_count);
        test_indx++;
    }

    /**
     * Test of setValue method, of class NumberCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test NumberCE.setValue");
        double[] value_buf = {-171.0, 171.0};
        NumberCE inst = new NumberCE();
        for (double val : value_buf) {
            case_count++;
            inst.setValue(val);
            double ref_value = inst.getValue();

            if (val != ref_value) {
                error_count++;
            }
        }
    }

    /**
     * Test of getValue method, of class NumberCE.
     */
    @Test
    public void testGetValue() {
        System.out.println("Test NumberCE.getValue");
        double[] value_buf = {-171.0, 171.0};
        NumberCE inst = new NumberCE();
        for (double val : value_buf) {
            case_count++;
            inst.setValue(val);
            double ref_value = inst.getValue();

            if (val != ref_value) {
                error_count++;
            }
        }
    }

    /**
     * Test of toHex method, of class NumberCE.
     */
    @Test
    public void testToHex() {
        System.out.println("Test NumberCE.toHex");
        double[] value_buf = {
            171.0,
            0.0,
            -171.0,
            353.353
        };
        String[] string_buf = {
            "0x4065600000000000",
            "0x0",
            "0xc065600000000000",
            "0x407615a5e353f7cf"
        };
        NumberCE inst = new NumberCE();
        for (double val : value_buf) {

            inst.setValue(val);
            String inst_hex = inst.toHex();

            if (!inst_hex.equals(string_buf[case_count])) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of toBin method, of class NumberCE.
     */
    @Test
    public void testToBin() {
        System.out.println("Test NumberCE.toBin");
        double[] value_buf = {
            171.0,
            0.0,
            -171.0,
            353.353
        };
        String[] string_buf = {
            "100000001100101011000000000000000000000000000000000000000000000",
            "0",
            "1100000001100101011000000000000000000000000000000000000000000000",
            "100000001110110000101011010010111100011010100111111011111001111"
        };
        NumberCE inst = new NumberCE();
        for (double val : value_buf) {
            inst.setValue(val);
            String inst_bin = inst.toBin();

            if (!inst_bin.equals(string_buf[case_count])) {
                error_count++;
            }

            case_count++;
        }
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail("Errors" + error_count + "/" + case_count + "\n");
        }
        System.out.println("Success " + case_count + "/" + case_count + "\n");
    }

}
