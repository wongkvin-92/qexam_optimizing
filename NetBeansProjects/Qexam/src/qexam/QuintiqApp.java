/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void assignEmployee(Employee employee, int day){
        schedule.addSchedule(employee, day);
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
}
