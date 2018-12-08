/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;
import java.util.ArrayList;
/**
 *
 * @author wKvin
 */
public class QuintiqApp {
    private ArrayList<Employee> employees;
    private ArrayList<Preference> preferences;
    
    public QuintiqApp(){
        setEmployees(new ArrayList<Employee>());
        setPreferences(new ArrayList<Preference>());
}
    
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
    
    public void  setEmployees(ArrayList<Employee> employees){
        this.employees = employees;
    }
    
    public ArrayList<Preference> getPreferences(){
        return preferences;
    }
    
    public void setPreferences(ArrayList<Preference> preferences){
        this.preferences = preferences;
    }
    
    public Employee createEmployee(String name){
        Employee emp = new Employee(name);
        employees.add(emp.getID(), emp);
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
        preferences.add(pre.getPreferenceId(), pre);
        return pre;
    }
    public void deletePreference(int id){
        preferences.remove(id);
    }
}
