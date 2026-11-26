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
    private InputUtils inputUtils;
    
    enum options{
        SORT,
        SEARCH,
        ADD,
        TREE,
        EXIT,
        SKIP
    }
    
    enum treeOptions{
        ROOT,
        LEFT,
        RIGHT,
        AUTOFILL,
        PREORDER,
        INORDER,
        POSTORDER,
        EXIT,
        SKIP
    }

    public Menu() {
        this.fileUtils = new FileUtils();
        this.sorter = new MergeSortString();
        this.searcher = new BinarySearchString();
        this.userUtils = new UserUtils();
        this.tree = new BinaryTree();
        this.myKB = new Scanner(System.in);
        this.inputUtils = new InputUtils();
        this.people = fileUtils.readFile("Applicants_Form - Sample data file for read.txt");
    }

    public Menu(String filepath) {
        this.fileUtils = new FileUtils();
        this.sorter = new MergeSortString();
        this.searcher = new BinarySearchString();
        this.userUtils = new UserUtils();
        this.tree = new BinaryTree();
        this.myKB = new Scanner(System.in);
        this.inputUtils = new InputUtils();
        this.people = fileUtils.readFile(filepath);
    }
    
    public void menu(){
        
        if(people != null){
            String input;
            options option;
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
                
                System.out.println("\nPlease choose an option");
                input = myKB.nextLine();
                
                option = options.SKIP;
                
                for(int i = 0; i < options.values().length; i++){//options.values()[i].toString().contains(input.trim().toUpperCase())
                    if(input.trim().toUpperCase().contains(options.values()[i].toString()) || input.trim().equals(String.valueOf(i + 1))){
                        option = options.values()[i];
                        break;
                    }else if(i == options.values().length - 1){
                        System.out.println("Please select a valid option");
                    }
                }
                
                switch(option){
                    case SORT:
                        sorter.arraySort(people);
                        userUtils.display20(people);
                        break;
                    case SEARCH:
                        input = inputUtils.askUserForText("Please enter a name to search for");
                        int index = searcher.BinarySearch(people, people.length, input);
                        
                        if(index == -1){
                            System.out.println("Not found on the list");
                        }else{
                            System.out.println("Name: " + people[index][0] + " " + people[index][1]);
                            System.out.println("Position: " + people[index][6]);
                            System.out.println("Department: " + people[index][5]);
                        }
                        break;
                    case ADD:
                        people = userUtils.addUser(people);
                        break;
                    case TREE:
                        treeMenu();
                        break;
                    case EXIT:
                        System.out.println("Exiting program");
                        break;
                        
                }
            }while(option != options.EXIT);
        }else{
            System.out.println("Unable to open file, please check filepath and restart the program");
        }
    }
    
    public void treeMenu(){
        String input;
        treeOptions option;
        do{
            System.out.println("Welcome to the tree menu");
            System.out.println("Your options are:");
            System.out.println("1. Root");
            System.out.println("    Creates a root node");
            System.out.println("2. Left");
            System.out.println("    Creates a left son for a specified node");
            System.out.println("3. Right");
            System.out.println("    Creates a right son for a specified node");
            System.out.println("4. Autofill");
            System.out.println("    Creates a root node and populates the tree using the file given");
            System.out.println("5. Preorder");
            System.out.println("    Traverses the tree root > left > right");
            System.out.println("6. Inorder");
            System.out.println("    Traverses the tree left > root > right");
            System.out.println("7. Postorder");
            System.out.println("    Traverses the tree left > right > root");
            System.out.println("8. Exit");
            System.out.println("    Exits the binary tree menu");

            System.out.println("\nPlease choose an option");
            input = myKB.nextLine();

            option = treeOptions.SKIP;

            for(int i = 0; i < treeOptions.values().length; i++){//options.values()[i].toString().contains(input.trim().toUpperCase())
                if(input.trim().toUpperCase().contains(treeOptions.values()[i].toString()) || input.trim().equals(String.valueOf(i + 1))){
                    option = treeOptions.values()[i];
                    break;
                }else if(i == treeOptions.values().length - 1){
                    System.out.println("Please select a valid option");
                }
            }

            switch(option){
                case ROOT:
                    tree.makeTree(people[0]);
                    break;
                case LEFT:
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    int fatherPointer = inputUtils.askUserForInt("Please enter pointer of father node");
                    String target = inputUtils.askUserForText("Please enter name being added to tree");
                    int index = searcher.BinarySearch(people, people.length, target);
                    if(index == -1){
                        System.out.println("Name not found on list, please try again");
                        break;
                    }
                    int pointer = 0;
                    for (int i = 1; i < tree.getTree().length; i++){
                        if(tree.getTree()[i] == null){
                            pointer = i;
                            break;
                        }
                    }
                    if(pointer == 0){
                        System.out.println("Tree is full");
                    }
                    tree.setLeft(tree.getTree()[fatherPointer], people[index], pointer);
                    break;
                case RIGHT:
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    fatherPointer = inputUtils.askUserForInt("Please enter pointer of father node");
                    target = inputUtils.askUserForText("Please enter name being added to tree");
                    index = searcher.BinarySearch(people, people.length, target);
                    if(index == -1){
                        System.out.println("Name not found on list, please try again");
                        break;
                    }
                    pointer = 0;
                    for (int i = 1; i < tree.getTree().length; i++){
                        if(tree.getTree()[i] == null){
                            pointer = i;
                            break;
                        }
                    }
                    if(pointer == 0){
                        System.out.println("Tree is full");
                    }
                    tree.setRight(tree.getTree()[fatherPointer], people[index], pointer);
                    break;
                case AUTOFILL:
                    tree.autoFillTree(people);
                    break;
                case PREORDER:
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    tree.preorderStart();
                    break;
                case INORDER:
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    tree.inorderStart();
                    break;
                case POSTORDER:
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    tree.postorderStart();
                    break;
                case EXIT:
                    System.out.println("Exiting tree menu");
                    break;
            }
        }while(option != treeOptions.EXIT);
    }
        
        
    
}
