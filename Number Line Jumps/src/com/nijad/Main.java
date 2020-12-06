package com.nijad;

import java.util.Scanner;
// x1 + t * v1 = x2 + t * v2 => t = (x2 - x1) / (v1 - v2)
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();
        if(v1 - v2 == 0){
            System.out.println((x1 == x2) ? "YES" : "NO");
        }else{
            int t = (x2 - x1 ) / (v1 -  v2);
            if((x2 - x1 ) % (v1 -  v2) == 0){
                System.out.println((t >= 0) ? "YES" : "NO");
            }else{
                System.out.println("NO");
            }
        }
    }
}
