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
     * Test of decodeDec method, of class LongCE.
     */
    @Test
    public void test_decodeDec() {
        System.out.println("Test LongCE.decodeDec");

        String[] str_buf = {
            "-214748364800",
            "1073741824",
            "0x1",
            "",
            "-1"
        };

        double[] ref_buf = {
            -214748364800L,
            1073741824,
            1073741824,
            1073741824,
            -1
        };

        LongCE num = new LongCE();
        for (String str : str_buf) {
            num.decodeDec(str);
            double dst = num.getValue();
            if (dst != ref_buf[case_count]) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of decodeHex method, of class LongCE.
     */
    @Test
    public void test_decodeHex() {
        System.out.println("Test LongCE.decodeHex");

        String[] str_buf = {
            "8000000000000001",
            "0",
            "-FFFFFFFFFFFFFFFF",
            "0x7fffffffffffffff",
            "",
            "0.1",
            "0xffffffffffffffff",
            "0x38000000000000000"
        };

        double[] ref_buf = {
            -9223372036854775807L,
            0,
            -1,
            9223372036854775807L,
            9223372036854775807L,
            9223372036854775807L,
            -1,
            -9223372036854775808L
        };

        LongCE num = new LongCE();
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
     * Test of decodeBin method, of class LongCE.
     */
    @Test
    public void test_decodeBin() {
        System.out.println("Test LongCE.decodeBin");

        String[] str_buf = {
            "01111111",
            "1111111",
            "1111111111111111111111111111111111111111111111111111111111111111",
            "0",
            "",
            "0.1",
            "1111111111111111111111111111111111111111111111111111111111111111"
        };

        double[] ref_buf = {
            127,
            127,
            -1,
            0,
            0,
            0,
            -1
        };

        LongCE num = new LongCE();
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
     * Test of toHex/toDec/toBin method, of class LongCE.
     */
    @Test
    public void test_toStr() {
        System.out.println("Test LongCE.decodeDec");
        System.out.println("     LongCE.decodeHex");
        System.out.println("     LongCE.decodeBin");

        double[] src_buf = {
            0,
            120,
            211,
            -1
        };

        String[] ref_buf = {
            "0", "0x0", "0",
            "120", "0x78", "1111000",
            "211", "0xD3", "11010011",
            "-1", "0xFFFFFFFFFFFFFFFF", "1111111111111111111111111111111111111111111111111111111111111111"
        };

        String dst;
        LongCE inst = new LongCE();
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
