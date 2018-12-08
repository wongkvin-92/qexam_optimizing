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
    
    public Employee(String name)
    {
        this(name, last_id+1, 0);
            //this(0,[0][0],false, 0);
    }

    public Employee(String name, int ID, int daysWorked )
    {
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
        this.ID = ID+1;
        this.last_id = ID+1;
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
}
