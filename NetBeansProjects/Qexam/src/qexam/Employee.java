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


    private int ID;
    private int[] daysWorked = {};

	public Employee()
	{
		//this(0,[0][0],false, 0);
	}
	
	public Employee(int ID, int[] daysWorked )
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
    }

    /**
     * @return the daysWorked
     */
    public int[] getDaysWorked() {
        return daysWorked;
    }

    /**
     * @param daysWorked the daysWorked to set
     */
    public void setDaysWorked(int[] daysWorked) {
        this.daysWorked = daysWorked;
    }
}
