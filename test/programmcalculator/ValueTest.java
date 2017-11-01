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
     * Test of setValue method, of class Value. TODO Need transform test for
     * saturate
     */
    @Test
    public void testSetValue_long() {
        System.out.println("Test Value.setValue int");
        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.UCHAR,
            data_type_e.SHORT,
            data_type_e.USHORT,
            data_type_e.INT,
            data_type_e.UINT,
            data_type_e.LONG};

        long[] value = {
            0x8000000000000000L, 0x7fffffffffffffffL,
            0xffffffff80000000L, 0x7fffffff,
            0xffffffffffff8000L, 0x7fff,
            0xffffffffffffff80L, 0x7f,
            0xc1, 0x3f,
            0x0
        };

        Value instance = new Value();
        for (data_type_e type : dtypes) {
            instance.setDataType(type);
            long min_val = Value.getMinValue(type);
            long max_val = Value.getMaxValue(type);
            for (long val : value) {
                instance.setValue(val);
                long inst_val = (long) instance.getValue();
                if (inst_val > max_val || inst_val < min_val) {
                    error_count++;
                }
                case_count++;
            }

        }
    }

    /**
     * Test of setValue method, of class Value.
     */
    @Test
    public void testSetValue_float() {
        System.out.println("Test Value.setValue_float");
        float[] value = {-10.0F, -1.21F, -0.0001F, 0.0f, 0.0001F, 2.132F, 100.0F};
//        for (float val : value) {
//            Value instance = new Value();
//            instance.setValue(val);
//            float inst_value = instance.getValue();
//            if (inst_value != val) {
//                error_count++;
//            }
//            case_count++;
//        }
    }

    /**
     * Test of getValue method, of class Value.
     */
    @Test
    public void testGetValue() {
        System.out.println("Test Value.getValue");
        this.testSetValue_float();
        this.testSetValue_long();
    }

    /**
     * Test of setDataType method, of class Value.
     */
    @Test
    public void testSetDataType() {
        System.out.println("Test Value.setDataType");
        data_type_e[] type = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG,
            data_type_e.FLOAT,
            data_type_e.SHORT
        };

        Value instance = new Value();

        for (data_type_e dtype : type) {
            instance.setDataType(dtype);
            if (dtype != instance.getDataType()) {
                this.error_count++;
            }
            this.case_count++;
        }
    }

    /**
     * Test of getDataType method, of class Value.
     */
    @Test
    public void testGetDataType() {
        System.out.println("Test Value.getDataType");
        data_type_e[] type = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG,
            data_type_e.FLOAT,
            data_type_e.SHORT
        };

        Value instance = new Value();

        for (data_type_e dtype : type) {
            instance.setDataType(dtype);
            if (dtype != instance.getDataType()) {
                this.error_count++;
            }
            this.case_count++;
        }
    }

    /**
     * Test of getMinValue method, of class Value.
     */
    @Test
    public void testGetMinValue_0args() {
        System.out.println("Test Value.getMinValue_0args");

        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG
        };

        Value instance = new Value();

        for (data_type_e type : dtypes) {
            instance.setDataType(type);
            long inst_min = instance.getMinValue();

            long min_val = ref_get_min_val(type);

            if (min_val != inst_min) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of getMinValue method, of class Value.
     */
    @Test
    public void testGetMinValue_Valuedata_type_e() {
        System.out.println("Test Value.getMinValue");

        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG
        };

        for (data_type_e type : dtypes) {
            long inst_min = Value.getMinValue(type);

            long min_val = ref_get_min_val(type);

            if (min_val != inst_min) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of getMaxValue method, of class Value.
     */
    @Test
    public void testGetMaxValue_0args() {
        System.out.println("Test Value.getMaxValue_0_args");

        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG
        };

        Value instance = new Value();

        for (data_type_e type : dtypes) {
            instance.setDataType(type);
            long inst_max = instance.getMaxValue();

            long max_val = this.ref_get_max_val(type);

            if (max_val != inst_max) {
                error_count++;
            }

            case_count++;
        }
    }

    /**
     * Test of getMaxValue method, of class Value.
     */
    @Test
    public void testGetMaxValue_Valuedata_type_e() {
        System.out.println("Test Value.getMaxValue");

        data_type_e[] dtypes = {
            data_type_e.CHAR,
            data_type_e.SHORT,
            data_type_e.INT,
            data_type_e.LONG
        };

        for (data_type_e type : dtypes) {
            long inst_max = Value.getMaxValue(type);

            long max_val = this.ref_get_max_val(type);

            if (max_val != inst_max) {
                error_count++;
            }

            case_count++;
        }

    }

    /**
     * reference get min value
     * @param type - data type
     * @return 
     */
    private long ref_get_min_val(data_type_e type) {
        switch (type) {
            case CHAR:
                return 0xffffffffffffff80L;
            case UCHAR:
                return 0x0L;
            case SHORT:
                return 0xffffffffffff8000L;
            case USHORT:
                return 0x0L;
            case INT:
                return 0xffffffff80000000L;
            case UINT:
                return 0x0L;
            case LONG:
                return 0x8000000000000000L;
        }
        return 0;
    }
    
    /**
     * reference get max value
     * @param type - data type
     * @return 
     */
    private long ref_get_max_val(data_type_e type) {
        switch (type) {
            case CHAR:
                return 0x7fL;
            case UCHAR:
                return 0xffL;
            case SHORT:
                return 0x7fffL;
            case USHORT:
                return 0xffffL;
            case INT:
                return 0x7fffffffL;
            case UINT:
                return 0xffffffffL;
            case LONG:
                return 0x7fffffffffffffffL;
        }
        return 0;
    }

    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("Success " + case_count + "/" + case_count + "\n");
    }
}
