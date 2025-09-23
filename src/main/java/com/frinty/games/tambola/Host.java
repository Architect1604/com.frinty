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
	
	//static ArrayList<Integer> nums = new ArrayList<Integer>();
	
	
	private final ArrayList<Integer> bowl = new ArrayList<Integer>();
	
	
	private final ArrayList<Integer> board = new ArrayList<Integer>();
	
	
	
	
	
	public static void main (String[] args) {
		new Host().startGame();
	}
	
	
	public void startGame() {
		System.out.println("The host has started the game");
		
		Player p = new Player();
		
		populateBowl();
		//NumberUtils.printIntArrayList(bowl);
		System.out.println();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		while(!bowl.isEmpty()) {
			//just for testing purposes, to be able to print arrChecker every 5 times
			int i=0;
			
			int called = drawNum();
			System.out.println("Called number is "+called);
			//Action after called number
			
			System.out.println("Type tick to tick, or leave blank to pass");
			String check = scanner.nextLine().trim().toLowerCase();
			boolean tick;
			if (check.equals("tick")) {
				tick = p.checkNumber(called);
				System.out.println("Claim?");
				String claim = scanner.nextLine().trim().toLowerCase();
				
				//TODO develop code block after prize functionality
				if (claim.equals("")) {
					
				}
			}
			if (i%5==0) {
				NumberUtils.print2DIntArray(p.getArrChecker());
			}
			//just for testing purposes, to be able to print arrChecker every 5 times
			i++;
		}
		scanner.close();
	}
	
	//generate 90 numbers: This can be done by populating the "bowl", and then drawing numbers one at a time (by calling the method drawNum each time)
	//This method inserts numbers from 1-90 (all inclusive, and not repeating) into the static arrayList bowl
	public void populateBowl() {
		//bowl = new ArrayList<Integer>();
		//board = new ArrayList<Integer>();
		bowl.clear();
		board.clear();
		for (int i=0; i<90; i++) {
			bowl.add(i+1);
		}			
	}
	
	//This method draws a single number out of the bowl arrayList (removes it), and then adds that number to the arrayList board (not used here but relevant for prize checking)
	public int drawNum() {
		int index = 0;
		int num = 0;
		
		index = NumberUtils.generateRandom(0, bowl.size()-1);
		num = bowl.get(index);
		board.add(num);
		bowl.remove(index);
		return num;
	}
	
	
	
	public Host() {
		// TODO Auto-generated constructor stub
	}

}
