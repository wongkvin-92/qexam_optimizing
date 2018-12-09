/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;


/**
 *
 * @author wKvin
 */
public class QuintiqApp {
    private HashMap<Integer, Employee> employees;
    private HashMap<Integer, Preference> preferences;
    private ScheduleContainer schedule;
    
    public QuintiqApp(){
        setEmployees(new HashMap<>());
        setPreferences(new HashMap<>());
        schedule = new ScheduleContainer(preferences, employees);                
    }
    
    public HashMap<Integer, Employee> getEmployees(){
        return employees;
    }
    
    public void  setEmployees(HashMap<Integer, Employee> employees){
        this.employees = employees;
    }
    
    public ArrayList<Employee>getRecommendedEmployees(){
        ArrayList<Employee> l= (ArrayList<Employee>) employees.values()
                .stream()
                .filter(e -> e.getDaysWorked() < 9)
                .collect(Collectors.toList());
        
        l.sort((lhs, rhs) -> 
                Integer.compare(lhs.getDaysWorked(), rhs.getDaysWorked()) );
        
        return l;
        
    }
        
    
    public HashMap<Integer,Preference> getPreferences(){
        return preferences;
    }
    
    public void setPreferences(HashMap<Integer,Preference> preferences){
        this.preferences = preferences;
    }
    
    public Employee assignEmployee(Employee employee, int day){        
        if (schedule.addSchedule(employee, day) ){  
            employee.setDaysWorked(employee.getDaysWorked()+1);
            return employee;
        }else{
            return null;
        }
    }
    
    public void removeEmployee(Employee e, int day){
        schedule.removeSchedule(e, day);
    }
    
    public Employee createEmployee(String name){
        Employee emp = new Employee(name);        
        employees.put(emp.getID(), emp);
        return emp;
    }
    
    /**
     * Deletes the employee
     * @param id employee id
     * @return false if failed otherwise true
     */
    public boolean deleteEmployee(int id){
        try{
            employees.remove(id);
            return true;
        }catch(IndexOutOfBoundsException ex){
            return false;
        }
    }
    
    public boolean deleteEmployee(Employee e){
       return deleteEmployee(e.getID());
    }
    
    public Preference createPreference(int id, String weekDay, boolean allowed, int penalty){
        Preference pre = new Preference(id, weekDay, allowed, penalty);
        preferences.put(pre.getPreferenceId(), pre);
        return pre;
    }
    public void deletePreference(int id){
        preferences.remove(id);
    }
    
    /**
    private ArrayList<Preference> getPreferenceForDay(Employee emp, int d){
        return (ArrayList<Preference>) preferences.values()
                .stream()
                .filter(e -> e.getWeekDay().equals(String.valueOf(d)) )
                .collect(Collectors.toList());        
    }**/
    private ArrayList<Integer> daysEmployeeCannotWork(Employee emp){
        return (ArrayList<Integer> ) preferences.values()
                .stream()
                .filter(p -> 
                                (!p.getWeekDay().equals("*") ||
                                p.isAllowed() == false) &&
                                p.getStudentId() == emp.getID()                                         
                )
                                
                .map(e -> Integer.valueOf(e.getWeekDay()) )
                .collect(Collectors.toList())
                ;              
    }
    
    public ArrayList<Integer> getRecommendationDays(Employee e){        
        ArrayList<Integer> list =  new ArrayList<>();
        ArrayList<Integer> daysStudentCannotWork = daysEmployeeCannotWork(e);
        
                    
        //HashMap <Integer, ArrayList<Integer> > scheduleList = schedule
       //                                                 .getSchedule(); 
        
        //Set<Integer> keys = scheduleList.keySet();        
        for(int i=1; i <= 14; i++){
            if(daysStudentCannotWork.contains(i))
                continue;           
            
            //check whether employee already has a task for that day
            ArrayList<Integer> al = schedule.getSchedule()
                    .get(i);
            
            if(al.contains(e.getID()))
                continue;
            
            //if there is no slot then skip the day
            if(al.size()>= schedule.getSlotPerDay())
                continue;
                            
            list.add(i);            
        }
        
        return list;
    }
    
    public ScheduleContainer getScheduleManager(){
        return schedule;
    }        

    public double getScheduleScore() {
        return schedule.calcScore();
    }

    public int getPenalty() {
        return schedule.totalPenalty();
    }
    
}
