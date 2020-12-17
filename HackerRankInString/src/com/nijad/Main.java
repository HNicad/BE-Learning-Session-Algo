package com.nijad;

import java.util.Scanner;

public class Main {
    final static private String HACKERRANK = "hackerrank";
    static void solve(String s){
        int j = 0;
        for(int i = 0; i < s.length() && j < HACKERRANK.length(); i++){
            if(s.charAt(i) == HACKERRANK.charAt(j)){
                ++j;
            }
        }
        System.out.println((j==HACKERRANK.length())?"YES":"NO");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++){
            String s = scanner.next();
            solve(s);
        }
    }
}
