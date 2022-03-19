
package com.mycompany.miniproject4;

/**
 *
 * @author abw04
 */
/**
 * Class Sorts contains various static methods used to sort integer arrays
 */
public class Sorts {
    
    //Useful methods for use in sorting algorithms
    
    /**
     * Swap two integer elements in an array
     * Takes as parameters an integer array a, and two integers i and j which 
     * are the indices of the elements you want to swap
     * @param a
     * @param i
     * @param j 
     */
    public static void swapElements(int[] a, int i, int  j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void merge(int[] a, int start, int mid, int end) {
        int mergedSize = end - start + 1;
        int[] merged = new int[mergedSize];
        int mergePos;
        int leftPos;
        int rightPos;
        
        mergePos = 0;
        leftPos = start;
        rightPos = mid + 1;
        
        while (leftPos <= mid && rightPos <= end) {
            if (a[leftPos] < a[rightPos]) {
                merged[mergePos] = a[leftPos];
                leftPos++;
            } else {
                merged[mergePos] = a[rightPos];
            }
            mergePos++;
        }
        
        while (leftPos <= mid) {
            merged[mergePos] = a[leftPos];
            leftPos++;
            mergePos++;
        }
        
        while (rightPos <= end) {
            merged[mergePos] = a[rightPos];
            rightPos++;
            mergePos++;
        }
        
        for (int i = 0; i < mergedSize; i++) {
            a[start + i] = merged[i];
        }
    }
    
    //Selection Sort: Iterate through the whole unsorted part of the list and move
    //the smallest element to the front
    public static void selectionSort(int[] a, int first, int last) {
        for (int i = first; i < last; i++) {
            int minValue = a[i];
            int minValIndex = i;
            
            for (int j = i + 1; j < last; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minValIndex = j;
                    
                }
            }
            
            if (i != minValIndex) {
                swapElements(a, i, minValIndex);
            }
        }
    }
    
    //Insertion Sort: 
    public static void insertionSort(int[] a, int first, int last) {
        for (int i = first + 1; i < last; i++) {
            int next = a[i];
            
            int fillIndex = i - 1;
            while (fillIndex >= 0 && next < a[fillIndex]) {
                a[fillIndex + 1] = a[fillIndex];
                fillIndex--;
            }
            
            a[fillIndex + 1] = next;
        }
    }
    
    public static void quickSort(int[] a, int first, int last) {
        if (last - first > 3) {
            int mid = first + (last - first) / 2;
            
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
            if (a[mid] > a[last - 1]) {
                swapElements(a, mid, last);
            }
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
            
            swapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];
            
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            boolean done = false;
            
            while (!done) {
                while (a[indexFromLeft] < pivotValue) {
                    indexFromLeft++;
                }
                while (a[indexFromRight] > pivotValue) {
                    indexFromRight--;
                }
                if (indexFromLeft < indexFromRight) {
                    swapElements(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
                
            }
            
            swapElements(a, last - 1, indexFromLeft);
            
            quickSort(a, first, indexFromLeft);
            quickSort(a, indexFromLeft + 1, last);
            
            
        } else {
            selectionSort(a, first, last);
        }
    }
    
    public static void mergeSort(int[] a, int first, int last) {
        
    }
}
