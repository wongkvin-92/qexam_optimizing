/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author wKvin
 */
public class ScheduleContainer {
    private int slotPerDay = 3;
    private int maxStudents = 5;
    private int maxDays = 14;
    private int maxWorkDays = 9;
    
    private HashMap <Integer, ArrayList<Integer> > schedule;
    private HashMap <Integer, Preference> preferenceList;
    private HashMap<Integer, Employee> employees;

    public ScheduleContainer(){
        this(new HashMap<Integer, Preference>(), new HashMap<Integer, Employee>());
    }
  
    
    public ScheduleContainer(HashMap<Integer, Preference> preferenceList,
                             HashMap<Integer, Employee> employees
            ){
        setSchedule(new HashMap<>());        
        this.employees = employees;        
        for(int i=1; i<= maxDays; i++){
            this.schedule.put(i, new ArrayList<>());
        }        
        this.preferenceList = preferenceList;
    }
    
      
    /**
     * Return the sum of all the preference
     * @return 
     */
    public int totalPenalty(){
        return schedule.entrySet().stream()
                .map( (el) -> {
                    Integer day = el.getKey();
                    ArrayList<Integer> agendaItems = el.getValue();                    
                    //Preference pref = preferenceList.get(day);
                    
                    //filter preference by day
                    // We use Supplier<Stream> so that we can reuse the stream 
                      //again for each map iteration
                    Supplier<Stream<Preference>> prefStreamSupplier = () ->
                                    preferenceList.values().stream()
                                .filter(e -> e.getWeekDay().equals(String.valueOf(day)) );
                            
                    return agendaItems.stream()
                            .map(studentId -> 
                                prefStreamSupplier.get().filter( e ->  e.getStudentId() == studentId )
                                        .map(e -> e.getPenalty())
                                        .reduce(0, Integer::sum)                                                                        
                            ).reduce(0, Integer::sum);                            
                }).reduce(0, (a,b)->a+b);
    }     
      
    
    
    /**
     * Calculate the error score, for a given schedule.
     * If the score is higher, then it means the schedule is 
     * non-optimal.
     * @return 
     */
    public double calcScore(){
        Double score1 = 0.0;
        
        double dt1 = 1.0/ (slotPerDay*maxDays);
        
        //If students work more than 9 days than increase the score by dt1        
        //
        Stream s = schedule.values().parallelStream().
            map( agendaItems -> {            
                return agendaItems.parallelStream()
                        .map( studentId -> 
                                (employees.get(studentId).getDaysWorked() > maxWorkDays)?1.0:0.0                    
                            );                
            });
        
        //double score2 = 0.0;
        return score1;
    }
    
    private ArrayList<Integer> getSlots(int day){
        ArrayList<Integer> slots = schedule.get(day);
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
        if(slots.contains(e.getID()))
            return false;
        if(slots.size() < slotPerDay)
            slots.add(e.getID());
        else
            return false;
        schedule.put(day, slots);
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
            schedule.put(day, slots);
            return true;
        }else{
            return false;
        }
    }
    
    
    
    private boolean isAllowed(Employee emp, int day){
        return preferenceList.values()
             .stream()
             .map(e -> {return 
                     ("*".equals(e.getWeekDay())) 
                            || e.getWeekDay().equals(String.valueOf(day)) && 
                     e.getStudentId() == emp.getID() && 
                     e.isAllowed() == false;})
             .reduce(false, Boolean::logicalOr);
    }
    
    
    public int getSlotPerDay(){
        return slotPerDay;
    }
    private void setSlotPerDay( int sPerDay){
        this.slotPerDay = sPerDay;
    }
    public int getMaxDays(){
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
    public HashMap<Integer, ArrayList<Integer>> getSchedule(){
        return schedule;
    }
    private void setSchedule(HashMap<Integer, ArrayList<Integer>>scheduleItem){
        this.schedule = scheduleItem; 
    }
    
}
