package com.arrays;

import java.util.*;

/**
 * Created by Surya on 7/25/2017.
 */

public class ArrayFrequencySort {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        class comp implements Comparator<Integer> {
            Map<Integer, Integer> map;
            public comp(Map<Integer, Integer> map) {
                this.map = map;
            }
            @Override
            public int compare(Integer a, Integer b) {
                int c1 = map.get(a), c2 = map.get(b);
                if (c1 == c2) return a.compareTo(b);
                else {
                    return c2-c1;
                }
            }
        }
        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            Integer [] arr = new Integer[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                int c = map.getOrDefault(arr[i], 0) + 1;
                map.put(arr[i], c);
            }
            comp c1 = new comp(map);
            Arrays.sort(arr, c1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
        }
    }
}