package cn.ys.codility.lesson2.arrays;

public class CyclicRotation {
    
    
//    For example, given
//        A = [3, 8, 9, 7, 6]
//        K = 3
//    the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//        [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//        [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//        [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//                
//    For another example, given
//        A = [0, 0, 0]
//        K = 1
//    the function should return [0, 0, 0]
//    
//    Given
//        A = [1, 2, 3, 4]
//        K = 4
//    the function should return [1, 2, 3, 4]
    
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int temp;
        while(K>=1){
            for(int i=A.length-1;i>0;i--){
                A[i] = A[i] + A[i-1];
                A[i-1] = A[i] - A[i-1];
                A[i] = A[i] - A[i-1];
            }
            K--;
        }
        return A;
    }

}
