/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmcalculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import programmcalculator.Value.data_type_e;

/**
 *
 * @author JAudron
 */
public class ValueTest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public ValueTest() {
        error_count = 0;
        case_count = 0;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class Value test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class Value test finish");
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
     * Test of setValue method, of class Value.
     */
    @Test
    public void testSetValue_type() {
        System.out.println("Test Value.setValue");
        System.out.println("           getValue");
        Value inst = new Value();

        double ref = 121.0;

        inst.setValue(ref);
        inst.setDataType(data_type_e.BYTE);

        double dst = inst.getValue();
        if (dst != ref) {
            error_count++;
        }
        case_count++;
    }

    /**
     * Test of setDataType method, of class Value.
     */
    @Test
    public void testSetDataType() {
        System.out.println("Test Value.setDataType");
        System.out.println("           getDataType");

        data_type_e[] types_buf = {
            data_type_e.BYTE,
            data_type_e.UBYTE,
            data_type_e.SHORT,
            data_type_e.USHORT,
            data_type_e.INT,
            data_type_e.UINT,
            data_type_e.LONG,
            data_type_e.FLOAT,
            data_type_e.DOUBLE,};

        Value inst = new Value();
        for (data_type_e ref_type : types_buf) {
            inst.setDataType(ref_type);
            data_type_e dst_type = inst.getDataType();

            if (dst_type != ref_type) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of setStr method of class Value
     */
    @Test
    public void testToStr() {
        System.out.println("Test Value.toHex");
        System.out.println("           toBin");
        System.out.println("           toDec");

        String dst = "";
        double ref = 171;
        String[] str_buf = {
            "0xAB", "171", "10101011"
        };

        Value val = new Value();
        val.setValue(ref);

        dst = val.toHex();
        if (!dst.equals(str_buf[0])) {
            error_count++;
        }
        dst = val.toDec();
        if (!dst.equals(str_buf[1])) {
            error_count++;
        }
        dst = val.toBin();
        if (!dst.equals(str_buf[2])) {
            error_count++;
        }

        case_count += 3;
    }

    /**
     * Test of Decode method of class Value
     */
    @Test
    public void testDecode() {
        System.out.println("Test Value.DecodeHex");
        System.out.println("           DecodeBin");
        System.out.println("           DecodeDec");

        double ref = 171;
        Value val = new Value();
        
        String[] hex_buf = {
            "0xAB",  "", "xo"
        };
        for (String str : hex_buf) {
            double tmp = 0;
            try {
                val.DecodeHex(str);
                tmp = val.getValue();
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }
            if (tmp != ref) {
                error_count++;
            }
            case_count++;
        }
        
        String[] dec_buf = {
            "171", "", "dr"
        };
        for (String str : dec_buf) {
            double tmp = 0;
            try {
                val.DecodeDec(str);
                tmp = val.getValue();
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }
            if (tmp != ref) {
                error_count++;
            }
            case_count++;
        }
        
        String[] bin_buf = {
            "10101011", "", "76"
        };
        for (String str : bin_buf) {
            double tmp = 0;
            try {
                val.DecodeBin(str);
                tmp = val.getValue();
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }
            if (tmp != ref) {
                error_count++;
            }
            case_count++;
        }

    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("Success " + case_count + "/" + case_count + "\n");
    }
}
