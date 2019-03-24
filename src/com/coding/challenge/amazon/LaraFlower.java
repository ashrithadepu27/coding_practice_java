package com.coding.challenge.amazon;

public class LaraFlower {

    public static int flowerBouquets(int p, int q, String s) {
//        char[] ch = s.toCharArray();
//        long totalCost = 0;
//        int val = 0, num = 0, c;
//        for(int i = 0; i < ch.length; i++) {
//            c = Character.getNumericValue(ch[i]);
//            val += c;
//            num++;
//            System.out.print(i + "  " + val + "  " + num);
//            if(num == 3 && val == 0) {
//                if(i < ch.length-1 && q > p && ch[i+1] == '1') {
//                    totalCost += q;
//                    i++;
//                } else {
//                    totalCost += p;
//                }
//
//                val = 0;
//                num = 0;
//            } else if (val == 1 && num > 1) {
//                System.out.println(" cond: " + (i < ch.length - 2) + "  " + (p > q) + "   " + (ch[i+1] == '0')+ "  " + (ch[i+2] == '0'));
//
//                if(ch[i] == '0' && i < ch.length - 2 && p > q && ch[i+1] == '0' && ch[i+2] == '0') {
//                    totalCost += p;
//                    i += 2;
//                } else {
//                    totalCost += q;
//                }
//                val = 0;
//                num = 0;
//            } else if(val > 1){
//                val = 0;
//                num = 0;
//            }
//            System.out.print("  " + totalCost);
//            System.out.println();
//        }
//        return (int) totalCost;
        return dp(p, q, s.toCharArray());
    }

    public static int dp(int p, int q, char[] s) {
        int[] totalCost = new int[s.length];
        if(Character.getNumericValue(s[1]) + Character.getNumericValue(s[0]) == 1) totalCost[1] = q;
        for(int i = 2; i < s.length; i++) {
            if (i > 2 && s[i] == '0' && s[i - 1] == '0' && s[i - 2] == '0') {
                totalCost[i] = Math.max(totalCost[i - 1], totalCost[i - 3] + p);
            } else if (i > 1 && ((s[i] == '0' && s[i - 1] == '1') || (s[i] == '1' && s[i - 1] == '0'))) {
                totalCost[i] = Math.max(totalCost[i - 1], totalCost[i - 2] + q);
            } else {
                totalCost[i] = totalCost[i-1];
            }
        }

        return totalCost[s.length-1];
    }


    public static void main(String[] args) {

        System.out.println("result: " + flowerBouquets(3, 2, "100010101000"));
    }
}
