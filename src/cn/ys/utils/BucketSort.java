package cn.ys.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    
    
    public static void main(String[] args) {
        int arr[] = {9,2,3,8,4,5,6}; // 9,2   6
        BucketSort.Sort(arr);
        
        for(int i=0;i<arr.length;i++) 
        System.out.print(arr[i] + ", ");
    }

    private static void Sort(int[] arr) {
        
       //先遍历找出最大值，和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        
        System.out.println("max: "+ max);
        System.out.println("min: "+ min);
        
        //计算桶的数量
        int bucketNum = (max -min)/arr.length +1;
        // init the each bucket
        List<List> bucketList = new ArrayList<List>(bucketNum);
        for(int j=0;j<bucketNum;j++) {
            bucketList.add(new ArrayList<Integer>());
        }
        
        //put the ele into bucket evenly
        for(int i=0;i<arr.length;i++) {
            int num = (arr[i]-min)/arr.length;
            bucketList.get(num).add(arr[i]);
        }
        
        //sort each bucket
        for(int i=0;i<bucketNum;i++) {
            Collections.sort(bucketList.get(i));
        }
        
        //put the each ele from bucket to origin arr
        int index =0;
        for(int i=0;i<bucketNum;i++) {
            List<Integer> bucket = bucketList.get(i);
            for(int j=0;j<bucket.size();j++) {
                arr[index++] = bucket.get(j);
            }
        }
        
    }

}