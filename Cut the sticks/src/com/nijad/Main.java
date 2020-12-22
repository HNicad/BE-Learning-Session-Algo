package com.nijad;

import java.util.Scanner;

public class Main {
    static final private int MAX = 1010;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cnt = new int[MAX];
        for(int i = 0; i < n; i++){
            ++cnt[scanner.nextInt()];
        }
        System.out.println(n);
        int sm = 0;
        for(int i = 1; i < MAX; i++){
            sm += cnt[i];
            if(cnt[i]!=0 && sm != n){
                System.out.println(n - sm);
            }
        }
    }
}
