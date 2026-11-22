/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorter;

/**
 *
 * @author ROG STRIX
 */
public class MergeSortString {

    public void mergeSort(String[][] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public void merge(String[][] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        String[][] L = new String[n1][];
        String[][] R = new String[n2][];
        
        for(int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        
        while(i < n1 && j < n2){
            if(L[i][0].compareToIgnoreCase(R[j][0]) < 0){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
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
    
    public String[][] arraySort(String[][] arr){
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
