/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author ROG STRIX
 */
public class MergeSortString {

    /**
     * Separates the arrays until each only has one item
     * then merges them back sorted
     * @param arr The array to be sorted
     * @param left The lower bound of the array
     * @param right The higher bound of the array
     */
    public void mergeSort(String[][] arr, int left, int right){
        //if the lower bound of the array is not the same as the higher bound
        if(left < right){
            //find a middle point to be used as index
            int mid = (left + right) / 2;
            //repeats the function with the left half of the array
            mergeSort(arr, left, mid);
            //repeats the functino with the right half of the array
            mergeSort(arr, mid + 1, right);
            //merges the arrays sorted
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Takes an array that has been virtually separated using indexes
     * and rearranges the parts using copies of the separated array
     * @param arr The array being sorted
     * @param left The lower bound of the first virtually separated array
     * @param mid The separation point of the virtually separated arrays
     * @param right The lower bound of the second virtually separated array
     */
    public void merge(String[][] arr, int left, int mid, int right){
        //used to know the amount of items on both of the virtual arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        //creates arrays to store the virtual arrays
        String[][] L = new String[n1][];
        String[][] R = new String[n2][];
        
        //copies everything from the virtual arrays to the real copies
        for(int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        
        //initializes indexes to track progress through both the copies
        //and the original array
        int i = 0, j = 0, k = left;
        
        //while neither of the copies has reached the higher bounds of the array
        while(i < n1 && j < n2){
            //if the name on the left array comes before the name on the right
            if(L[i][0].compareToIgnoreCase(R[j][0]) < 0){
                //copy the name on the left array to the original array
                arr[k] = L[i];
                //advance on the left array
                i++;
            }else{
                //copy the name on the right array to the original array
                arr[k] = R[j];
                //advance on the left array
                j++;
            }
            //advance on the real array each time
            k++;
        }
        
        //after every comparison is done
        //if one of the copied arrays didn't reach its higher bound
        //copy the rest of its content to the original array
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    /**
     * Used to return only once after the recurring sorting is done
     * @param arr Array to be sorted
     * @return sorted array
     */
    public String[][] arraySort(String[][] arr){
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
