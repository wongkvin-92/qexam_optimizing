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
    
    private static int lastKey = 0;
    private int preferenceId=0;
    private int studentID;
    private String weekDay;
    private boolean allowed;
    private int penalty;
    

    public Preference(int id, String weekDay, boolean allowed, int penalty){
        preferenceId = lastKey + 1;
        lastKey = preferenceId;
        
        setStudentId(id);
        setWeekDay(weekDay);
        setAllowed(allowed);
        setPenalty(penalty);
    }
    
    public static void resetPreferenceId()
    {
        lastKey = 0;
    }
    
    /**
     * @return the studentID
     */
    public int getStudentId() {
        return studentID;
    }

    /**
     * @param id the studentID to set
     */
    public void setStudentId(int id) {
        this.studentID = id;
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

    /**
     * @return the preferenceId
     */
    public int getPreferenceId() {
        return preferenceId;
    }
    
    public String toString(){
        return getStudentId() + "," + getWeekDay() +","+ isAllowed()+","+ getPenalty();
    }
    
}
