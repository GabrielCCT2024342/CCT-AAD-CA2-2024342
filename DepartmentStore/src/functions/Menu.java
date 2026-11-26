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
        //checks if the file was read correctly
        if(people != null){
            //used to store user input
            String input;
            //used to transform input into enum variable
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
                //takes user input
                //don't use input utils because this one takes text and numbers
                input = myKB.nextLine();
                
                //set options to be skip as default every loop
                option = options.SKIP;
                
                //checks all options in the enum | can see the old if that didnt work
                for(int i = 0; i < options.values().length; i++){//options.values()[i].toString().contains(input.trim().toUpperCase())
                    //checks to see if the enum options are contained by the user input
                    //this is so that if the user writes add user the add option will trigger
                    //also checks to see if a number was inputed to see if it matches an option
                    if(input.trim().toUpperCase().contains(options.values()[i].toString()) || input.trim().equals(String.valueOf(i + 1))){
                        //if it does then set option to the corresponfing option
                        option = options.values()[i];
                        //stop the loop early
                        break;
                    }else if(i == options.values().length - 1){
                        //else let the user know
                        System.out.println("Please select a valid option");
                    }
                }
                
                
                switch(option){
                    case SORT:
                        //sort the array and display the first 20 names
                        sorter.arraySort(people);
                        userUtils.display20(people);
                        break;
                    case SEARCH:
                        //ask for a name
                        input = inputUtils.askUserForText("Please enter a name to search for");
                        //search for the name and save the result
                        int index = searcher.BinarySearch(people, people.length, input);
                        
                        //if nothing was found
                        if(index == -1){
                            //let the user know
                            System.out.println("Not found on the list");
                        }else{
                            //else print their name, position, and department
                            System.out.println("Name: " + people[index][0] + " " + people[index][1]);
                            System.out.println("Position: " + people[index][6]);
                            System.out.println("Department: " + people[index][5]);
                        }
                        break;
                    case ADD:
                        //add a new record to the list
                        people = userUtils.addUser(people);
                        break;
                    case TREE:
                        //open the tree menu
                        treeMenu();
                        break;
                    case EXIT:
                        //ends the program
                        System.out.println("Exiting program");
                        break;
                    //skip is only used so that nothing happens when input is not valid
                }
            //repeats until exit is selected
            }while(option != options.EXIT);
        }else{
            //lets the user know what happened before closing the program
            System.out.println("Unable to open file, please check filepath and restart the program");
        }
    }
    
    public void treeMenu(){
        //used to store user input
        String input;
        //used to transform input into enum variable
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
            //takes user input
            //don't use input utils because this one takes text and numbers
            input = myKB.nextLine();
                
            //set options to be skip as default every loop
            option = treeOptions.SKIP;
                
            //checks all options in the enum | can see the old if that didnt work
            for(int i = 0; i < treeOptions.values().length; i++){//options.values()[i].toString().contains(input.trim().toUpperCase())
                //checks to see if the enum options are contained by the user input
                //this is so that if the user writes add user the add option will trigger
                //also checks to see if a number was inputed to see if it matches an option
                if(input.trim().toUpperCase().contains(treeOptions.values()[i].toString()) || input.trim().equals(String.valueOf(i + 1))){
                    //if it does then set option to the corresponfing option
                    option = treeOptions.values()[i];
                    //stop the loop early
                    break;
                }else if(i == treeOptions.values().length - 1){
                    //else let the user know
                    System.out.println("Please select a valid option");
                }
            }

            switch(option){
                case ROOT:
                    //create a root node
                    tree.makeTree(people[0]);
                    break;
                case LEFT:
                    //checks if the tree has a root
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    //asks for pointer of father node
                    int fatherPointer = inputUtils.askUserForInt("Please enter pointer of father node");
                    //asks for name of records being addded to tree
                    String target = inputUtils.askUserForText("Please enter name being added to tree");
                    //saves index of name being added
                    int index = searcher.BinarySearch(people, people.length, target);
                    //if name not found
                    if(index == -1){
                        //let user know
                        System.out.println("Name not found on list, please try again");
                        break;
                    }
                    //used to store new node pointer
                    int pointer = 0;
                    //checks for the next empty pointer space
                    for (int i = 1; i < tree.getTree().length; i++){
                        if(tree.getTree()[i] == null){
                            pointer = i;
                            break;
                        }
                    }
                    //if pointer remains 0 means that there are no empty pointers
                    if(pointer == 0){
                        System.out.println("Tree is full");
                    }
                    //create new node
                    tree.setLeft(tree.getTree()[fatherPointer], people[index], pointer);
                    break;
                case RIGHT:
                    //checks if the tree has a root
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    //asks for pointer of father node
                    fatherPointer = inputUtils.askUserForInt("Please enter pointer of father node");
                    //asks for name of records being addded to tree
                    target = inputUtils.askUserForText("Please enter name being added to tree");
                    //saves index of name being added
                    index = searcher.BinarySearch(people, people.length, target);
                    //if name not found
                    if(index == -1){
                        //let user know
                        System.out.println("Name not found on list, please try again");
                        break;
                    }
                    //used to store new node pointer
                    pointer = 0;
                    //checks for the next empty pointer space
                    for (int i = 1; i < tree.getTree().length; i++){
                        if(tree.getTree()[i] == null){
                            pointer = i;
                            break;
                        }
                    }
                    //if pointer remains 0 means that there are no empty pointers
                    if(pointer == 0){
                        System.out.println("Tree is full");
                    }
                    //create new node
                    tree.setRight(tree.getTree()[fatherPointer], people[index], pointer);
                    break;
                case AUTOFILL:
                    //autofill tree with data from file
                    tree.autoFillTree(people);
                    //print amount of nodes in tree
                    System.out.println("The amount of nodes in the tree are " + tree.getNodeAmount());
                    //print height of tree
                    System.out.println("The height of the tree is " + tree.getHeight());
                    break;
                case PREORDER:
                    //checks if the tree has a root
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    //traverses tree root > left > right
                    tree.preorderStart();
                    break;
                case INORDER:
                    //checks if the tree has a root
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    //traverses tree left > root > right
                    tree.inorderStart();
                    break;
                case POSTORDER:
                    //checks if the tree has a root
                    if(tree.getTree()[1] == null){
                        System.out.println("Tree has no root, please create root and try again");
                        break;
                    }
                    //traverses tree left > right > root
                    tree.postorderStart();
                    break;
                case EXIT:
                    //exits tree menu
                    System.out.println("Exiting tree menu");
                    break;
            }
        }while(option != treeOptions.EXIT);
    }
        
        
    
}
