/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.HashMap;
/**
 *
 * @author wKvin
 */
public class ScheduleContainer {
    private int slotPerDay = 3;
    private int maxDays = 14;
    private int maxWorkDays = 9;
    private HashMap <Integer, Integer> scheduleItem;

    public ScheduleContainer(int slotPerday, int maxDays, int maxWorkDays){
        setSlotPerDay(slotPerday);
        setMaxDays(maxDays);
        setMaxWorkDays(maxWorkDays);
        setScheduleItem(new HashMap<>());
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
