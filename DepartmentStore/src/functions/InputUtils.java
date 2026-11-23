/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package functions;

import java.util.Scanner;

/**
 *
 * @author kheal
 */
public class InputUtils {
    
    //Properties
    private Scanner myKB;
    
    //Constructor

    public InputUtils() {
        
        myKB = new Scanner(System.in);
    }
    
        
    //Methods
    
    /**
     * Ask user to enter text
     * if not text, repeat prompt
     * @param prompt The question or prompt to the user
     * @return some valid text from user as a String
     */
    public String askUserForText (String prompt){
                
        String userInput;
        
        do {
            System.out.println(prompt);
            System.out.println("You must enter text only!");
            
            userInput = myKB.nextLine();
        } while (!userInput.matches("[a-zA-Z!.?', ]+"));
        
        
        //the input must be text
        return(userInput);
    }
    
    /**
     * Ask user for an int
     * if not valid, repeat prompt
     * @param prompt The question or prompt to the user
     * @return an int value entered by the user
     */
    public int askUserForInt (String prompt){
        
        String userInput;
        
        do {
            System.out.println(prompt);
            System.out.println("You must enter numbers only!");
            
            userInput = myKB.nextLine();
            
        }while (!userInput.matches("[0-9]+"));
        //must have a numeric input stored as a string
        
        int ans = Integer.parseInt(userInput);
        
        return(ans);
    }
    
}
