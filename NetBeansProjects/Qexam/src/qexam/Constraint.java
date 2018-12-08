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
public class Constraint {
    private int id;
    private int [] weekDay;
    private boolean allowed;
    private int pelnaty;
    
    public Constraint(){
    
    }
    public Constraint(int id, int [] weekDay, boolean allowed, int pelnaty){
        setId(id);
        setWeekDay(weekDay);
        setAllowed(allowed);
        setPelnaty(pelnaty);
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the weekDay
     */
    public int[] getWeekDay() {
        return weekDay;
    }

    /**
     * @param weekDay the weekDay to set
     */
    public void setWeekDay(int[] weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * @return the allowed
     */
    public boolean isAllowed() {
        return allowed;
    }

    /**
     * @param allowed the allowed to set
     */
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    /**
     * @return the pelnaty
     */
    public int getPelnaty() {
        return pelnaty;
    }

    /**
     * @param pelnaty the pelnaty to set
     */
    public void setPelnaty(int pelnaty) {
        this.pelnaty = pelnaty;
    }
    
}
