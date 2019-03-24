package com.coding.challenge.coursera;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question2 {

    public static void finalPrice(List<Integer> temp) {
        LinkedList<Integer> list = new LinkedList();
        LinkedList<Integer> nodiscount = new LinkedList();
        int total = 0;
        int[] out = new int[temp.size()];
        for(int i=temp.size()-1; i>=0 ;i--){
            if(!list.isEmpty()){
                while(!list.isEmpty()){
                    if(temp.get(i) >= list.get(0)){
                        out[i] = temp.get(i) - list.get(0);
                        total += out[i];
                        break;
                    }
                    list.remove(0);
                }
            }
            if(list.isEmpty()){
                out[i] = temp.get(i);
                total += out[i];
                nodiscount.add(i);
            }
            list.addFirst(temp.get(i));
        }
        System.out.println(Arrays.toString(out));
        System.out.println(total);
        Collections.reverse(nodiscount);
        for(int i : nodiscount){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {

    }
}
