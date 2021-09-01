package cn.ys.codility.lesson3.timecomplexity;

public class FrogJmp {
    
//   Count the minimal number of jumps that the small frog must perform to reach its target.
//   
//   given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
//   For example, given:
//     X = 10
//     Y = 85
//     D = 30
//     
//   the function should return 3, because the frog will be positioned as follows:
//
//   after the first jump, at position 10 + 30 = 40
//   after the second jump, at position 10 + 30 + 30 = 70
//   after the third jump, at position 10 + 30 + 30 + 30 = 100
    
   
   // this method didt think about performance
   public int myFirstStupidIdea(int X, int Y, int D) {
       int count=0;
       if(X<Y) {
           count++;
           X=X+D;
       }
       return count;
   }
    
    
   public int solution(int X, int Y, int D) {
       Y=Y-X;
       int count = Y/D;
       int temp = Y%D;
       if(temp>0){
           count++;
       }
       return count;
   }

}
