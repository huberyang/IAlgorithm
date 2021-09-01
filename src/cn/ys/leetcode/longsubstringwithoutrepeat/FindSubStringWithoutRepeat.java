package cn.ys.leetcode.longsubstringwithoutrepeat;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindSubStringWithoutRepeat {
    
    public int lengthOfLongestSubstring(String s) {
        
        Set<String> subStrSet = new HashSet<String>();
        for(int i = 0;i<s.length();i++) {
            for(int j = i+1;j<=s.length();j++) {
                subStrSet.add(s.substring(i, j));
            }
        }
        
        String largeStr = "";
        int largeStrLen = 0;
        Iterator<String> iterator = subStrSet.iterator();
        while(iterator.hasNext()) {
            char[] temp = iterator.next().toCharArray();
            Set<Character> tempSet = new HashSet<Character>();
            for(int i =0;i<temp.length;i++) {
               tempSet.add(temp[i]);
            }
            
            if(tempSet.size() == temp.length) {
                if(temp.length>largeStrLen) {
                    largeStrLen = temp.length;
                }
            }
        }
        
       return largeStrLen;
    }
}
