package cn.ys.hankerrank.binarysearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BinarySearchTest {
    
  //Start typing here
  //给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
  //返回任何具有最长长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
  //输入："banana"
  //输出："ana"
  //输入 shabcdeabcdef  返回 abcde
  //aaaaaaaa


    public static void main(String[] args) {
        System.out.println(forEachString("aaaaaaaa"));
    }
    
    public static String forEachString(String S){
        int len = S.length();
        int a = 26;  // 26进制
        long module = (long) Math.pow(2, 32);  // 取一个足够大的数，用以取模
        if(len <= 1)
            return "";
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = (int) S.charAt(i) - (int) 'a';  // 只考虑小写字母
        }
        int low = 1;
        int high = len;
        while(low != high) {
            int L = (high-low)/2 + low;
            if(search(L, a, module, nums) != -1)
                low = L + 1;
            else
                high = L;
        }
        int start = search(low-1, a, module, nums);
        if(start == -1)
            return "";
        else
            return S.substring(start, start+low-1);
    }
    
    public static int search(int L, int a, long module, int[] nums) {
        int len = nums.length;
        HashSet<Long> hashSet = new HashSet<Long>(); 
        long tmp = 0;
        long aL = 1;
        for(int j = 0; j < L; j++){
            tmp = (tmp *a + nums[j]) % module;  // 防止溢出
            //System.out.println(tmp);
            aL = (aL*a) % module;
        }
        hashSet.add(tmp);
        for(int j = 1; j <= len - L; j++){  // 长度为i的窗口
            tmp = (tmp*a - nums[j-1]*aL%module + module) % module;  // 去掉前一位
            tmp = (tmp + nums[j+L-1]) % module;
            if(hashSet.contains(tmp))
                return j;
            hashSet.add(tmp);
        }
        return -1;
    }

}
