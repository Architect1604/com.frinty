package com.frinty.games.tambola;
import com.frinty.util.*;
import java.util.ArrayList;

public class Host {

	//This class is the host class for playing the game Tambola. 
	//Once players have tickets from the ticket class, they should be able to play together, which this class enables
	
	//This class should call (generate) all the numbers from 1 to 90 (at random)
	
	//This class should check (validate) a ticket when a prize is claimed (e.g. house)
	//This class should then accordingly update the status of the prizes (e.g. house gone/remaining)
	
	
	//generate 90 numbers:
	
	
	public ArrayList<Integer> call90 () {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<90; i++) {
			int num = 0;
			System.out.println("Num is " + num + " and i is " + i);
			while (nums.contains(num)) {
				num = NumberUtils.generateRandom(1, 90);
				System.out.println("Num is " + num + " and i is" + i);
			}
		}
		
		return nums;
	}
	
	public ArrayList<Integer> call90_2 () {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int num = 0;
		for (int i=0; i<90; i++) {
			
			System.out.println("Initial Num is " + num + " and i is " + i);
			if (i==0) {
				num = NumberUtils.generateRandom(1, 90);
				System.out.println("At i=0 Num is " + num);
			} else {
				while (nums.contains(num)) {
					num = NumberUtils.generateRandom(1, 90);
					System.out.println("At i=" + i + "Num is " + num);
				}
			}
		}
		
		return nums;
	}
	
	
	public static void main (String[] args) {
		Host host = new Host();
		
		NumberUtils.printIntArrayList(host.call90());
	}
	
	public Host() {
		// TODO Auto-generated constructor stub
	}

}
