/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstore;
import functions.FileUtils;
import functions.MergeSortString;
import functions.BinarySearchString;

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
        BinarySearchString searcher = new BinarySearchString();
        
        String[][] people = fileUtils.readFile("Applicants_Form - Sample data file for read.txt");
        String[][] peopleSorted = sorter.arraySort(people);
        fileUtils.arrayTest(peopleSorted);
        
        String target = "Alex";
        System.out.println(target + "'s gender is " + peopleSorted[searcher.BinarySearch(peopleSorted, peopleSorted.length, target)][2]);
    }
    
}
