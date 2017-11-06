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
public class FloatCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public FloatCETest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class FloatCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class FloatCE test finish");
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
     * Test of setValue method, of class FloatCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test FloatCE.setValue");
        double[] src_buf = {-Float.MAX_VALUE*10, 1024.231, Float.MAX_VALUE*10};
        double[] ref_buf = {-Float.MAX_VALUE,    1024.231, Float.MAX_VALUE};
        FloatCE inst = new FloatCE();
        for (double src : src_buf) {
            inst.setValue(src);
            double dst = inst.getValue();
            double ref = ref_buf[case_count];
            if (ref != dst) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of toHex method, of class ByteCE.
     */
    @Test
    public void testToHex() {
        System.out.println("Test FloatCE.toHex");
        double[] src_buf = {
            -1032.154,
            0.0,
            2056.23
        };
        String[] ref_str = {
            "0xc48104ee",
            "0x0", 
            "0x450083ae"
        };

        FloatCE inst = new FloatCE();
        for (double src : src_buf) {
            inst.setValue(src);
            String dst_hex = inst.toHex();
            String ref_hex = ref_str[case_count];

            if (!dst_hex.equals(ref_hex)) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of toBin method, of class ByteCE.
     */
    @Test
    public void testToBin() {
        System.out.println("Test FloatCE.toBin");
        double[] src_buf = {
            -1032.154, 
            0.0, 
            2056.23
        };
        String[] ref_str = {
            "11000100100000010000010011101110",
            "0",
            "1000101000000001000001110101110"
        };

        FloatCE inst = new FloatCE();
        for (double src : src_buf) {
            inst.setValue(src);
            String dst_hex = inst.toBin();
            String ref_hex = ref_str[case_count];

            if (!dst_hex.equals(ref_hex)) {
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
