package cn.ys.codility.lesson4.countelements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    
//    A non-empty array A consisting of N integers is given.
//    A permutation is a sequence containing each element from 1 to N once, and only once.
//    
//    For example, array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        A[3] = 2
//    is a permutation, but array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//    is not a permutation, because value 2 is missing.
//    The goal is to check whether array A is a permutation.
//
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
//    For example, given array A such that:
//
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        A[3] = 2
//    the function should return 1.
//    Given array A such that:
//
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//    the function should return 0.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [1..1,000,000,000].
    
    
    
    /**
     * time complexity: O(N) or O(N*log(N))
     * @param A
     * @return
     */
    public int solution(int[] A) {
        long N = A.length;
        long sum = N*(N+1)/2;
        long sum2 = 0;
        Set tempSet =new HashSet();
        for(int i=0;i<A.length;i++){
            sum2+=A[i];
            tempSet.add(A[i]);
        }

        if(sum==sum2 && tempSet.size() == N){
            return 1;
        }
        return 0;
    }

}
