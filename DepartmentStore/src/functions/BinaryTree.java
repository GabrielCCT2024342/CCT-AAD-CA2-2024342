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
        //initializes the queue
        Queue queue = new Queue();
        //creates the root
        makeTree(arr[0]);
        //used to locate the father
        int father = 1;
        //as long as the array given
        for(int i = 1; i < arr.length; i++){
            //used to make pointers
            int j = i + 1;
            //if father has no left son
            if(!tree[father].isLeft()){
                //creates left son
                setLeft(tree[father],arr[i],j);
                //adds left sons pointer to the queue
                queue.enqueue(j);
            //if father has left son but no right son
            }else if(!tree[father].isRight()){
                //creates right son
                setRight(tree[father], arr[i], j);
                //adds right sons pointer to the queue
                queue.enqueue(j);
            //if father has both sons 
            }else{
                //update father with the next pointer
                father = queue.dequeue();
                //lower i since nothing was added this loop
                i--;
            }
        }
    }
    
    public void preorder(Node node){
        System.out.println(node.Info());
        if(node.isLeft()){
            preorder(tree[node.Left()]);
            if(node.isRight()){
                preorder(tree[node.Right()]);
            }
        }
    }
    
    public void preorderStart(){
        preorder(tree[1]);
    }
    
    public void inorder(Node node){
        if(node.isLeft()){
            inorder(tree[node.Left()]);
        }else{
            System.out.println(node.Info());
            if(node.isRight()){
                inorder(tree[node.Right()]);
            }
        }
    }
    
    public void inorderStart(){
        inorder(tree[1]);
    }
}
