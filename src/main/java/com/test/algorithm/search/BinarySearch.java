package com.test.algorithm.search;

import com.test.algorithm.sort.MergeSort;

import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        // 1. 获取100个随机数
        int max=100;
        int min=1;
        Random random = new Random();
        int data[] = new int[max];

        for(int i=0; i< max; i++) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            data[i] = s;
        }

        // 2. 对这100个数进行排序
        MergeSort.merge_sort(data, 0, max-1);
        System.out.println("All num is below ...");
        System.out.println(data);

        // 3. 随机找一个数
        int s2 = random.nextInt(max) % (max - min + 1) + min;

        int data2 = data[s2];

        System.out.println("search "+ data2);
        System.out.println(data2);



    }
}
