/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentstore;
import functions.FileUtils;
import functions.MergeSortString;
import functions.BinarySearchString;
import functions.UserUtils;
import functions.BinaryTree;

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
        UserUtils userUtils = new UserUtils();
        BinaryTree tree = new BinaryTree();
        
        String[][] people = fileUtils.readFile("Applicants_Form - Sample data file for read.txt");
        if (people != null){
            sorter.arraySort(people);
            fileUtils.arrayTest(people);

            String target = "Sophia";
            try{
                System.out.println(target + "'s gender is " + people[searcher.BinarySearch(people, people.length, target)][2]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Target not found");
            }
            
            userUtils.display20(people);
            userUtils.displayAll(people);
            people = userUtils.addUser(people);
            userUtils.displayAll(people);
            
            tree.makeTree(people[0]);
            
            tree.autoFillTree(people);
        }
    }
    
}
