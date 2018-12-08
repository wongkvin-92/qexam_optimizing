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
public class Preference {
    private int id;
    private String weekDay;
    private boolean allowed;
    private int penalty;
    
    public Preference(){
    
    }
    public Preference(int id, String weekDay, boolean allowed, int pelnaty){
        setId(id);
        setWeekDay(weekDay);
        setAllowed(allowed);
        setPenalty(penalty);
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
    public String getWeekDay() {
        return weekDay;
    }

    /**
     * @param weekDay the weekDay to set
     */
    public void setWeekDay(String weekDay) {
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
     * @return the penalty
     */
    public int getPenalty() {
        return penalty;
    }

    /**
     * @param pelnaty the penalty to set
     */
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    
}
