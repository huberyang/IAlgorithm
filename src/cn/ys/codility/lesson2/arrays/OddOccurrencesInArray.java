package cn.ys.codility.lesson2.arrays;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        
        Set<Integer> tempSet =new HashSet<Integer>();
        for(int i=0;i<A.length;i++) {
            if(tempSet.contains(A[i])){
                tempSet.remove(A[i]);
            }else {
                tempSet.add(A[i]);
            }
        }
        Object[] arr = tempSet.toArray();
        return (int) arr[0];
    }
}
