package com.frinty.games.tambola;
import com.frinty.util.*;

public class Player {

	Ticket t = new Ticket();
	
	static int[][] arrChecker = new int [3][9];
	
	public static void main(String[] args) {
		Player p = new Player();
		
		p.populateArrChecker();
		NumberUtils.print2DIntArray(arrChecker);
	}
	
	
	//This method sets the value of all numbers in the checking array arrChecker to -1
	public void populateArrChecker() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				//Try to make this method the only one for initialising array with -1 and 0
				//Use if statement to check arrTicket
				//But before that, need to figure out how to access populated arrTicket
				//if ()
				arrChecker[i][j]=-1;
			}
			
		}
	}
	
	//This method sets the value of the indices in arrChecker to 0 
	//This corresponds to arrTicket's indices that don't have a value of 0
	public void initArrChecker() {
		
	}
	

	public Player() {
		// TODO Auto-generated constructor stub
	}

	

}
