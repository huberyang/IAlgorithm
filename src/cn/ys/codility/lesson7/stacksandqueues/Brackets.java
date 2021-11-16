package cn.ys.codility.lesson7.stacksandqueues;

import java.util.Stack;

public class Brackets {
    
    public int solution(String S) {
        // write your code in Java SE 8
        if(S.length()%2!=0)
            return 0;
        
        Stack s =new Stack();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(correctChar(c)){
                s.push(c);
            }else{
                if(s.size()==0)
                    return 0;
                char popC = (char)s.pop();
                if(!isMatch(popC,c)){
                    return 0;
                }else{
                    continue;
                }
            }
        }
        
        if(s.isEmpty()) return 1;
        return 0;    
    }

    public boolean correctChar(char c){
        if(c=='(' || c=='{' || c=='['){
            return true;
        }
        return false;
    }

    public boolean isMatch(char c,char s){
        if(c=='(' && s==')'){
            return true;
        }else if(c=='{' && s =='}'){
            return true;
        }else if(c=='[' && s == ']'){
            return true;
        }else
            return false;
    }
}
