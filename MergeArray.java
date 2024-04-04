/* 
Problem Ststement=> 

Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0 
Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }


*/

// ------------------------------------------------------------------------------------------------------------------------------------


/*
Approach 1:

import java.util.Arrays;
public class MergeArray{

    public static void getMergedArray(int x[], int y[]){
        for(int i=0;i<y.length;i++){
            for(int j=0;j<x.length;j++){
                if(x[j]==0){
                    x[j]=y[i];
                    break;
                }
            }
        }
        Arrays.sort(x);
    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        int X[]={0,2,0,3,0,5,6,0,0};
        int Y[]={1,8,9,10,15};
        getMergedArray(X,Y);
        printArray(X);
        
    }
}

*/



// Apprach 2: 

import java.util.Arrays;

public class MergeArray {
    private static void mergeArrays(int[] destArray, int[] sourceArray, int destSize, int sourceSize) {
        int destIndex = destSize + sourceSize + 1;

        while (destSize >= 0 && sourceSize >= 0) {
            if (destArray[destSize] > sourceArray[sourceSize]) {
                destArray[destIndex--] = destArray[destSize--];
            } else {
                destArray[destIndex--] = sourceArray[sourceSize--];
            }
        }

        while (sourceSize >= 0) {
            destArray[destIndex--] = sourceArray[sourceSize--];
        }

        Arrays.fill(sourceArray, 0);
    }

    public static void rearrangeAndMerge(int[] mainArray, int[] additionalArray) {
        if (mainArray.length == 0) {
            return;
        }

        int mainIndex = 0;
        for (int value : mainArray) {
            if (value != 0) {
                mainArray[mainIndex++] = value;
            }
        }

        mergeArrays(mainArray, additionalArray, mainIndex - 1, additionalArray.length - 1);
    }

    public static void main(String[] args) {
        int[] mainArray = {0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] additionalArray = {1, 8, 9, 10, 15};

        rearrangeAndMerge(mainArray, additionalArray);

        System.out.println(Arrays.toString(mainArray));
    }
}







