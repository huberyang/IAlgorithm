package cn.ys.codility.start;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.ys.utils.SortUtils;

/**
 * This is a demo task.
    Write a function:
    class Solution { public int solution(int[] A); }
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    Given A = [1, 2, 3], the function should return 4.
    Given A = [−1, −3], the function should return 1.
    Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
 * @author P1310989
 *
 */
public class SmallPositiveInt {
    
    public int solution(int[] A) {
        Set<Integer> tempSet = new HashSet<Integer>();
        for (int i =0;i<A.length;i++) {
            tempSet.add(A[i]);
        }
        
        List<Integer> tempList =new ArrayList<Integer>(tempSet);
        int[] newArr = tempList.stream().mapToInt(Integer::valueOf).toArray();
        
        if(newArr.length==0 || newArr.length==1) {
            return 1;
        }
        
        SortUtils.bubbleSort(newArr);
        int length= newArr.length;
        int largest = newArr[length-1];
        int secondLargest = newArr[length-2];
        
        if(largest<=0 || secondLargest<=0) {
            return 1;
        }else {
            if((largest-secondLargest)<2) {
                return ++largest;
            }else {   
                return ++secondLargest;
            }
        }
    }
    
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while (left < right) {
            while (right > left && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, right + 1, rightIndex);
    }

}
