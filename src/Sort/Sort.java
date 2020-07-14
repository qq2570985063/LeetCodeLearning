package Sort;

import java.util.Arrays;

public class Sort {
    /**
     * 冒泡排序:
     * 冒泡排序是一种简单的排序算法。
     * 它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *
     * 算法描述：
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     *
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public int[] bubbleSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;

        for(int i=0; i<len; i++){
            for(int j=0; j<len-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * 选择排序：
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
     * 选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * 算法描述：
     * 1.初始状态：无序区为R[1..n]，有序区为空；
     * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     *   该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
     *   将它与无序区的第1个记录R交换，
     *   使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * 3.n-1趟结束，数组有序化了。
     *
     * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
     */
    public int[] selectionSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;

        for(int i=0; i<len; i++){
            int minIdx = i;
            for(int j=i; j<len; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        return arr;
    }
    /**
     * 插入排序：
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     *
     * 算法描述：
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     *
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
//    public int[] insertionSort(int[] arr){
//        int len = arr.length;
//        if(len < 2) return arr;
//
//        for(int i=0; i<len-1; i++){
//            int temp = arr[i+1];
//            int preIdx = i;
//            while(preIdx>=0 && temp < arr[preIdx]){
//                arr[preIdx+1] = arr[preIdx];
//                preIdx--;
//            }
//            arr[preIdx+1] = temp;
//        }
//
//        return arr;
//    }
    public int[] insertionSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;

        for(int i=0; i<len-1; i++){
            int temp = arr[i+1];
            int preIdx = i;
            while(preIdx>=0 && temp<arr[preIdx]){
                arr[preIdx+1] = arr[preIdx];
                preIdx--;
            }
            arr[preIdx+1] = temp;
        }
        return arr;
    }

    /**
     * 希尔排序：
     * 希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
     * 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
     * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     * 希尔排序是把记录按一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     *
     * 算法描述：
     * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 2.按增量序列个数k，对序列进行k 趟排序；
     * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
     */
    public int[] ShellSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;

        int gap = len/2;
        while(gap>0){
            for(int i=gap; i<len; i++){
                int temp = arr[i];
                int preIdx = i-gap;
                while(preIdx>=0 && temp<arr[preIdx]){
                    arr[preIdx+gap] = arr[preIdx];
                    preIdx -= gap;
                }
                arr[preIdx+gap] = temp;
            }
            gap /= 2;
        }

        return arr;
    }

    /**
     * 归并排序：
     * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
     * 归并排序是建立在归并操作上的一种有效的排序算法。
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为2-路归并。
     *
     * 算法描述：
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     */
    public int[] MergeSort(int[] arr){
        int len = arr.length;
        if(len < 2) return arr;

        int mid = len/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, len);

        return Merge(MergeSort(left), MergeSort(right));
    }
    public int[] Merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        for(int idx=0, i=0, j=0; idx<result.length; idx++){
            if(i>=left.length) result[idx] = right[j++];
            else if(j>=right.length) result[idx] = left[i++];
            else if(left[i] < right[j]) result[idx] = left[i++];
            else if(left[i] >= right[j]) result[idx] = right[j++];
        }
        return result;
    }

    /**
     * 快速排序：
     * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     * 算法描述：
     *
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
     */
}
