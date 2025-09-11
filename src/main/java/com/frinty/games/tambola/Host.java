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
	
	public static void main (String[] args) {
		Host host = new Host();
		
		NumberUtils.printIntArrayList(host.call90());
		System.out.println("Chosen number is "+host.execute90(89));
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
	
	public int execute90 (int i) {
		Host host = new Host();
		ArrayList<Integer> nums = host.call90();
		int num;
		//Index of which number to return
		num = nums.get(i);
		return num;
	}
	
	
	public Host() {
		// TODO Auto-generated constructor stub
	}

}
