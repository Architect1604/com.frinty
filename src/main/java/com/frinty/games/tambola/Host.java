package com.frinty.games.tambola;
import com.frinty.util.*;
import java.util.ArrayList;

public class Host {

	
	//Host host = new Host();
	
	//This class is the host class for playing the game Tambola. 
	//Once players have tickets from the ticket class, they should be able to play together, which this class enables
	
	//This class should call (generate) all the numbers from 1 to 90 (at random)
	
	//This class should check (validate) a ticket when a prize is claimed (e.g. house)
	//This class should then accordingly update the status of the prizes (e.g. house gone/remaining)
	
	
	//private boolean house;
	//private boolean topLine;
	//private boolean middleLine;
	//private boolean bottomLine;
	//private boolean earlyFive;
	//private boolean fourCorners;
	
	//int [] nums = new int [90];
	//int counter = 1;
	
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	
	public static void main (String[] args) {
		Host host = new Host();
		/*for (int i=0; i<90; i++) {
			System.out.println("The called number is " + host.call());	
		}*/
		host.call();
		NumberUtils.printIntArrayList(nums);
		//NumberUtils.printIntArrayList(host.call90());
		//System.out.println("Chosen number is "+host.execute90(89));
	}
	
	//generate 90 numbers:
	
	public ArrayList<Integer> call90 () {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<90; i++) {
			int num = 0;
			boolean contains = true;
			while (contains) {
				num = NumberUtils.generateRandom(1, 90);
				if (nums.contains(num)) {
					contains = true;
				} else {
					contains = false;
				}
			}
			nums.add(num);
		}
		
		
		return nums;
	}
	
	//TODO modify
	public int execute90 (int i) {
		Host host = new Host();
		ArrayList<Integer> nums = host.call90();
		int num;
		//Index of which number to return
		num = nums.get(i);
		return num;
	}
	
	
	public int call() {
		if (nums.size()>90) {
			nums = new ArrayList<Integer>();
		}
		
		int num = 0;
		boolean contains = true;
		
		while (contains) {
			//System.out.println("Entered while loop");
			num = NumberUtils.generateRandom(1, 90);
			System.out.println("Num is " + num + " and contains is " + contains);
			for (int i=0; i<nums.size(); i++) {
				System.out.println(nums.get(i)==num);
				if (nums.get(i)==num) {
					//System.out.println("Nums.get(i) condition is " + (nums.get(i)==num));
					
					contains = true;
					break;
				} else {
					contains = false;
				}
			}
		}
		nums.add(num);
		return num;
	}
	
	/*
	public int call() {
		if (counter==91) {
			nums = new int[90];
		}
		
		int num = 0;
		
		boolean contains = true;
		while (contains) {
			num = NumberUtils.generateRandom(1, 90);
			for (int i=0; i<counter; i++) {
				if (nums[i]==num) {
					contains = true;
				} else {
					contains = false;
				}
			}
			counter++;
		}
		
		return num;
	}*/
	
	public Host() {
		// TODO Auto-generated constructor stub
	}

}
