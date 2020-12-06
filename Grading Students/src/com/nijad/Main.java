package com.nijad;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int grade = scanner.nextInt();
            if(grade < 38){
                System.out.println(grade);
            }else{
                int m = grade % 5;
                System.out.println((m < 3) ? grade : (grade + 5 - m));
            }
        }

    }
}
