package com.java.misc;

import java.util.LinkedList;
import java.util.List;

public class Misc {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 3)
                list.remove(i);
        }

        for(Integer i : list) {
            System.out.println(i);
        }

    }
}
