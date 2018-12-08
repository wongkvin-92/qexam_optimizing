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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean done = false;
        do
        {
            int response = doMenu();
            switch (response)
            {
                case 1: addPreference();	break;//VehicleDialog 
                case 2: insertDate(); break;//do
                case 3: autoPlanned(); break;
                case 4: done = true; break;
                default: displayErrorMsg(); break;
            }
            System.out.println(); // skip a blank line
        } while (!done);
    }
    
        /**
     * Method that display menu options.
     * @returns choice - user's selected choice
     */
    public static int doMenu()
    {
        System.out.println("The Magic of Planning and Scheduling in the Logistic World");
        System.out.println("1. Add Staff Preference");//done
        System.out.println("2. Mannually insert date");//done
        System.out.println("3. Run Automatic Planning");//done
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Your choice: ");
        return qq.nextInt();
    }
    
    public static void addPreference()
    {
        int count = 1;
        do{
            /*
             * 
            */
            System.out.println("What is the day that student " + count + " not allowed to work?");
            int dayNoWork = qq.nextInt();
            if(dayNoWork > 7){
                System.out.println("Please key in within 1 -7 (Mon-Sun)");
            }
            new Employee();
           // new Employee(dayNoWork);
             
        /*    System.out.println( count);
            count+=1; */
        }while(count !=6);
       
    }
        
    public static void insertDate()
    {
        System.out.println("Invalid Choice. Try Again!");
    }
    
        public static void autoPlanned()
    {
        System.out.println("Invalid Choice. Try Again!");
    }
        /**
     * Method that returns an error message when user has entered
     * invalid choice.
     */	
    public static void displayErrorMsg()
    {
        System.out.println("Invalid Choice. Try Again!");
    }
}
