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

import programmcalculator.Value.view_mode_e.*;

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
        System.out.println("Test " + test_indx + " finish\n");
        test_indx++;
    }

    /**
     * Test of setValue method, of class Value.
     */
    @Test
    public void testSetValue_int() {
        System.out.println("Test setValue int");
        int[] value = {0xfffffff, -10, 0, 10, 0x7fffffff};

        for (float val : value) {
            Value instance = new Value();
            instance.setValue(val);
            int inst_value = (int) instance.getValue();
            if (inst_value != val) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of setValue method, of class Value.
     */
    @Test
    public void testSetValue_float() {
        System.out.println("Test setValue float");
        float[] value = {-10.0F, -1.21F, -0.0001F, 0.0f, 0.0001F, 2.132F, 100.0F};
        for (float val : value) {
            Value instance = new Value();
            instance.setValue(val);
            float inst_value = instance.getValue();
            if (inst_value != val) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of setViewMode method, of class Value.
     */
    @Test
    public void testSetViewMode() {
        System.out.println("Test setViewMode");

        Value.view_mode_e[] view_modes = {
            Value.view_mode_e.BIN,
            Value.view_mode_e.HEX,
            Value.view_mode_e.DEC
        };
        int val = 128;

        for (Value.view_mode_e mode : view_modes) {
            Value instance = new Value();

            instance.setValue(val);
            instance.setViewMode(mode);
            String str = instance.getStr();

            System.out.println(str);
            String _str = "";
            switch (mode) {
                case BIN:
                    _str = Integer.toBinaryString(val);
                    if (!str.equals(_str)) {
                        error_count++;
                    }
                    break;
                case DEC:
                    _str = Integer.toString(val);
                    if (!str.equals(_str)) {
                        error_count++;
                    }
                    break;
                case HEX:
                    _str = "0x" + Integer.toHexString(val);
                    if (!str.equals(_str)) {
                        error_count++;
                    }
                    break;
            }
            case_count++;
        }
    }

    /**
     * Test of getValue method, of class Value.
     */
    @Test
    public void testGetValue() {
        System.out.println("Test getValue");
        this.testSetValue_float();
        this.testSetValue_int();
    }

    /**
     * Test of getStr method, of class Value.
     */
    @Test
    public void testGetStr() {
        System.out.println("Test getStr");
        this.testSetViewMode();
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("Success " + case_count + "/" + case_count);
    }

}
