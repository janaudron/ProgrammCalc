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

/**
 *
 * @author JAudron
 */
public class CalcEngineTest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public CalcEngineTest() {
        error_count = 0;
        case_count = 0;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class CalcEngine test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class CalcEngine test finish\n");
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
     * Test of command method, of class CalcEngine.
     */
    @Test
    public void testCommand() {
        System.out.println("Test command");

        CalcEngine.Operation[] operations = {
            CalcEngine.Operation.ADD,
            CalcEngine.Operation.DIV,
            CalcEngine.Operation.MULTI,
            CalcEngine.Operation.SUB
        };

        int[] value0 = {0x80000000, 0, 0x7fffffff};
        int[] value1 = {0x80000000, 0, 0x7fffffff};

        for (int val0 : value0) {
            for (int val1 : value1) {
                for (CalcEngine.Operation op : operations) {
                    int ref = 0;
                    int calc = 0;
                    CalcEngine instance = new CalcEngine();

                    instance.setVal(val0);
                    instance.command(op);
                    instance.setVal(val1);
                    instance.command(CalcEngine.Operation.EQUAL);
                    calc = Integer.decode(instance.getResult());
                    switch (op) {
                        case ADD:
                            ref = val0 + val1;
                            break;
                        case DIV:
                            try {
                                ref = val0 / val1;
                            } catch (ArithmeticException e) {
                                ref = 0;
                            }
                            break;
                        case MULTI:
                            ref = val0 * val1;
                            break;
                        case SUB:
                            ref = val0 - val1;
                            break;
                    }
                    if (ref != calc) {
                        error_count++;
                    }
                    case_count++;
                }
            }
        }
    }

    /**
     * Test of get_result method, of class CalcEngine.
     */
    @Test
    public void testGet_result() {
        System.out.println("Test get_result");

        Value.view_mode_e[] view_mode = {
            Value.view_mode_e.BIN,
            Value.view_mode_e.DEC,
            Value.view_mode_e.HEX
        };

        int value = 0xab;
        for (Value.view_mode_e vmode : view_mode) {
            CalcEngine instance = new CalcEngine();

            instance.setVal(value);
            instance.setViewMode(vmode);
            String inst_value = instance.getResult();

            String ref_value = "";
            switch (vmode) {
                case BIN:
                    ref_value = Integer.toBinaryString(value);
                    break;
                case DEC:
                    ref_value = Integer.toString(value);
                    break;
                case HEX:
                    ref_value = "0x" + Integer.toHexString(value);
                    break;
            }

            if (!ref_value.equals(inst_value)) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of set_val method, of class CalcEngine.
     */
    @Test
    public void testSet_val() {
        System.out.println("Test set_val");
        int[] value = {0x80000000, 0x0, 0x7fffffff};
        for (int val : value) {
            CalcEngine instance = new CalcEngine();
            instance.setVal(val);

            Value.view_mode_e view_mode = Value.view_mode_e.DEC;
            instance.setViewMode(view_mode);

            String str_inst_val = instance.getResult();
            String str_val = Integer.toString(val);

            if (!str_val.equals(str_inst_val)) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of set_view_mod method, of class CalcEngine.
     */
    @Test
    public void testSet_view_mod() {
        testGet_result();
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("[Success] " + case_count + "/" + case_count);
    }

}
