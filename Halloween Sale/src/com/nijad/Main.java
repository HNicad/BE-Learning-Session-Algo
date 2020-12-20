package com.nijad;

import java.util.Scanner;

public class Main {

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
    static int solve(int p, int d, int m, int s){
        int cnt = 0;
        while(s >= p && s > 0){
            s -= p;
            p -= d;
            p = max(m,p);
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        System.out.println(solve(p,d,m,s));
    }
}
