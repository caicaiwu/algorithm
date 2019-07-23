package com.test.algorithm.sort;

import java.util.Random;

public class MergeSort {

    public static void main( String[] args )
    {
        // 获取一些随机数
        int max=100;
        int min=1;
        Random random = new Random();
        int data[] = new int[max];

        for(int i=0; i< max; i++) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            data[i] = s;
        }

        //int data[] = {1,2,3,4,5,6,7};
        //merge(data, 0, 2, 6);

        merge_sort(data, 0, max-1);

        System.out.println(data);


    }

    /*
    * 此函数的作用是将两个排号顺序的队列排成一个队列
    * 时间复杂度是n
    * @ data,待排序的数列
    * @ p，队列1的起始下标
    * @ q，队列1的结束下标
    * @ r，队列2的结束下标
     */
    public static void merge(int data[], int p, int q, int r) {
        int len = r - q + 1; // 本次要计算的data的长度
        int len1 = q - p + 1;
        int len2 = r - q;

        int data1[] = new int[len1+1];
        int data2[] = new int[len2+1];

        for(int i=0; i<len1; i++) {
            data1[i] = data[p+i];
        }
        data1[len1] = 65536;

        for(int i=0; i<len2; i++) {
            data2[i] = data[q+1+i];
        }
        data2[len2] = 65536;

        int i1 = 0; // data1的下标
        int i2 = 0; // data2的下标
        int i0 = p;  // data的下标，从p开始

        while (i0 <= r) {
            if(data1[i1] < data2[i2]) {
                data[i0] = data1[i1];
                i1 += 1;
            } else {
                data[i0] = data2[i2];
                i2 += 1;
            }
            i0 += 1;
        }

    }

    public static void merge_sort(int data[], int b, int e) {
        if(e > b) {
            int p = (e + b) / 2;
            merge_sort(data, b, p);
            merge_sort(data, p+1, e);
            merge(data, b, p, e);
        }


    }


}
