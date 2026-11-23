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
    
    

    public void displayAll(String[][] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0]);
        }
    }
    
    public void display20(String[][] arr){
        for(int i = 0; i < 20; i++){
            System.out.println(arr[i][0]);
        }
    }
    
    public String[][] addUser(String[][] arr){
        int high = arr.length;
        String[][] people = new String[high + 1][];
        
        for(int i = 0; i < high; i++){
            people[i] = arr[i];
        }
        
        people[high] = new String[9];
        
        people[high][0] = inputUtils.askUserForText("Please enter the first name");
        people[high][1] = inputUtils.askUserForText("Please enter the last name");
        people[high][2] = inputUtils.askUserForText("Please enter the gender");
        people[high][3] = inputUtils.askUserForText("Please enter the email");
        people[high][4] = inputUtils.askUserForText("Please enter the salary");
        
        String input;
        boolean checker = false;
        
        while(true){
            input = inputUtils.askUserForText("Please enter the department");
            for(int i = 0; i < this.departments.length; i++){
                if(this.departments[i].equalsIgnoreCase(input)){
                    checker = true;
                    break;
                }
            }
            if(checker){
                people[high][5] = input;
                break;
            }else{
                System.out.println("Invalid department");
            }
        }
        
        while(true){
            input = inputUtils.askUserForText("Please enter the position");
            for(int i = 0; i < this.positions.length; i++){
                if(this.positions[i].equalsIgnoreCase(input)){
                    checker = true;
                    break;
                }
            }
            if(checker){
                people[high][6] = input;
                break;
            }else{
                System.out.println("Invalid position");
            }
        }
        
        people[high][7] = inputUtils.askUserForText("Please enter the job title");
        people[high][8] = inputUtils.askUserForText("Please enter the company");
        
        return people;
    }
}
