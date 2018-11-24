package com.code.stack;


/**
 * 括号的有效性(括号匹配)
 */
public class StackActualDemo {

    public static void main(String[] args){
        System.out.println(isValid("{[()]}"));
    }

    public static boolean isValid(String s){

        ArraysStack<Character> stack = new ArraysStack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
