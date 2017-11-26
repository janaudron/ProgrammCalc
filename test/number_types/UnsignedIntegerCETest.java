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
public class UnsignedIntegerCETest {
    private int error_count;
    private int case_count;
    private static int test_indx = 0;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class UnsignedIntegerCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class UnsignedIntegerCE test finish");
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
    
    public UnsignedIntegerCETest() {
    }
    
    /**
     * Test of setValue method, of class UnsignedIntegerCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test UnsignedIntegerCE.setValue");
        double[] src_buf = {-34359738367.0, 1024.0, 42949672950.0};
        double[] ref_buf = {-0.0, 1024.0, 4294967295.0};
        UnsignedIntegerCE inst = new UnsignedIntegerCE();
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
     * Test of decodeDec method, of class UnsignedIntegerCE.
     */
    @Test
    public void test_decodeDec() {
        System.out.println("Test UnsignedIntegerCE.decodeDec");

        String[] str_buf = {
            "-2147483648",
            "1073741824",
            "0x1",
            "",
            "-1"
        };

        double[] ref_buf = {
            0,
            1073741824,
            1073741824,
            1073741824,
            0
        };

        UnsignedIntegerCE num = new UnsignedIntegerCE();
        for (String str : str_buf) {
            try {
                num.decodeDec(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }    
    
    /**
     * Test of decodeHex method, of class UnsignedIntegerCE.
     */
    @Test
    public void test_decodeHex() {
        System.out.println("Test UnsignedIntegerCE.decodeHex");

        String[] str_buf = {
            "0",
            "-FFFFFFFF",
            "0x7fffffff",
            "",
            "0.1",
            "0xffffffff",
            "0x380000000"
        };

        double[] ref_buf = {
            0,
            4294967295L,
            2147483647,
            2147483647,
            2147483647,
            4294967295L,
            2147483648L
        };

        UnsignedIntegerCE num = new UnsignedIntegerCE();
        for (String str : str_buf) {
            try {
                num.decodeHex(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }   

    /**
     * Test of decodeBin method, of class UnsignedIntegerCE.
     */
    @Test
    public void test_decodeBin() {
        System.out.println("Test UnsignedIntegerCE.decodeBin");

        String[] str_buf = {
            "01111111",
            "1111111",
            "11111111111111111111111111111111",
            "0",
            "",
            "0.1",
            "11111111111111111111111111111111"
        };

        double[] ref_buf = {
            127,
            127,
            4294967295L,
            0,
            0,
            0,
            4294967295L
        };

        UnsignedIntegerCE num = new UnsignedIntegerCE();
        for (String str : str_buf) {
            try {
                num.decodeBin(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }    
    
/**
     * Test of toHex/toDec/toBin method, of class UnsignedIntegerCE.
     */
    @Test
    public void test_toStr() {
        System.out.println("Test UnsignedIntegerCE.decodeDec");
        System.out.println("     UnsignedIntegerCE.decodeHex");
        System.out.println("     UnsignedIntegerCE.decodeBin");

        double[] src_buf = {
            0,
            120,
            211,
            4294967295L
        };

        String[] ref_buf = {
            "0", "0x0", "0",
            "120", "0x78", "1111000",
            "211", "0xD3", "11010011",
            "4294967295", "0xFFFFFFFF", "11111111111111111111111111111111"
        };

        String dst;
        UnsignedIntegerCE inst = new UnsignedIntegerCE();
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
