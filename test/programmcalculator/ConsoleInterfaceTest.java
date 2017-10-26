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
public class ConsoleInterfaceTest {

    private int error_count;
    private int case_count;
    private static int test_indx = 0;

    public ConsoleInterfaceTest() {
        error_count = 0;
        case_count = 0;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Class Console Interface test start");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class Console Interface test finish");
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
     * Test of StartListen method, of class ConsoleInterface.
     */
    @Test
    public void testStartListen() {
        System.out.println("StartListen");
        ConsoleInterface instance = new ConsoleInterface();

//        instance.StartListen();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
                 
    private void case_result(int error_count, int case_count) {
        if (error_count > 0) {
            fail(error_count + "/" + case_count);
        }
        System.out.println("[Success] " + case_count + "/" + case_count);
    }
}
