package com.example.task;

import java.util.Stack;

public class ProblemSolving {


    public String reverseInParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        int start = 0,end=0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                start = i;
            } else if (sb.charAt(i) == ')') {
                end = i;
                reverse(sb, start + 1, end - 1);
                start = 0;
                end = 0;
            }
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
