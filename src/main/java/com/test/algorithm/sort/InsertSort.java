package com.test.algorithm.sort;

import java.util.Random;

/*
* 插入排序，时间复杂度是n平方
 */
public class InsertSort {

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

        insertion_sort(data, 0);

        System.out.println(data);
    }

    /*
    * 此排序是将一组数按从小到大的顺序进行排序。
    * 主循环从第二个数开始往后数，当前下标的数做为准备插入的数key。
    * 次循环从第二个数开始往前数，当发现某个数大于key后，将该数以及
    * 其后面的数都往后挪一位。将key放在某个数的位置。一直查看到最前面。
    * @ data, 要排序的数据
    * @ type，排序类型，0升序，1降序
     */
    public static void insertion_sort(int data[], int type) {
        int len = data.length;
        for(int j=1; j<len; j++) {
            int i=j-1;
            int key = data[j];

            if(type==0) {
                // 升序
                while (i >= 0 && data[i] > key) {
                    data[i + 1] = data[i];
                    i -= 1;
                }
            } else {
                // 降序
                while (i >= 0 && data[i] < key) {
                    data[i + 1] = data[i];
                    i -= 1;
                }
            }
            data[i+1] = key;
        }
    }
}
