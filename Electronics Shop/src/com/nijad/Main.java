package com.nijad;

import java.util.*;
import java.util.stream.Collectors;

// Time Complexity: O(nlog(n) + mlog(m))
// Task can also be solved using brute force where the complexity would be O(n * m)
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); //skip the newline
        ArrayList<Integer> keyboards = (ArrayList<Integer>) Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        ArrayList<Integer> drives = (ArrayList<Integer>) Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        Collections.sort(keyboards);
        Collections.sort(drives,Collections.reverseOrder());
        int i = keyboards.size() - 1;
        int j = drives.size() - 1;
        int ans = -1;
        while(i > 0 || j > 0){
            int temp = keyboards.get(i) + drives.get(j);
            if( temp <= totalPrice){
                ans = Math.max(temp,ans);
                if(j > 0){ // since drives are sorted in descending order decreasing 'j' will increase price
                    --j;
                }else{     // otherwise we will not get better result
                    break;
                }
            }else{
                if(i > 0){ // we have to decrease price
                    --i;
                }else{  // if we can't we need to stop
                    break;
                }
            }
        }
        if(keyboards.get(i) + drives.get(j) <= totalPrice){ // check the (keyboard[0] + drives[0])
            ans = Math.max(keyboards.get(i) + drives.get(j),ans);
        }
        System.out.println(ans);
    }
}




