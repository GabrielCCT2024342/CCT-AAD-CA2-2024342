/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;
import java.util.Scanner;

/**
 *
 * @author ROG STRIX
 */
public class Menu {
    private FileUtils fileUtils;
    private MergeSortString sorter;
    private BinarySearchString searcher;
    private UserUtils userUtils;
    private BinaryTree tree;
    private Scanner myKB;
    private String[][] people;
    
    enum options{
        SORT,
        SEARCH,
        ADD,
        TREE,
        EXIT
    }
    
    enum treeOptions{
        CREATE,
        LEFT,
        RIGHT,
        AUTOFILL,
        PREORDER,
        INORDER,
        POSTORDER
    }

    public Menu() {
        this.fileUtils = new FileUtils();
        this.sorter = new MergeSortString();
        this.searcher = new BinarySearchString();
        this.userUtils = new UserUtils();
        this.tree = new BinaryTree();
        this.myKB = new Scanner(System.in);
        this.people = fileUtils.readFile("Applicants_Form - Sample data file for read.txt");
    }

    public Menu(String filepath) {
        this.fileUtils = new FileUtils();
        this.sorter = new MergeSortString();
        this.searcher = new BinarySearchString();
        this.userUtils = new UserUtils();
        this.tree = new BinaryTree();
        this.myKB = new Scanner(System.in);
        this.people = fileUtils.readFile(filepath);
    }
    
    public void menu(){
        
        if(people != null){
            String input;
            do{
                System.out.println("Welcome to the app menu");
                System.out.println("The file has been parsed already");
                System.out.println("Your options are:");
                System.out.println("1. Sort");
                System.out.println("    Organizes the file alphabetically");
                System.out.println("2. Search");
                System.out.println("    Searches for a specific name");
                System.out.println("3. Add record");
                System.out.println("    Adds a new record to the file");
                System.out.println("4. Binary Tree");
                System.out.println("    Opens a new menu with options related to a binary tree");
                System.out.println("5. Exit");
                System.out.println("    Ends the program");
                
                input = myKB.nextLine();
                
                options option = options.valueOf(input);
                
                switch(option){
                    
                }
            }while(true);
        }else{
            System.out.println("Unable to open file, please check filepath and restart the program");
        }
    }
        
        
    
}
