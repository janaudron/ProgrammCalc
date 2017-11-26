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
public class UnsignedByteCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class UnsignedByteCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class UnsignedByteCE test finish");
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

    public UnsignedByteCETest() {
    }

    /**
     * Test of setValue method, of class UnsignedByteCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test UnsignedByteCE.setValue");
        double[] src_buf = {-171.0, 71.0, 300.0};
        double[] ref_buf = {0.0, 71.0, 255.0};
        UnsignedByteCE inst = new UnsignedByteCE();
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
     * Test of decodeDec method, of class UnsignedByteCE.
     */
    @Test
    public void test_decodeDec() {
        System.out.println("Test UnsignedByteCE.decodeDec");

        String[] str_buf = {
            "0",
            "201",
            "0x1",
            "",
            "255"
        };

        double[] ref_buf = {
            0,
            201,
            201,
            201,
            255
        };

        UnsignedByteCE ubyte = new UnsignedByteCE();
        for (String str : str_buf) {
            try {
                ubyte.decodeDec(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            
            double dst = ubyte.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of decodeHex method, of class UnsignedByteCE.
     */
    @Test
    public void test_decodeHex() {
        System.out.println("Test UnsignedByteCE.decodeHex");

        String[] str_buf = {
            "0",
            "-FF",
            "0x7f",
            "",
            "0.1",
            "0xff",
            "0x3ff"
        };

        double[] ref_buf = {
            0,
            255,
            127,
            127,
            127,
            255,
            255
        };

        UnsignedByteCE ubyte = new UnsignedByteCE();
        for (String str : str_buf) {
            try {
                ubyte.decodeHex(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            double dst = ubyte.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of decodeBin method, of class UnsignedByteCE.
     */
    @Test
    public void test_decodeBin() {
        System.out.println("Test UnsignedByteCE.decodeBin");

        String[] str_buf = {
            "0",
            "01111111",
            "1111111",
            "",
            "0.1",
            "11111111",
            "111111111"
        };

        double[] ref_buf = {
            0,
            127,
            127,
            127,
            127,
            255,
            255
        };

        UnsignedByteCE ubyte = new UnsignedByteCE();
        for (String str : str_buf) {
            try {
                ubyte.decodeBin(str);
            } catch (NumberFormatException | NullPointerException e){
                case_count++;
                continue;
            }
            
            double dst = ubyte.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of toHex/toDec/toBin method, of class UnsignedByteCE.
     */
    @Test
    public void test_toStr() {
        System.out.println("Test UnsignedByteCE.decodeDec");
        System.out.println("     UnsignedByteCE.decodeHex");
        System.out.println("     UnsignedByteCE.decodeBin");

        double[] src_buf = {
            0,
            120,
            211
        };

        String[] ref_buf = {
            "0", "0x0", "0",
            "120", "0x78", "1111000",
            "211", "0xD3", "11010011"
        };

        String dst;
        UnsignedByteCE ubyte = new UnsignedByteCE();
        for (Double val : src_buf) {
            ubyte.setValue(val);

            dst = ubyte.toDec();
            if (!dst.equals(ref_buf[case_count])) {
                error_count++;
            }
            case_count++;

            dst = ubyte.toHex();
            if (!dst.equals(ref_buf[case_count])) {
                error_count++;
            }
            case_count++;

            dst = ubyte.toBin();
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
