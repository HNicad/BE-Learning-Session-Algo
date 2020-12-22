package com.nijad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    static void rotate(List<Integer> a){
        int tmp = a.get(2);
        a.set(2, a.get(1));
        a.set(1, a.get(0));
        a.set(0,tmp);
    }
    static boolean isSorted(List<Integer> a){
        return (a.get(0)<  a.get(1) &&  a.get(1) <  a.get(2));
    }
    static String solve(List<Integer> a){
        int i = 1;
        while(a.size() > 3){
            int p = -1;
            for(int j = 0; j < a.size(); j++){
                if(a.get(j) == i){
                    p = j;
                    break;
                }
            }
            ++i;
            a.remove(p);
            if(p % 2 == 1){
                int tmp = a.get(0);
                a.set(0,a.get(1));
                a.set(1,tmp);
            }
        }

        for(int j = 0; j < 4; j++){
            if(isSorted(a)){
                return "YES";
            }
            System.out.println(a);
            rotate(a);
        }

        return "NO";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int x = scanner.nextInt();
                a.add(x);
            }
            System.out.println(solve(a));

        }
    }
}
