/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author sanch
 */
public class Queue {
    
    //Creates an Array with 8 positions (0 - 7)
    private int[] item;
    //front variable stores the next item to be removed from the queue
    private int front;
    //rear variables stores the most recent item added to the queue
    // "-1" is used because after adding an item will end un in the index 0 when incremented
    private int rear;
    //initial size of the array
    private int size;
    
    //Creates queue with 50 positions
    public Queue() {
        this.item = new int[50];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    

    //Adds an item at the back of the Queue
    public void enqueue(int i){
    
        //if statement that checks if the queue is full
        if (size == 50){
            System.out.println("The Queue is full");
            return;
        }
        // It calculates the index where the next item will be stored    
        //Since the initial value is "-1" it will allocate the first item in the index "0"
        // ref: https://www.geeksforgeeks.org/java/java-program-to-implement-the-queue-data-structure/
        rear = (rear + 1) % 50;
        //adds the item in the array in the index calculated in the last line
        item[rear] = i;
        size++;
    }
    
    //Removes the first item in de Queue
    public int dequeue(){
        //Checks if the array is empty
        if (size == 0){
            System.out.println("The Queue is empty");
            return 0;
        }else{
            int removedItem = item[front];
            //removes the reference to the item from the array
            item[front] = 0;
            //moves the index to the next position
            front = (front + 1) % 50;
            size--;
            return removedItem;
        }
    }
}


