/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shath
 */
public class ScheduleContainerTest {
    
    public ScheduleContainerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSchedule method, of class ScheduleContainer.
     */
    @Test
    public void testAddSchedule() {
        System.out.println("addSchedule");
        Employee e = new Employee("Kevin");
        int day = 1;
        ScheduleContainer instance = new ScheduleContainer();                
        boolean result = instance.addSchedule(e, day);
        assertEquals(true, result);                
    }
    
    
        /**
     * Test of addSchedule method, of class ScheduleContainer.
     */
    @Test
    public void testRemoveSchedule() {
        System.out.println("addSchedule");
        Employee e = new Employee("Kevin2");
        int day = 1;
        ScheduleContainer instance = new ScheduleContainer();                
        boolean result1 = instance.addSchedule(e, day);
        boolean result2 = instance.removeSchedule(e, day);
        assertEquals(true, result1);      
        assertEquals(true, result2);
    }
    
}
