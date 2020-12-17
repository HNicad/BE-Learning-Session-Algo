package com.nijad;

import java.util.Scanner;

public class Main {

    static int solve(int[] a, int[] b){
        int cnt = 0;
        for(int i = 1; i <= 100; i++){
            boolean okA = true;
            for(int j = 0; j < a.length; j++){
                okA &= (i%a[j]) == 0;
            }
            boolean okB = true;
            for(int j = 0; j < b.length; j++){
                okB &= (b[j]%i) == 0;
            }
            if(okA && okB){
                ++cnt;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(a,b));

    }
}
