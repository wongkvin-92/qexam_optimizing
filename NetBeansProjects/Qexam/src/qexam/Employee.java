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
    private int[] dayNoWork = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    private boolean Allowed;
    private int Penalty;

	public Employee()
	{
		//this(0,[0][0],false, 0);
	}
	
	public Employee(int ID, int[] dayNoWork, boolean Allowed, int Penalty )
	{
		setID(ID);
                setDayNoWork(dayNoWork);
                setAllowed(Allowed);
                setPenalty(Penalty);
                
	}
    /**
     * @return the dayNoWork
     */
    public int[] getDayNoWork() {
        return dayNoWork;
    }

    /**
     * @param dayNoWork the dayNoWork to set
     */
    public void setDayNoWork(int[] dayNoWork) {
        this.dayNoWork = dayNoWork;
    }
    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID+1;
    }

    /**
     * @return the Allowed
     */
    public Boolean getAllowed() {
        return Allowed;
    }

    /**
     * @param Allowed the Allowed to set
     */
    public void setAllowed(boolean Allowed) {
        this.Allowed = Allowed;
    }

    /**
     * @return the Penalty
     */
    public Integer getPenalty() {
        return Penalty;
    }

    /**
     * @param Penalty the Penalty to set
     */
    public void setPenalty(int Penalty) {
        this.Penalty = Penalty;
    }
}
