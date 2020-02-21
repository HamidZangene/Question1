package com.randoemunique;
//A java program to demonstrate
//random unique numbers generation between [1,10000]
// using java.util.concurrent.ThreadLocalRandom
//and doing some operations on them
//like finding max and min of the numbers
// as well as sorting them,get the sum of them,
// get the sum of its odd numbers
//get the numbers divisible by 5

import java.util.concurrent.ThreadLocalRandom;

public class RandomInteger {

    //create  instance of an Integer array to hold the random unique numbers
    private Integer[] randomArray;

    // The constructor method to initialize our Integer array
    public RandomInteger(int size) {
          initialize(size);
    }

    //This is a method to return the max number in the array
    public int getMax(int size){
        return randomArray[size-1];
    }

    //This is a method to return the min number in the array
    public int getMin(){
        return randomArray[0];
    }

    //This is a method to initialize the randomArray and randomArrayInt
    private void initialize(int size) {
        randomArray = ThreadLocalRandom.current().ints(0, 10000)
                .boxed()
                .distinct()
                .limit(size)
                .sorted()
                .toArray(Integer[]::new);
        }

    //This is a method to get the sum of  the random array
    public long getSum() {
        long sum = 0;
        for(int i : randomArray){
            sum += i ;
        }
        return sum;
    }
    //This is a method to get the sum of odd numbers in  the random array
    public long getOddSum() {
        long sum = 0;
        for(int i : randomArray){
            if(i % 2 != 0)
                sum += i ;
        }
        return sum;
    }
    //This is a method to find all the numbers in the random array divisible by 5
    public void divisibleBy5() {
        int count = 0 ;
        for(int i : randomArray){
            count++ ;
            if( i % 5 == 0){
                System.out.print("[" + i +"]" +" ");
            }
            if(count == 20) {
                System.out.println();
                count = 0;
            }
        }
    }
    //This is a method to print the out put array
    public  void printArray(int size){
        int count = 0;
        for(int i :randomArray){
            System.out.print("[" + i +"]" +" ");
            count++;
            if(count == 20) {
                System.out.println();
                count = 0;
            }
        }
        System.out.print("\n\n");
   }


    public static void main(String[] args) {

        RandomInteger randomInteger = new RandomInteger(500);
        System.out.println("This is your random unique array :");
        randomInteger.printArray(500);
        System.out.printf("This is the max in this array :  %d  \n\n" ,randomInteger.getMax(500));
        System.out.printf("This is the min in this array :  %d  \n\n" ,randomInteger.getMin());
        System.out.printf("Total sum :   %d  \n\n",randomInteger.getSum());
        System.out.printf("Total sum of the odd numbers :   %d  \n\n",randomInteger.getOddSum());
        System.out.println("These are the numbers divisible by 5 :");
        randomInteger.divisibleBy5();

    }



}
