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

    public ScheduleContainer(HashMap<Integer, Preference> preferenceList){
        setScheduleItem(new HashMap<>());
        this.preferenceList = preferenceList;
    }
    
    public boolean addSchedule(Employee e, int day){
        
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
    private HashMap<Integer, Integer> getScheduleItem(){
        return scheduleItem;
    }
    private void setScheduleItem(HashMap<Integer, Integer>scheduleItem){
        this.scheduleItem = scheduleItem; 
    }
}
