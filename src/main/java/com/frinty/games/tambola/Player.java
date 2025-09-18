package com.frinty.games.tambola;
import com.frinty.util.*;

public class Player {

	Ticket t = new Ticket();
	
	int[][] arrTicket = new int [3][9];
	static int[][] arrChecker = new int [3][9];
	
	public static void main(String[] args) {
		Player p = new Player();
		
		p.populateArrChecker();
		NumberUtils.print2DIntArray(arrChecker);
	}
	
	
	//This method sets the value of all numbers in the checking array arrChecker to -1
	public void populateArrChecker() {
		arrTicket = t.createTicket();
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				//Try to make this method the only one for initialising array with -1 and 0
				//Use if statement to check arrTicket
				//But before that, need to figure out how to access populated arrTicket
				//if ()
				if (arrTicket[i][j]!=0) {
					arrChecker[i][j] = 0;
				} else {
					arrChecker[i][j]=-1;
				}
				
				
			}
			
		}
	}
	
	public boolean checkNumber(int num) {
		boolean checked = false;
		
		
		
		return checked;
	}
	

	public Player() {
		// TODO Auto-generated constructor stub
	}

	

}
