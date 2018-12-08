/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qexam;

import java.util.Scanner;

/**
 *
 * @author wKvin
 */
public class Qexam {
    static Scanner qq = new Scanner(System.in);
    
    /**
     * Display the main menu
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        boolean done = false;
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
    
    /**
     * Display the preference menu
     */
    public static void preferenceMenu(){
        boolean done=false;;
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
        Employee employee = new Employee(name);
        System.out.println("Employee created successfully");
        System.out.println(employee);
    }
       
    public static void addPreference()
    {
        System.out.println("Enter student id: ");
        String studentID = qq.next();
        System.out.println("Enter day[1-14 or *]:");
        String dayStr = qq.next();
        System.out.println("Is student allowed to work on this day? (y/n):");
        String yesOrNo = qq.next();
        System.out.println("Enter penalty: ");
        double penalty = qq.nextDouble();
        
        
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
        System.out.println("Not Implemented yet");
    }

    private static void viewAssignments() {
        System.out.println("Not implemented yet");
    }

    private static void deletePreference() {
        System.out.println("Not implemented yet");
    }

}
