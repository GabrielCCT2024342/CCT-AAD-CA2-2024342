/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author ROG STRIX
 */
public class Node {
    
    private String name;
    private String position;
    private String department;
    private int pointer;
    private int left;
    private int right;
    private int father;
    private int brother;

    //full constructor
    public Node(String name, String position, String department, int pointer, int left, int right, int father, int brother) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.pointer = pointer;
        this.left = left;
        this.right = right;
        this.father = father;
        this.brother = brother;
    }
    
    //root constructor
    public Node(String name, String position, String department, int pointer) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.pointer = pointer;
    }
    
    //left constructor
    public Node(String name, String position, String department, int pointer, int father){
        this.name = name;
        this.position = position;
        this.department = department;
        this.pointer = pointer;
        this.father = father;
    }
    
    //right constructor
    public Node(String name, String position, String department, int pointer, int father, int brother){
        this.name = name;
        this.position = position;
        this.department = department;
        this.pointer = pointer;
        this.left = left;
        this.father = father;
        this.brother = brother;
    }
    
    public boolean isLeft(){
        return this.left != 0;
    }
    
    public boolean isRight(){
        return this.right != 0;
    }
    
    public String Info(){
        return this.name + ", " + this.position + ", " + this.department;
    }
    
    public int Pointer(){
        return this.pointer;
    }
    
    public int Left(){
        return this.left;
    }
    
    public void setLeft(int left){
        this.left = left;
    }
    
    public int Right(){
        return this.right;
    }
    
    public void setRight(int right){
        this.right = right;
    }
    
    public int Father(){
        return this.father;
    }
    
    public void setFather(int father){
        this.father = father;
    }
    
    public int Brother(){
        return this.brother;
    }
    
    public void setBrother(int brother){
        this.brother = brother;
    }
}
