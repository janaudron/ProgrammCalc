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
public class SignedIntegerCETest {
    private int error_count;
    private int case_count;
    private static int test_indx = 0;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class SignedIntegerCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class SignedIntegerCE test finish");
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
    
    public SignedIntegerCETest() {
    }
    
    /**
     * Test of setValue method, of class SignedIntegerCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test SignedIntegerCE.setValue");
        double[] src_buf = {-34359738367.0, 1024.0, 34359738367.0};
        double[] ref_buf = {-2147483648.0, 1024.0, 2147483647.0};
        SignedIntegerCE inst = new SignedIntegerCE();
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
    
    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail("Errors" + error_count + "/" + case_count + "\n");
        }
        System.out.println("Success " + case_count + "/" + case_count + "\n");
    }
}
