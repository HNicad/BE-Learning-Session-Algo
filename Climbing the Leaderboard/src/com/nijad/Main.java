package com.nijad;

import java.util.Scanner;
// Time Complexity O(n+m)
public class Main {

    static void solve(int[] a, int[] b){
        int[] ranks = new int[a.length];
        ranks[0] = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] == a[i-1]){
                ranks[i] = ranks[i-1];
            }else{
                ranks[i] = ranks[i-1] + 1;
            }
        }
        int j = a.length - 1;
        int currentRank = ranks[a.length-1] + 1;
        for(int i = 0; i < b.length; i++){
            while( j >= 0 && b[i] >= a[j]  ){
                currentRank = ranks[j];
                --j;
            }
            System.out.println(currentRank);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }
        solve(a,b);

    }
}
