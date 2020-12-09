package com.nijad;

import java.util.Scanner;

public class Main {
    static void convertTime(String s){
        if (s.charAt(s.length() - 2) == 'A') {
            if (s.substring(0, 2).equals("12")) {
                System.out.print("00");
            } else {
                System.out.print(s.substring(0, 2));
            }

        } else {
            int hh = Integer.parseInt(s.substring(0, 2));
            if (hh == 12) {
                System.out.print(hh);
            } else {
                System.out.print(hh + 12);
            }
        }
        for (int i = 2; i < s.length() - 2; i++) {
            System.out.print(s.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        convertTime(s);

    }
}
