package com.coding.challenge.aci;

public class ReachN {

    public static int solution(int n) {
        int count = 0;
        while(n >= 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(solution(9));
    }
}
