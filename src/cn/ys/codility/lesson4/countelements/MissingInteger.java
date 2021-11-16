package cn.ys.codility.lesson4.countelements;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MissingInteger {
    
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//            
//    Given A = [1, 2, 3], the function should return 4.
//    Given A = [−1, −3], the function should return 1.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].
    
    
    /**
     * O(N) or O(N * log(N))
     * 
     * @param A
     * @return
     */
    public int solution(int[] A) {
        
        Set testSet =new HashSet();
        Set realSet =new HashSet();

        for(int i =0;i<A.length;i++){
            testSet.add(i+1);
            realSet.add(A[i]);  
        }

        Iterator ite = testSet.iterator();
        while(ite.hasNext()){
            int temp = (int) ite.next();
            if(!realSet.contains(temp)){
                return temp;
            }
        }

        if(testSet.size()==realSet.size()){
            return testSet.size()+1;
        }
        return 1;
        
    }
    
}