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
 * @author wKvin
 */
public class EmployeeTest {
    
    public EmployeeTest() {
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
        Employee.resetAutoIncrement();
    }
    
    @Test
    public void testAutoIncrement(){
        Employee emp1, emp2, emp3;
        
        emp1 = new Employee("wong");
        assert(emp1.getID() == 1);
        emp2 = new Employee("ibrahim");
        assert(emp2.getID() == 2);
        emp3 = new Employee("wong2");
        assert(emp3.getID() == 3);
    }
    
    @Test
    public void testGetName(){
        Employee e = new Employee("wong");
        assert(e.getName().compareTo("wong") == 0);
    }
    
    @Test
    public void testToString(){
        Employee e = new Employee("aa");
        assert(e.toString().compareTo("1,aa,0")==0);
    }
    

    
}
