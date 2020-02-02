package com.test.algorithm.dynaprogram;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 背包问题动态规划算法
 * 计算背包能装下的商品最大价值
 */
public class Backpack {

    public static final int BACK_OBJECT= 3; // 商品数量
    public static final int BACK_WEIGHT = 4; // 背包容量


    /**
     * 计算背包可以装入的最大价值
     * @param grid
     * @param objList
     * @return
     */
    public static int GetLargestPrice(int grid[][], List<MObject> objList) {
        // 开始计算
        int maxPrice = 0;
        for(int i=0; i< BACK_OBJECT; i++) {
            for(int j=0; j<BACK_WEIGHT; j++) {
                int price = getCellPrice(grid, i, j, objList.get(i).getWeight(), objList.get(i).getPrice());
                grid[i][j] = price;
                if(price > maxPrice) {
                    maxPrice = price;
                }
            }
        }
        return maxPrice;
    }


    /**
     * 计算每个单元格使用的公式，
     * cell[i][j]={从1，2中选择大的，1.上一个单元格的值cell[i-1][j],
     * 2.当前商品的价值+剩余空间的价值(cell[i-1][j-当前商品的重量])}
     * @param grid 网格
     * @param curI 当前行
     * @param curJ 当前列
     * @param objWeight 当前商品重量
     * @param objPrice 当前商品价值
     * @return
     */
    public static int getCellPrice(int grid[][], int curI, int curJ, int objWeight, int objPrice) {

        int res1 = 0;
        int res2 = 0;

        if(curI >= 1) {
            res1 = grid[curI-1][curJ];
        }

        if(curJ >= (objWeight-1)) {
            res2 = objPrice;
        }

        if( curI >= 1 && curJ > (objWeight-1) ) {
            int tmp = res2 + grid[curI-1][curJ-objWeight];
            //if( tmp <= BACK_MAX_WEIGHT ) {
                res2 = tmp;
            //}
        }

        if(res2 > res1) {
            return res2;
        }

        return res1;
    }

    public static void main(String[] args) {

        MObject guitar = new MObject("Guitar", 1, 1500);
        MObject speakers = new MObject("Speakers", 4, 3000);
        MObject nootbook = new MObject("Nootbook", 3, 2000);

        List<MObject> objectList = new ArrayList<>();
        objectList.add(guitar);
        objectList.add(nootbook);
        objectList.add(speakers);

        // 初始化网格
        int backGrid[][] = new int[BACK_OBJECT][BACK_WEIGHT];
        for(int i=0; i< BACK_OBJECT; i++) {
            for(int j=0; j<BACK_WEIGHT; j++) {
                backGrid[i][j] = 0;
            }
        }

        int mPrice = GetLargestPrice(backGrid, objectList);
        System.out.println("max price is "+mPrice);
        System.out.println("max price2 is "+backGrid[BACK_OBJECT-1][BACK_WEIGHT-1]);
    }

}
