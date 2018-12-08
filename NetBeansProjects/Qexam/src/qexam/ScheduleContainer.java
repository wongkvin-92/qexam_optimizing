/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author wKvin
 */
public class ScheduleContainer {
    private int slotPerDay = 3;
    private int maxDays = 14;
    private int maxWorkDays = 9;
    private HashMap <Integer, ArrayList<Integer> > scheduleItem;
    private HashMap <Integer, Preference> preferenceList;

    public ScheduleContainer(){
        this(new HashMap<Integer, Preference>());
    }
    
    
    public ScheduleContainer(HashMap<Integer, Preference> preferenceList){
        setScheduleItem(new HashMap<>());        
        this.preferenceList = preferenceList;
    }
    
    private ArrayList<Integer> getSlots(int day){
        ArrayList<Integer> slots = scheduleItem.get(day);
        if(slots == null) //initialize slots if first item of the day
            slots = new ArrayList<>();
        return slots;        
    }
    
    /**
     * Adds employee to a selected day
     * @param e
     * @param day
     * @return False if the slots are full
     */
    public boolean addSchedule(Employee e, int day){
        ArrayList<Integer> slots = getSlots(day);
        if(slots.size() < slotPerDay)
            slots.add(e.getID());
        else
            return false;
        scheduleItem.put(day, slots);
        return true;
    }
    
    /**
     * Removes employee from a given day
     * @return false if employee is not assigned to that date
     */
    public boolean removeSchedule(Employee e, int day){
        ArrayList<Integer> slots = getSlots(day);
        
        if(slots.contains(e.getID()) ){
            slots.remove(slots.indexOf(e.getID()) );
            scheduleItem.put(day, slots);
            return true;
        }else{
            return false;
        }
    }
    
    
    private int getSlotPerDay(){
        return slotPerDay;
    }
    private void setSlotPerDay( int sPerDay){
        this.slotPerDay = sPerDay;
    }
    private int getMaxDays(){
        return maxDays;
    }
    private void setMaxDays(int mDays){
        this.maxDays = mDays;
    }
    private int getMaxWorkDays(){
        return maxWorkDays;
    }
    private void setMaxWorkDays(int mWorkDays){
        this.maxWorkDays = mWorkDays;
    }
    public HashMap<Integer, ArrayList<Integer>> getScheduleItem(){
        return scheduleItem;
    }
    private void setScheduleItem(HashMap<Integer, ArrayList<Integer>>scheduleItem){
        this.scheduleItem = scheduleItem; 
    }
}
