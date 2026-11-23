/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ROG STRIX
 */
public class FileUtils {
    
    /**
     * Reads and parses a file to a multidimensional array
     * @param filepath path to the file being read
     * @return a multidimensional array if successful
     */
    public String[][] readFile(String filepath){
        //creates the multidimensional array
        String[][] people = new String[46][];
        String line;
        String delimiter = ",";
        //counter starts at -1 to skip the first line of the file without names
        int counter = -1;

        //tries to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            //while there are lines to be read on the file
            while((line = br.readLine()) != null) {
                //skips the first line
                if(counter == -1){
                    counter++;
                //while there is space on the multidimensional array
                }else if(counter < people.length){
                    //separates the line into an array based on comas
                    String[] values = line.split(delimiter);
                    
                    values = arrayCleaner(values);
                    //adds the array to the multidimensional array
                    people[counter] = values;
                    counter++;
                }
                
            }
        //if the file fails to be read
        } catch (IOException e) {
            //let the user know
            System.err.println(e.getMessage());
            //and return null
            return null;
        }
        
        //return the multidimensional array
        return people;
    }
    
    /**
     * Used to test the multidimensional array is working
     * @param arr array being tested
     */
    public void arrayTest(String[][] arr){
        //for every array on the array
        for(int i = 0; i < arr.length - 1; i++){
            //count the array we're on
            System.out.println("\n" + (i + 1));
            //for everything on the inner array
            for(int j = 0; j < arr[i].length; j++){
                //print everythin on the array
                System.out.println(arr[i][j]);
            }
        }
        
    }
    
    public String[] arrayCleaner(String[] arr){
        boolean empty = false;
        String[] clean = new String[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            clean[i] = arr[i].trim();
        }
        
        String[] full = new String[arr.length - 1];
        while(true){
            int emptyIndex = -1;
            boolean empty2 = false;
            for (int i = 0; i < arr.length; i++){
                if(arr[i].equals("")){
                    emptyIndex = i;
                    empty = true;
                    empty2 = true;
                    break;
                }
            }
            if(empty2){
                for(int i = 0; i < full.length; i++){
                    int j = i;
                    if(j == emptyIndex){
                        j++;
                    }
                    full[i] = arr[j].trim();
                }
                break;
            }else{
                break;
            }
        }
        
        if(empty){
            return full;
        }else{
            return clean;
        }
    }
}
