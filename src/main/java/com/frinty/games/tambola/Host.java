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
	
	
	private static ArrayList<Integer> bowl = new ArrayList<Integer>();
	
	//getter/setter method for bowl, but board is static
	/*
	public static ArrayList<Integer> getBowl() {
		return bowl;
	}

	public static void setBowl(ArrayList<Integer> bowl) {
		Host.bowl = bowl;
	}*/

	private static ArrayList<Integer> board = new ArrayList<Integer>();
	
	//getter/setter method for board, but board is static
	/*public ArrayList<Integer> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Integer> board) {
		this.board = board;
	}*/

	
	
	
	public static void main (String[] args) {
		Host host = new Host();
		//System.out.println(NumberUtils.generateRandom(0, 05));
		host.populateBowl();
		NumberUtils.printIntArrayList(bowl);
		for (int i=0; i<90; i++) {
			System.out.println(host.drawNum());
		}
		System.out.println("Board is:");
		NumberUtils.printIntArrayList(board);
		//System.out.println("First number at index 0 of bowl is " + bowl.get(4));
		//NumberUtils.printIntArrayList(bowl);
		
		
		
		
		/*for (int i=0; i<90; i++) {
			System.out.println("The called number is " + host.call());	
		}
		host.call();
		NumberUtils.printIntArrayList(nums);
		//NumberUtils.printIntArrayList(host.call90());
		//System.out.println("Chosen number is "+host.execute90(89));
		*/
		 
	}
	
	//generate 90 numbers:
	
	//TODO: remove after troubleshooting, or change i range back to <90
	public void populateBowl() {
		bowl = new ArrayList<Integer>();
		board = new ArrayList<Integer>();
		for (int i=0; i<90; i++) {
			
			bowl.add(i+1);
		}
			
		System.out.println("Bowl size is " + bowl.size() + " so bowl.size-1 is " + (bowl.size()-1));
	}
	
	
	
	public int drawNum() {
		int index = 0;
		int num = 0;
		
		index = NumberUtils.generateRandom(0, bowl.size()-1);
		System.out.println("Index is " + index);
		num = bowl.get(index);
		System.out.println("Num is " + num);
		board.add(num);
		bowl.remove(index);
		System.out.println("Size of bowl right now is " + bowl.size());
		return num;
	}
	
	
	
	/*
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
	}*/
	
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
