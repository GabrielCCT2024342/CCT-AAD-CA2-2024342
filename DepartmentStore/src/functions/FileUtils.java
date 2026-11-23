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
    
    public String[][] readFile(String filepath){
        String[][] people = new String[46][];
        String line;
        String delimiter = ",";
        int counter = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while((line = br.readLine()) != null) {
                if(counter == -1){
                    counter++;
                }else if(counter < people.length){
                    String[] values = line.split(delimiter);
                    people[counter] = values;
                    counter++;
                }
                
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        
        return people;
    }
    
    public void arrayTest(String[][] arr){
        
        for(int i = 0; i < arr.length - 1; i++){
            System.out.println("\n" + (i + 1));
            for(int j = 0; j < arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
        
    }
}
