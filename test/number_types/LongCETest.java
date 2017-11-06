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
public class LongCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public LongCETest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class LongCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class LongCE test finish");
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
     * Test of setValue method, of class LongCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test LongCE.setValue");
        double[] src_buf = {-92233720368547758080.0, 1024.0, 92233720368547758070.0};
        double[] ref_buf = {-9223372036854775808.0, 1024.0, 9223372036854775807.0};
        LongCE inst = new LongCE();
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
        System.out.println("Test LongCE.toHex");
        double[] src_buf = {0x8000000000000000L, 0.0, 0x7fffffffffffffffL};
        String[] ref_str = {"0x8000000000000000", "0x0", "0x7fffffffffffffff"};

        LongCE inst = new LongCE();
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
        System.out.println("Test LongCE.toBin");
        double[] src_buf = {0x8000000000000000L, 0.0, 0x7fffffffffffffffL};
        String[] ref_str = {
            "1000000000000000000000000000000000000000000000000000000000000000",
            "0",
            "111111111111111111111111111111111111111111111111111111111111111"
        };

        LongCE inst = new LongCE();
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
