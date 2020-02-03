package com.test.algorithm.dynaprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大公共字串算法
 */
public class LCSTest {

    /**
     * 坐标点类
     */
    static class MPoint {
        private int i;
        private int j;

        private int i2; // 结束坐标
        private int j2; // 结束坐标

        public MPoint(int i, int j, int i2, int j2) {
            this.i = i;
            this.j = j;
            this.i2 = i2;
            this.j2 = j2;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getI2() {
            return i2;
        }

        public void setI2(int i2) {
            this.i2 = i2;
        }

        public int getJ2() {
            return j2;
        }

        public void setJ2(int j2) {
            this.j2 = j2;
        }
    }

    /**
     * 坐标点管理类
     */
    static class MPointManager {

        private int baseLen;

        private List<MPoint> pList = new ArrayList<>();

        public MPointManager() {
            baseLen = 2;
        }

        public int getBaseLen() {
            return baseLen;
        }

        public void setBaseLen(int baseLen) {
            this.baseLen = baseLen;
        }

        public List<MPoint> getPList() {
            return pList;
        }

        public void addPoint(MPoint point) {
            pList.add(point);
        }

        public MPoint findPoint(int i, int j) {
            for(MPoint p1 : pList) {
                if(p1.getI()==i && p1.getJ()==j) {
                    // 找到并更新
                    return p1;
                }
            }

            return null;
        }

        /**
         * 更新结束坐标
         * @param p1
         * @param i
         * @param j
         */
        public void updateEndPoint(MPoint p1, int i, int j) {
            p1.setI2(i);
            p1.setJ2(j);
        }

        /**
         * 获取有效的字串，长度大于4
         * @return
         */
        List<MPoint> getUsefulList() {
            List<MPoint> newList = new ArrayList<>();
            for(MPoint p1 : pList) {
                int len = p1.getI2()-p1.getI();
                if(len > baseLen)  {
                    newList.add(p1);
                }
            }

            return newList;
        }

    }

    public static List<String> getLCS(String str1, String str2) {
        List<String> resList = new ArrayList<>();

        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str2.getBytes();

        int rowLen = bytes1.length;
        int columeLen = bytes2.length;

        MPointManager pointManager = new MPointManager();

        int[][] grid = new int[rowLen][columeLen];

        // 开始比较每个字节,把byte2的每个字符和byte1进行比较
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columeLen; j++) {
                try {
                    if (bytes1[i] == bytes2[j]) {
                        if (i > 0 && j > 0) {
                            grid[i][j] = grid[i - 1][j - 1] + 1;
                        } else {
                            grid[i][j] = 1;
                        }

                        if(grid[i][j] == 1) {
                            // 创建初始点
                            MPoint p = new MPoint(i, j, i, j);
                            pointManager.addPoint(p);

                        } else {
                            // 找到初始点
                            int i1 = i-(grid[i][j]-1);
                            int j1 = j-(grid[i][j]-1);

                            MPoint p1 = pointManager.findPoint(i1, j1);
                            if(p1 != null) {
                                pointManager.updateEndPoint(p1, i, j);
                            }
                        }
                    } else {
                        grid[i][j] = 0;
                    }
                } catch (Exception e) {
                    System.out.println("debug"+i+" "+j);
                }
            }
        }

        List<MPoint> pList = pointManager.getUsefulList();

        for(MPoint p : pList) {
            int len = p.getI2() - p.getI() + 1;
            byte[] bytes = new byte[len];
            for(int j=0; j<len; j++) {
                bytes[j] = bytes1[p.getI()+j];
             }
            resList.add(new String(bytes));
             //System.out.println(new String(bytes) + " " + len);
        }

        return resList;
    }

    public static void main(String[] args) {

        String str1 = "TESTISHOST";
        String str2 = "HOSTISTEST";

        List<String> strList = getLCS(str1, str2);

        for(String str : strList) {
            System.out.println("LCS is : " + str);
        }



    }
}
