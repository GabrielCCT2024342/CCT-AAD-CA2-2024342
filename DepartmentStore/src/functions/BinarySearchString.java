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
    
    /**
     * Takes a target string and looks for a match on the given array
     * @param arr array being looked through
     * @param size size of the array being searched
     * @param target string being looked for
     * @return the index where it matches with the target or -1 if not found
     */
    public int BinarySearch(String[][] arr, int size, String target){
        //lower bound of the array
        int low = 0;
        //higher bound of the array
        int high = size -1;
        int mid;
        
        //while the lower bound isn't bigger than the higher bound
        while(low <= high){
            //middle point of the array
            mid = (low + high) / 2;
            
            //if target is equal to what is on the middle point
            if(target.equals(arr[mid][0])){
                //return the index of the middle point
                return mid;
            //if target if after the middle point
            }else if(target.compareTo(arr[mid][0]) > 0){
                //new low is index right after the middle point
                low = mid + 1;
            }else {
                //else new high is index right before the middle point
                high = mid - 1;
            }
        }
        
        //return -1 if nothing is found to match
        return -1;
    }
}
