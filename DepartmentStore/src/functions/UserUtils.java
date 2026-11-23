/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author ROG STRIX
 */
public class UserUtils {

    private String[] departments;
    private String[] positions;
    private InputUtils inputUtils;

    public UserUtils() {
        //acceptable departments
        this.departments = new String[]{
            "Accounting",
            "Customer Service",
            "Finance",
            "HR",
            "IT Development",
            "Marketing",
            "Operations",
            "Sales",
            "Technical Support"
        };
        //acceptable positions
        this.positions = new String[]{
            "Assistant Manager",
            "contract",
            "Head Manager",
            "intern",
            "junior",
            "Manager",
            "middle",
            "senior",
            "Senior Manager",
            "Team Lead"
        };
        inputUtils = new InputUtils();
    }
    
    
    /**
     * Displays all names in an array
     * @param arr Array where names are stored
     */
    public void displayAll(String[][] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0]);
        }
    }
    
    /**
     * Displays the first 20 name in an array
     * @param arr Array where names are stored
     */
    public void display20(String[][] arr){
        for(int i = 0; i < 20; i++){
            System.out.println(arr[i][0]);
        }
    }
    
    /**
     * Adds a new user to an array
     * @param arr array where users are stored
     * @return array with new user inserted
     */
    public String[][] addUser(String[][] arr){
        //takes the lenght of the original array
        int high = arr.length;
        //and creates a new one that is one bigger
        String[][] people = new String[high + 1][];
        
        //copies all entries from the original array to the new one
        for(int i = 0; i < high; i++){
            people[i] = arr[i];
        }
        
        //initializes the last space as an array with the required spaces
        people[high] = new String[9];
        
        //asks the user for specific information
        people[high][0] = inputUtils.askUserForText("Please enter the first name");
        people[high][1] = inputUtils.askUserForText("Please enter the last name");
        people[high][2] = inputUtils.askUserForText("Please enter the gender");
        people[high][3] = inputUtils.askUserForText("Please enter the email");
        people[high][4] = inputUtils.askUserForText("Please enter the salary");
        
        //used to check for validity of answers
        String input;
        boolean checker = false;
        
        //repeats forever
        while(true){
            //asks for a department
            input = inputUtils.askUserForText("Please enter the department");
            //checks if the answer given matches one of the approved ones
            for(int i = 0; i < this.departments.length; i++){
                if(this.departments[i].equalsIgnoreCase(input)){
                    //if it does match it sets a flag
                    checker = true;
                    break;
                }
            }
            if(checker){
                //if the flag was triggered then it saves the answer
                people[high][5] = input;
                //and breaks off the infinite loop
                break;
            }else{
                //lets the user know the issue and repeats
                System.out.println("Invalid department");
            }
        }
        
        //repeats forever
        while(true){
            //asks for a position
            input = inputUtils.askUserForText("Please enter the position");
            //checks if the answer given matches one of the approved ones
            for(int i = 0; i < this.positions.length; i++){
                if(this.positions[i].equalsIgnoreCase(input)){
                    //if it does match it sets a flag
                    checker = true;
                    break;
                }
            }
            if(checker){
                //if the flag was triggered then it saves the answer
                people[high][6] = input;
                break;
            }else{
                //lets the user know the issue and repeats
                System.out.println("Invalid position");
            }
        }
        
        //asks for the remaining info
        people[high][7] = inputUtils.askUserForText("Please enter the job title");
        people[high][8] = inputUtils.askUserForText("Please enter the company");
        
        //returns the new array
        return people;
    }
}
