package cn.ys.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    
    /**
     * O(1) = N^2
     * N = nums.length
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i =0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if((nums[i]+nums[j])==target){
                   return new int[] {i,j};
                }
            }
        }
        return new int[2];
    }
    
    /**
     * O(1) = N
     * N = nums.length
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
       Map<Integer, Integer> map =new HashMap<Integer, Integer>();
       for(int i=0;i<nums.length;i++) {
           if(map.containsKey(target-nums[i]) && i != map.get(target-nums[i]))
           {
               return new int[] {i,map.get(target-nums[i])};
           }   
           map.put(nums[i], i);
       }
       return new int[2];
    }
}
