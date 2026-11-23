/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstore;
import functions.FileUtils;
import functions.MergeSortString;

/**
 *
 * @author ROG STRIX
 */
public class DepartmentStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        MergeSortString sorter = new MergeSortString();
        
        String[][] people = fileUtils.readFile("Applicants_Form - Sample data file for read.txt");
        String[][] peopleSorted = sorter.arraySort(people);
        fileUtils.arrayTest(peopleSorted);
    }
    
}
