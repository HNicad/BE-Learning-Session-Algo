package com.nijad;

import java.util.Scanner;

public class Main {

    static String[] mp = new String[31];
    static void init(){
        mp[0] = "zero";
        mp[1] = "one";
        mp[2] = "two";
        mp[3] = "three";
        mp[4] = "four";
        mp[5] = "five";
        mp[6] =	"six";
        mp[7] =	"seven";
        mp[8] =	"eight";
        mp[9] =	 "nine";
        mp[10] = "ten";
        mp[11] = "eleven";
        mp[12] = "twelve";
        mp[13] = "thirteen";
        mp[14] = "fourteen";
        mp[15] = "quarter";
        mp[16] = "sixteen";
        mp[17] = "seventeen";
        mp[18] ="eighteen";
        mp[19] ="nineteen";
        mp[20] ="twenty";
        mp[21] ="twenty one";
        mp[22] ="twenty two";
        mp[23] ="twenty three";
        mp[24] ="twenty four";
        mp[25] ="twenty five";
        mp[26] ="twenty six";
        mp[27] ="twenty seven";
        mp[28] ="twenty eight";
        mp[29] ="twenty nine";
        mp[30] ="half";
    }
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        if(m <= 30){
            if(m == 0){
                System.out.println(mp[h] + " o' clock");
            }else{
                if(m==30 || m == 15){
                    System.out.println(mp[m] + " past " + mp[h]);
                }
                else if(m==1){
                    System.out.println(mp[m] + " minute past " + mp[h]);
                }else{
                    System.out.println(mp[m] + " minutes past " + mp[h]);
                }
            }
        }else{
            h++;
            if(h==13) h = 1;
            m = 60 - m;
            if(m==15){
                System.out.println(mp[m] + " to " + mp[h]);
            }else{
                System.out.println(mp[m] + " minutes to " + mp[h]);
            }
        }
    }
}
