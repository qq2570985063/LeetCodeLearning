package Sort;
import Sort.Sort;

import java.util.Arrays;

public class SortTest {
    public  static void main(String[] args){
        Sort test = new Sort();
        int[] arr = {1,6,2,4,3,5};
//        arr = test.bubbleSort(arr);
//        arr = test.selectionSort(arr);
        arr = test.insertionSort(arr);
//        arr = test.ShellSort(arr);
//        arr = test.MergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
