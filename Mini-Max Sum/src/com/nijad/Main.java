package com.nijad;

import java.util.Scanner;

public class Main {

    static void solve(int[] a){
        long sm = 0;
        int mn = (int)1e9;
        int mx = 0;
        for(int i = 0; i < a.length; i++){
            sm += a[i];
            if(mx < a[i]){
                mx = a[i];
            }
            if(mn > a[i]){
                mn = a[i];
            }
        }
        System.out.println((sm - mx) + " " + (sm - mn));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[5];
        for(int i = 0; i < 5; i++){
            a[i] = scanner.nextInt();
        }
        solve(a);
    }
}
