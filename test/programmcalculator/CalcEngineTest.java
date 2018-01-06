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
import programmcalculator.CalcEngine.Operation;
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

        //TODO Write this text
        error_count = 100500;

//        CalcEngine.Operation[] operations = {
//            CalcEngine.Operation.ADD,
//            CalcEngine.Operation.DIV,
//            CalcEngine.Operation.MULTI,
//            CalcEngine.Operation.SUB
//        };
//
//        double[] value0 = {-1024.54, 0, 999.123134};
//        double[] value1 = {5000, 0, 123};
//
//        CalcEngine instance = new CalcEngine();
//        instance.setDataType(data_type_e.DOUBLE);
//        for (double val0 : value0) {
//            for (double val1 : value1) {
//                for (CalcEngine.Operation op : operations) {
//                    instance.setValue(val0);
//                    instance.setCommand(op);
//                    instance.setValue(val1);
//
//                    instance.setCommand(CalcEngine.Operation.EQUAL);
//                    double dst = instance.getValue();
//                    double ref = ref_command(op, val0, val1);
//
//                    if (ref != dst) {
//                        error_count++;
//                    }
//                    case_count++;
//                }
//            }
//        }
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
     * Test of setViewMode/getViewMode method, of class Value.
     */
    @Test
    public void testSetViewMode() {
        System.out.println("Test CalcEngine.setViewMode");
        System.out.println("                getViewMode");

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
     * Test of setDataType/getDataType method, of class CalcEngine.
     */
    @Test
    public void testSetDataType() {
        System.out.println("Test CalcEngine.setDataType");
        System.out.println("                getDataType");

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

    /**
     * Test of parseString/toString method, of class CalcEngine.
     */
    @Test
    public void testStrings() {
        System.out.println("Test CalcEngine.parseString");
        System.out.println("                  getResult");

        String[] str_buf = {
            "",
            "10101011",
            "0xAB",
            "0.1",
            "171"
        };

        Double ref_value = 171.0;
        Double dst = 0.0;

        CalcEngine ce = new CalcEngine();

        //Bin
        ce.setViewMode(view_mode_e.BIN);
        String[] ref_bin = {
            "",
            "10101011",
            "",
            "",
            ""
        };
        for (int i = 0; i < str_buf.length; i++) {
            try {
                ce.parseString(str_buf[i]);
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }

            String dst_str = ce.toString();
            if (!dst_str.equals(ref_bin[i])) {
                error_count++;
            }
            case_count++;
        }

        //Dec
        ce.setViewMode(view_mode_e.DEC);
        String[] ref_dec = {
            "",
            "10101011",
            "",
            "0",
            "171"
        };
        for (int i = 0; i < str_buf.length; i++) {
            try {
                ce.parseString(str_buf[i]);
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }

            String dst_str = ce.toString();
            if (!dst_str.equals(ref_dec[i])) {
                error_count++;
            }
            case_count++;
        }

        //Hex
        ce.setViewMode(view_mode_e.HEX);
        String[] ref_hex = {
            "",
            "0x10101011",
            "0xAB",
            "",
            "0x171"
        };
        for (int i = 0; i < str_buf.length; i++) {
            try {
                ce.parseString(str_buf[i]);
            } catch (NullPointerException | NumberFormatException e) {
                case_count++;
                continue;
            }

            String dst_str = ce.toString();
            if (!dst_str.equals(ref_hex[i])) {
                error_count++;
            }
            case_count++;
        }
    }

    /**
     * Test of setValue/hetValue method, of class CalcEngine.
     */
    @Test
    public void testSetValue() {
        System.out.println("Test CalcEngine.setValue");
        System.out.println("                getValue");

        double src = 171.0;
        double dst;

        CalcEngine ce = new CalcEngine();

        //Bin
        ce.setValue(src);

        dst = ce.getValue();
        if (dst != src) {
            error_count++;
        }
        case_count++;
    }

    /**
     * Test of setCommand/getCommand method, of class CalcEngine.
     */
    @Test
    public void testSetCommand() {
        System.out.println("Test CalcEngine.setCommand");
        System.out.println("                getCommand");

        Operation[] src_buff = {
            Operation.ADD,
            Operation.DIV,
            Operation.EQUAL,
            Operation.INIT,
            Operation.MULTI,
            Operation.NOT_INIT,
            Operation.SUB
        };

        int cmd_count = src_buff.length;

        CalcEngine ce = new CalcEngine();

        for (Operation src : src_buff) {
            ce.setCommand(src);

            Operation dst = ce.getCommand();

            if (dst != src && src != Operation.EQUAL) {
                error_count++;
            } else if (Operation.values().length != cmd_count) {
                error_count++;
            }

            case_count++;
        }
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("Success tests " + case_count + "/" + case_count + "\n");
    }
}
