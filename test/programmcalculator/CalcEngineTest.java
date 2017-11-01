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
import programmcalculator.CalcEngine.view_mode_e;
import programmcalculator.Value.data_type_e;

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
        test_indx++;
    }

    /**
     * Test of command method, of class CalcEngine.
     */
    @Test
    public void testCommand() {
        System.out.println("Test CalcEngine.command");

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
    public void testGetResult() {
        System.out.println("Test CalcEngine.GetResult");

        view_mode_e[] view_mode = {
            view_mode_e.BIN,
            view_mode_e.DEC,
            view_mode_e.HEX
        };

        int value = 0xab;
        for (view_mode_e vmode : view_mode) {
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
    public void testSetVal() {
        System.out.println("Test CalcEngine.SetVal");
        int[] value = {0x80000000, 0x0, 0x7fffffff};
        for (int val : value) {
            CalcEngine instance = new CalcEngine();
            instance.setVal(val);

            view_mode_e view_mode = view_mode_e.DEC;
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
     * Test of setViewMode method, of class Value.
     */
    @Test
    public void testSetViewMode() {
        System.out.println("Test CalcEngine.setViewMode");

        view_mode_e[] view_modes = {
            view_mode_e.BIN,
            view_mode_e.HEX,
            view_mode_e.DEC
        };
        int val = 128;

        for (view_mode_e mode : view_modes) {
            CalcEngine instance = new CalcEngine();

            instance.setVal(val);
            instance.setViewMode(mode);
            String inst_str = instance.getResult();

            System.out.println(inst_str);
            String _str = "";
            switch (mode) {
                case BIN:
                    _str = Integer.toBinaryString(val);
                    if (!inst_str.equals(_str)) {
                        error_count++;
                    }
                    break;
                case DEC:
                    _str = Integer.toString(val);
                    if (!inst_str.equals(_str)) {
                        error_count++;
                    }
                    break;
                case HEX:
                    _str = "0x" + Integer.toHexString(val);
                    if (!inst_str.equals(_str)) {
                        error_count++;
                    }
                    break;
            }
            case_count++;
        }
    }

    /**
     * Test of setDataType method, of class CalcEngine.
     */
    @Test
    public void testSetDataType() {
        System.out.println("Test CalcEngine.setDataType");
        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.UCHAR,
            data_type_e.SHORT,
            data_type_e.USHORT,
            data_type_e.INT,
            data_type_e.UINT,
            data_type_e.LONG
        };

        CalcEngine instance = new CalcEngine();

        for (data_type_e type : dtypes) {
            instance.setDataType(type);
            data_type_e inst_type = instance.getDataType();

            if (!type.equals(inst_type)) {
                error_count++;
            }
            case_count++;
        }
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("Success tests " + case_count + "/" + case_count);
    }
}
