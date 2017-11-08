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
public class IntegerCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public IntegerCETest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class IntegerCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class IntegerCE test finish");
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
     * Test of toHex method, of class ByteCE.
     */
    @Test
    public void testToHex() {
        System.out.println("Test IntegerCE.toHex");
        double[] src_buf = {0x80000000, 0.0, 0x7fffffff};
        String[] ref_str = {"0x80000000", "0x0", "0x7fffffff"};

        IntegerCE inst = new IntegerCE();
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
        System.out.println("Test IntegerCE.toBin");
        double[] src_buf = {0x80000000, 0.0, 0x7fffffff};
        String[] ref_str = {
            "10000000000000000000000000000000",
            "0",
            "1111111111111111111111111111111"
        };

        IntegerCE inst = new IntegerCE();
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

    /**
     * Test of toDec method, of class ByteCE.
     */
    @Test
    public void testToDec() {
        System.out.println("Test IntegerCE.toDec");
        double[] src_buf = {-32434, 0.0, 32768};
        String[] ref_str = {
            "-32434", "0", "32768"
        };

        IntegerCE inst = new IntegerCE();
        for (double src : src_buf) {
            inst.setValue(src);
            String dst_dec = inst.toDec();
            String ref_dec = ref_str[case_count];

            if (!dst_dec.equals(ref_dec)) {
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
