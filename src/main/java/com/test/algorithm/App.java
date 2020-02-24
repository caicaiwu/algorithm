package com.test.algorithm;

import java.util.Random;

/**
 * Hello world!
 *  git push origin master
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        int max=100;
        int min=200;
        Random random = new Random();

        for(int i=0; i< 10; i++) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            System.out.println(s);
        }
    }
}
