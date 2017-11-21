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
public class UnsignedShortCETest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class UnsignedShortCE test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class UnsignedShortCE test finish");
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

    public UnsignedShortCETest() {
    }

    /**
     * Test of setValue method, of class UnsignedShortCE.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test UnsignedShortCE.setValue");
        double[] src_buf = {-171.0, 71.0, 300000.0};
        double[] ref_buf = {0.0, 71.0, 65535.0};
        UnsignedShortCE inst = new UnsignedShortCE();
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
     * Test of decodeDec method, of class UnsignedShortCE.
     */
    @Test
    public void test_decodeDec() {
        System.out.println("Test UnsignedShortCE.decodeDec");

        String[] str_buf = {
            "0",
            "201",
            "0x1",
            "",
            "35156"
        };

        double[] ref_buf = {
            0,
            201,
            201,
            201,
            35156
        };

        UnsignedShortCE sshort = new UnsignedShortCE();
        for (String str : str_buf) {
            sshort.decodeDec(str);
            double dst = sshort.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of decodeHex method, of class UnsignedShortCE.
     */
    @Test
    public void test_decodeHex() {
        System.out.println("Test UnsignedShortCE.decodeHex");

        String[] str_buf = {
            "0",
            "-FFFF",
            "0x7fff",
            "",
            "0.1",
            "0xffff",
            "0x38000"
        };

        double[] ref_buf = {
            0,
            65535,
            32767,
            32767,
            32767,
            65535,
            32768
        };

        UnsignedShortCE num = new UnsignedShortCE();
        for (String str : str_buf) {
            num.decodeHex(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of decodeBin method, of class UnsignedShortCE.
     */
    @Test
    public void test_decodeBin() {
        System.out.println("Test UnsignedShortCE.decodeBin");

        String[] str_buf = {
            "01111111",
            "1111111",
            "1111111111111111",
            "0",
            "",
            "0.1",
            "111111111111111111"
        };

        double[] ref_buf = {
            127,
            127,
            65535,
            0,
            0,
            0,
            65535
        };

        UnsignedShortCE num = new UnsignedShortCE();
        for (String str : str_buf) {
            num.decodeBin(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of toHex/toDec/toBin method, of class UnsignedShortCE.
     */
    @Test
    public void test_toStr() {
        System.out.println("Test UnsignedShortCE.decodeDec");
        System.out.println("     UnsignedShortCE.decodeHex");
        System.out.println("     UnsignedShortCE.decodeBin");

        double[] src_buf = {
            0,
            120,
            211,
            65535
        };

        String[] ref_buf = {
            "0", "0x0", "0",
            "120", "0x78", "1111000",
            "211", "0xD3", "11010011",
            "65535", "0xFFFF", "1111111111111111"
        };

        String dst;
        UnsignedShortCE inst = new UnsignedShortCE();
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
