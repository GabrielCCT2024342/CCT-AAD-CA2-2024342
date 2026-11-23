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
    
    public void makeTree(String[] arr){
        
        if(tree[1] == null){
            Node root = new Node(arr[0], arr[6], arr[5], 1);
            tree[1] = root;
        }else{
            System.out.println("Root is already created");
        }
        
    }
    
    public void setLeft(Node father, String[] arr, int pointer){
        if(!father.isLeft() && tree[pointer] == null){
            Node left = new Node(arr[0], arr[6], arr[5], pointer, father.Pointer());
            father.setLeft(pointer);
            tree[pointer] = left;
        }else{
            if(father.isLeft()){
                System.out.println("Left son already exists");
            }
            if(tree[pointer] != null){
                System.out.println("pointer already in use");
            }
        }
    }
    
    public void setRight(Node father, String[] arr, int pointer){
        if(father.isLeft() && !father.isRight() && tree[pointer] == null){
            Node right = new Node(arr[0], arr[6], arr[5], pointer, father.Pointer(), father.Left());
            father.setRight(pointer);
            tree[father.Left()].setBrother(pointer);
            tree[pointer] = right;
        }
    }
    
    public void autoFillTree(String[][] arr){
        makeTree(arr[0]);
        int father;
        for(int i = 2; i < arr.length; i++){
            if(i >= tree.length){
                System.out.println("Tree is full");
                break;
            }else{
                if((i%2) == 0){
                    father = i - 1;
                    setLeft(tree[father], arr[i], i);
                }else{
                    father = i - 2;
                    setRight(tree[father], arr[i], i);
                }
            }
        }
    }
}
