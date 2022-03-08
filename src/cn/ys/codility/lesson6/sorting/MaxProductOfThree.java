package cn.ys.codility.lesson6.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.lang.model.element.Element;

public class MaxProductOfThree {
    
//    A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
//    For example, array A such that:
//
//      A[0] = -3
//      A[1] = 1
//      A[2] = 2
//      A[3] = -2
//      A[4] = 5
//      A[5] = 6
//    contains the following example triplets:
//    (0, 1, 2), product is −3 * 1 * 2 = −6
//    (1, 2, 4), product is 1 * 2 * 5 = 10
//    (2, 4, 5), product is 2 * 5 * 6 = 60
//    Your goal is to find the maximal product of any triplet.
//
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given a non-empty array A, returns the value of the maximal product of any triplet.
//
//    For example, given array A such that:
//      A[0] = -3
//      A[1] = 1
//      A[2] = 2
//      A[3] = -2
//      A[4] = 5
//      A[5] = 6
//    the function should return 60, as the product of triplet (2, 4, 5) is maximal.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [3..100,000];
//    each element of array A is an integer within the range [−1,000..1,000].
    
    
    /**
     * time complexity: O(N*log(N))
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        List tempList=new ArrayList();
        for(int i=0;i<A.length;i++){
            tempList.add(A[i]);
        }

        Collections.sort(tempList);

        int sum = (int)tempList.get(0) * (int)tempList.get(1) * (int)tempList.get(tempList.size()-1);
        int sum2 = (int)tempList.get(tempList.size()-3) * (int)tempList.get(tempList.size()-2) * (int)tempList.get(tempList.size()-1);

        int max = Math.max(sum,sum2);
        return max;
    }
    
    public static void main(String[] args) {
        List tempList=new ArrayList();
        tempList.add(new Integer(10));
        tempList.add(new Integer(2));
        tempList.add(new Integer(8));
        tempList.add(new Integer(4));
        tempList.add(new Integer(7));
        tempList.add(new Integer(4));
        tempList.add(new Integer(10000));
        
        Collections.sort(tempList);
        
        int index = Collections.binarySearch(tempList, 1000);
        
        //Collections.reverse(tempList);
        
        Collections.sort(tempList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.intValue()<o2.intValue()) {
                    return 1;
                }
                
                if(o1.intValue()>o2.intValue()) {
                    return -1;
                }
                return 0;
            };
        });
    
        tempList.stream().forEach(ele ->{
            System.out.println(ele);
        });
        
        System.out.println(index);
    }
}
