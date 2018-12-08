/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;

/**
 *
 * @author wKvin
 */
public class Employee {
    private static int last_id = 0;
    
    private int ID;
    private int daysWorked;
    private String name;
    
    public static void resetAutoIncrement(){
        last_id = 0;
    }
    
    public Employee(String name)
    {
        this(name, last_id+1, 0);
            //this(0,[0][0],false, 0);
    }

    public Employee(String name, int ID, int daysWorked )
    {
        setName(name);
        setID(ID);
        setDaysWorked(daysWorked);
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
        this.last_id = this.ID;
    }

    /**
     * @return the daysWorked
     */
    public int getDaysWorked() {
        return daysWorked;
    }

    /**
     * @param daysWorked the daysWorked to set
     */
    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }
    public String toString()
    {
            return getID() + ","+ getName() + ","   + getDaysWorked();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
        
}
