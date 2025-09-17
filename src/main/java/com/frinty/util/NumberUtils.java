package com.frinty.util;

import java.util.ArrayList;

public class NumberUtils {

	//This method generates a random number between the specified range
	//It takes integer parameters 'lower' and 'higher' and generates a random integer between them (inclusive of both of them)
	public static int generateRandom(int lower, int higher) {
			int randomNum=0;
			//System.out.println("Lower is " + lower);
			//System.out.println("Higher is " + higher);
			randomNum = lower + (int) (Math.random()*(higher-lower+1));
			
			return randomNum;
	}
		
		
	public static void printIntArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void print2DIntArray (int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}
	
	public static void printIntArrayList(ArrayList<Integer> arrayList) {
		for (int i=0; i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
	}
	
	public static ArrayList<Integer> sortArrayList (ArrayList<Integer> arrayList) {
		boolean sorted = false;
		int n = arrayList.size();
		
		while (!sorted) {
			sorted = true;
			
			for (int i=0; i<n-1; i++) {
				
				if (arrayList.get(i)>arrayList.get(i+1)) {
					
					//sort
					int temp = -1;
					temp = arrayList.get(i);
					arrayList.set(i, arrayList.get(i+1));
					arrayList.set(i+1, temp);	
					sorted = false;
				}
				
			}
			n--;
		}
		
		
		return arrayList;
	}
	
	public static boolean isNumInArray (int num, int[] arr) {
		boolean check = false;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]==num) {
				check = true;
				break;
			}
		}
 		
		return check;
	}
	
}

