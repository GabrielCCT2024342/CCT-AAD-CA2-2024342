/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author ROG STRIX
 */
public class BinarySearchString {
    
        public int BinarySearch(String[][] arr, int size, String target){
        int low = 0;
        int high = size -1;
        int mid;
        
        while(low <= high){
            mid = (low + high) / 2;
            
            if(target.equals(arr[mid][0])){
                return mid;
            }else if(target.compareTo(arr[mid][0]) > 0){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
