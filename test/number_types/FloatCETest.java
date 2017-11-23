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
        double[] src_buf = {-Float.MAX_VALUE * 10, 1024.231, Float.MAX_VALUE * 10};
        double[] ref_buf = {-Float.MAX_VALUE, 1024.231, Float.MAX_VALUE};
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
     * Test of decodeDec method, of class FloatCE.
     */
    @Test
    public void test_decodeDec() {
        System.out.println("Test FloatCE.decodeDec");

        String[] str_buf = {
            "-1023.56",
            "1231.054",
            "0x1",
            "",
            "-1.0"
        };

        double[] ref_buf = {
            -1023.56,
            1231.054,
            1231.054,
            1231.054,
            -1.0
        };

        FloatCE num = new FloatCE();
        for (String str : str_buf) {
            num.decodeDec(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                double diff = Math.abs(dst - ref_buf[case_count]);
                if (diff >= 0.0001) {
                    error_count++;
                }
            }
            case_count++;
        }
    }

    /**
     * Test of decodeHex method, of class FloatCE.
     */
    @Test
    public void test_decodeHex() {
        System.out.println("Test FloatCE.DecodeHex");
        
        String[] str_buf = {
            "0",
            "0xC48104EE",
            "",
            "0.1",
            "0x450083AE",
            "0xFC48104EE"
        };

        double[] ref_buf = {
            0,
            -1032.154,
            -1032.154,
            -1032.154,
            2056.23,
            -1032.154,
        };

        FloatCE num = new FloatCE();
        for (String str : str_buf) {
            num.decodeHex(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                double diff = Math.abs(dst - ref_buf[case_count]);
                if (diff >= 0.0001) {
                    error_count++;
                }
            }
            case_count++;
        }
    }
    
    /**
     * Test of decodeBin method, of class FloatCE.
     */
    @Test
    public void test_decodeBin() {
        System.out.println("Test FloatCE.DecodeBin");
        
        String[] str_buf = {
            "0",
            "11000100100000010000010011101110",
            "",
            "0.1",
            "1000101000000001000001110101110",
            "111111000100100000010000010011101110"
        };

        double[] ref_buf = {
            0,
            -1032.154,
            -1032.154,
            -1032.154,
            2056.23,
            -1032.154,
        };

        FloatCE num = new FloatCE();
        for (String str : str_buf) {
            num.decodeBin(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                double diff = Math.abs(dst - ref_buf[case_count]);
                if (diff >= 0.0001) {
                    error_count++;
                }
            }
            case_count++;
        }
    }

    /**
     * Test of toHex/toDec/toBin method, of class FloatCE.
     */
    @Test
    public void test_toStr() {
        System.out.println("Test FloatCE.toHex");
        System.out.println("     FloatCE.toDec");
        System.out.println("     FloatCE.toBin");

        double[] src_buf = {
            -1032.154,
            0.0,
            2056.23
        };

        String[] ref_buf = {
            "-1032.154", "0xC48104EE", "11000100100000010000010011101110",
            "0.0", "0x0", "0",
            "2056.23", "0x450083AE", "1000101000000001000001110101110"};

        String dst;
        FloatCE inst = new FloatCE();
        for (Double val : src_buf) {
            inst.setValue(val);

            dst = inst.toDec();
            if (!dst.equals(ref_buf[case_count])) {
                error_count++;
            }
            case_count++;

            dst = inst.toHex();
            if (!dst.equals(ref_buf[case_count])) {
                error_count++;
            }
            case_count++;

            dst = inst.toBin();
            if (!dst.equals(ref_buf[case_count])) {
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
