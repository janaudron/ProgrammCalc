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
public class ByteCETest {
    private int error_count;
    private int case_count;
    private static int test_indx = 0;
    
    public ByteCETest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class ByteCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class ByteCE test finish");
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
     * Test of setValue method, of class ByteCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test ByteCE.setValue");
        double[] src_buf = {-171.0, 71.0, 300.0};
        double[] ref_buf = {-128.0, 71.0, 127.0};
        ByteCE inst = new ByteCE();
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
        System.out.println("Test ByteCE.toHex");
        double[] src_buf = {-128.0,  0.0,  127.0 };
        String[] ref_str = {"0x80", "0x0", "0x7f"};

        ByteCE inst = new ByteCE();
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
        System.out.println("Test ByteCE.toBin");
        double[] src_buf = {-128.0,     0.0, 127.0 };
        String[] ref_str = {"10000000", "0", "1111111"};

        ByteCE inst = new ByteCE();
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
