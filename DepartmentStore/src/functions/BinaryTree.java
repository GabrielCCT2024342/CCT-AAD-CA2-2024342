/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author ROG STRIX
 */
public class BinaryTree {
    
    Node[] tree = new Node[50];
    
    /**
     * Creates a root node
     * It always uses the pointer 1 for the root
     * @param arr Array where node info is taken from
     */
    public void makeTree(String[] arr){
        //checks if the root exists already
        if(tree[1] == null){
            //if not it creates it and adds it to the tree
            Node root = new Node(arr[0], arr[6], arr[5], 1);
            tree[1] = root;
        }else{
            //else lets the user know
            System.out.println("Root is already created");
        }        
    }
    
    /**
     * Creates a left son to a node
     * @param father Father of the node being created
     * @param arr Array where node info is taken from
     * @param pointer Used to locate the node on the tree
     */
    public void setLeft(Node father, String[] arr, int pointer){
        //if the father node doesnt have a let son already
        //and the pointer is not being used already
        if(!father.isLeft() && tree[pointer] == null){
            //creates a new node
            Node left = new Node(arr[0], arr[6], arr[5], pointer, father.Pointer());
            //updates the father node information
            father.setLeft(pointer);
            //adds new node to the tree
            tree[pointer] = left;
        }else{
            //if left son exists then lets user know
            if(father.isLeft()){
                System.out.println("Left son already exists");
            }
            //if pointer is being used already then lets user know
            if(tree[pointer] != null){
                System.out.println("pointer already in use");
            }
        }
    }
    
    
    /**
     * Creates a right son to a node
     * Requires a left brother to exist already
     * @param father Father of the node being created
     * @param arr Array where node info is taken from
     * @param pointer Used to locate the node on the tree
     */
    public void setRight(Node father, String[] arr, int pointer){
        //if there is left brother, and father doesnt have right son,
        //and pointer is not being used
        if(father.isLeft() && !father.isRight() && tree[pointer] == null){
            //creates a new node
            Node right = new Node(arr[0], arr[6], arr[5], pointer, father.Pointer(), father.Left());
            //upadtes father information
            father.setRight(pointer);
            //updates brother information
            tree[father.Left()].setBrother(pointer);
            //adds new node to tree
            tree[pointer] = right;
        }else{
            //if right son exists then lets user know
            if(father.isRight()){
                System.out.println("Left son already exists");
            }
            //if pointer is being used already then lets user know
            if(tree[pointer] != null){
                System.out.println("pointer already in use");
            }
            //if left son doesnt exist lets user know
            if(!father.isLeft()){
                System.out.println("Left son doesn't exist");
            }
        }
    }
    
    /**
     * Takes a multidimensional array and populates the tree
     * following the array given
     * @param arr Multidimensional array with other arrays to be used
     */
    public void autoFillTree(String[][] arr){
        //creates the root
        makeTree(arr[0]);
        //used to locate the father
        int father;
        //as long as the array given
        for(int i = 2; i < arr.length; i++){
            //if array is bigger than tree capacity
            if(i >= tree.length){
                //let user know tree is full and stop loop
                System.out.println("Tree is full");
                break;
            }else{
                //because of how the loop works all even pointers 
                //will be left sons and all odds be right pointers
                
                //checks if even
                if((i%2) == 0){
                    //due to loop left sons father pointer is always one behind
                    father = i - 1;
                    //adds new left son to father
                    setLeft(tree[father], arr[i], i);
                }else{
                    //due to loop right sons father pointer is always two behind
                    father = i - 2;
                    //adds new right son to father
                    setRight(tree[father], arr[i], i);
                }
            }
        }
    }
}
