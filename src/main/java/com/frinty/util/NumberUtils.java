package com.frinty.util;

public class NumberUtils {

	
	public static int generateRandom(int lower, int higher) {
			int randomNum=0;
			//System.out.println("Lower is " + lower);
			//System.out.println("Higher is " + higher);
			randomNum = lower + (int) (Math.random()*(higher-lower+1));
			
			return randomNum;
	}
		
		
}

