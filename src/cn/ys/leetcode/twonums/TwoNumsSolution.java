package cn.ys.leetcode.twonums;

public class TwoNumsSolution {
    
    class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            super();
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    
    /**
     * 
     * for the result ListNode need a pointer to point to the result ListNode
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode pointer = resultNode;
        int temp =0;
        while(l1 != null || l2 != null) {
            temp+= (l1!=null ? l1.val : 0);
            temp+= (l2!=null ? l2.val : 0);
            if(temp>=10) {
                pointer.val = temp%10;
            }else {
                pointer.val = temp;
            }
            
            //move pointer for l1,l2
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
            //move pointer
            if(l1!=null || l2!=null || temp/10>0){
                temp=temp/10;
                pointer.next = new ListNode(temp);
                pointer=pointer.next;
            }
        }
        return pointer;
    }

}
