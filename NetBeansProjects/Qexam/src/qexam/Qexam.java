/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author wKvin
 */
public class Qexam {
    static Scanner qq = new Scanner(System.in);
    private static QuintiqApp qapp = new QuintiqApp();;
    
    public static void preload(){
        qapp.createEmployee("emp A");
        qapp.createEmployee("emp B");
        qapp.createEmployee("emp C");
        qapp.createEmployee("emp D");
        qapp.createEmployee("emp E");
        
        qapp.createPreference(1, "1", false, 10);
        qapp.createPreference(1, "6", true, 5);
        qapp.createPreference(1, "*", true, 0);        
    }
    
    /**
     * Display the main menu
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        boolean  done = false;
        preload();
        do
        {
            int response = doMenu();
            switch (response)
            {
                case 1: addStaff(); break;//
                case 2: preferenceMenu(); break;
                case 3: assignEmployee(); break;               
                case 4: viewAssignments(); break;                               
                case 5: autoPlanned(); break;
                case 0: done = true; break;
                default: displayErrorMsg(); break;
            }
            System.out.println(); // skip a blank line
        } while (!done);
    }
    
    public static String staffList(){
        return qapp.getEmployees().values().stream()
                .map(e -> "\t" + e.toString() + "\n")
                .reduce("", String::concat);
    }
    
    /**
     * Display the preference menu
     */
    public static void preferenceMenu(){
        boolean done=false;
        do{
            int response = doPreferenceMenu();
            switch(response){
                case 0: done= true; break;                
                case 1: addPreference(); break;
                case 2: deletePreference(); break;
                default:
                    displayErrorMsg(); break;
            }        
            System.out.println();
        }while(!done);
    }
    
    public static int doPreferenceMenu(){
        System.out.println("======= Current Preference ===========\n"+preferenceString());
        System.out.println("========== Preference menu =========");
        System.out.println("1. Add Preference");
        System.out.println("2. Delete Preference");  
        System.out.println("0. Back");
        System.out.println();
        System.out.println("Your choice: ");
        return qq.nextInt();       
    }
    
        /**
     * Method that display menu options.
     * @returns choice - user's selected choice
     */
    public static int doMenu()
    {
        System.out.println("The Magic of Planning and Scheduling in the Logistic World");
        System.out.println("Staff List\n "+ staffList());        
        System.out.println("---------- Menu ----------");
        System.out.println("1. Add Staff");//done
        System.out.println("2. Configure Preference");
        System.out.println("3. Assign Employee to day");
        System.out.println("4. View Assignments");
        System.out.println("5. Generate Optimal Schedule");
        System.out.println("6. View a list of employees");
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice: ");
        return qq.nextInt();
    }
    
    public static void addStaff(){
        String name;
        System.out.println("Enter name");
        name = qq.next();
        
        Employee e = qapp.createEmployee(name);
        System.out.println("Employee created successfully");
        System.out.println(e);
        
        
    }
       
    public static void addPreference()
    {
        System.out.println("Enter student id: ");
        int studentID = qq.nextInt();
        System.out.println("Enter day[1-14 or *]:");
        String dayStr = qq.next();
        System.out.println("Is student allowed to work on this day? (y/n):");
        String yesOrNo = qq.next();
        System.out.println("Enter penalty: ");
        int penalty = qq.nextInt();
        
        boolean allowed = yesOrNo.toLowerCase().compareTo("yes") ==0 
                || yesOrNo.toLowerCase().compareTo("y")==0;
        
        Preference p = qapp.createPreference(studentID, dayStr, allowed, penalty);
    }
    
    public static void autoPlanned()
    {
        System.out.println("Not implemented yet");
    }
        /**
     * Method that returns an error message when user has entered
     * invalid choice.
     */	
    public static void displayErrorMsg()
    {
        System.out.println("Invalid Choice. Try Again!");
    }

    private static void assignEmployee() {

        // 1 - display a list of employee recommendation (dooe)
        String employeeList = qapp.getRecommendedEmployees()
                .stream()
                .map(e -> "\t"+e.toString()+"\n" )
                .reduce("", String::concat);
        System.out.println("List of recommended employees: \n"+ employeeList);
                
        System.out.print("Enter an Employee ID:");
        int empID = qq.nextInt();
        
        Employee emp = qapp.getEmployees().get(empID);
        
        // 2 - recommend a list of date based from the selected employee
        String dayList = qapp.getRecommendationDays(emp)
                .stream()
                .map(e -> "\t"+ e +"\n")
                .reduce("",String::concat);
        System.out.print("List of recommended days for selected employee: \n" + dayList);
        System.out.print("Enter a date [1-14]:");
        int day = qq.nextInt();
        
        qapp.assignEmployee(emp, day);
    }

    private static void viewAssignments() {
        HashMap <Integer, ArrayList<Integer> > scheduleList =  qapp.getScheduleManager()
                .getSchedule();         
        Set<Integer> keys = scheduleList.keySet();
        
        StringBuilder sb = new StringBuilder();
        
        for(Integer k: keys){
            ArrayList<Integer> dailySchedule = scheduleList.get(k);
            sb.append("\t  Day :" +k +" -> "+ dailySchedule + "\n");
        }
        System.out.println("Daily schedule===== \n "+sb.toString());
        //qapp.getSchedule();
    }

    private static void deletePreference() {
        System.out.println("Enter preference #:");
        int preferenceId = qq.nextInt();
        qapp.deletePreference(preferenceId);
    }

    private static String preferenceString() {
        Map<Integer, Preference> preferenceMap = qapp.getPreferences();
        return qapp.getPreferences()
                .keySet()
                .stream()
                .map(k ->  k +" -> "+ preferenceMap.get(k).toString() + "\n ")
                .reduce("", String::concat);        
    }

}
