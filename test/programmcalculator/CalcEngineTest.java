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
     * Test of setCommand method, of class CalcEngine.
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

        double[] value0 = {-1024.54, 0, 999.123134};
        double[] value1 = {5000, 0, 123};

        CalcEngine instance = new CalcEngine();
        instance.setDataType(data_type_e.DOUBLE);
        for (double val0 : value0) {
            for (double val1 : value1) {
                for (CalcEngine.Operation op : operations) {
                     instance.setVal(val0);
                    instance.setCommand(op);
                    instance.setVal(val1);

                    instance.setCommand(CalcEngine.Operation.EQUAL);
                    double dst = instance.getVal();
                    double ref = ref_command(op, val0, val1);

                    if (ref != dst) {
                        error_count++;
                    }
                    case_count++;
                }
            }
        }
    }

    private double ref_command(CalcEngine.Operation op, double a, double b) {
        switch (op) {
            case ADD:
                return ref_add(a, b);
            case SUB:
                return ref_sub(a, b);
            case MULTI:
                return ref_mult(a, b);
            case DIV:
                return ref_div(a, b);
            default:
            return 0;
        }
        
    }

    private double ref_add(double a, double b) {
        return a + b;
    }

    private double ref_sub(double a, double b) {
        return a - b;
    }

    private double ref_mult(double a, double b) {
        return a * b;
    }

    private double ref_div(double a, double b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
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

        for (view_mode_e dst_mode : view_modes) {
            CalcEngine instance = new CalcEngine();

            instance.setViewMode(dst_mode);
            view_mode_e ref_mode = instance.getViewMode();

            if (ref_mode != dst_mode) {
                error_count++;
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
            data_type_e.BYTE,
            data_type_e.UBYTE,
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
