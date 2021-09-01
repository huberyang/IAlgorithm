package cn.ys.codility.lesson3.timecomplexity;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermMissingElem {
    
//    An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], 
//    which means that exactly one element is missing.
//    Your goal is to find that missing element.
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A, returns the value of the missing element.
//
//    For example, given array A such that:
//      A[0] = 2
//      A[1] = 3
//      A[2] = 1
//      A[3] = 5
//    the function should return 4, as it is the missing element.
//
//    Write an efficient algorithm for the following assumptions:
//        N is an integer within the range [0..100,000];
//        the elements of A are all distinct;
//        each element of array A is an integer within the range [1..(N + 1)].
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        long N= A.length;
        N++;
        long sum = N*(N+1)/2;  //Arithmetic sequence summation formula
        //
        for(int i=0;i<A.length;i++){
            sum-=A[i];
        }

        return (int) sum;
    }
    
    
    /**
     * this one although using the Java8 new Feature but performance not better than foreach
     * @param A
     * @return
     */
    public int solution2(int[] A) {
        // write your code in Java SE 8
        long N = A.length;
        N++;
        long sum=N*(N+1)/2;

        IntStream stream = Arrays.stream(A);
        long sum2= stream.sum();
        return (int) (sum-sum2);
        
    }

}
