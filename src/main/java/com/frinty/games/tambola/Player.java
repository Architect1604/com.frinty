package com.frinty.games.tambola;
import com.frinty.util.*;

public class Player {

	Ticket t = new Ticket();
	
	private final int[][] playerTicket = new int [3][9];
	private final int[][] arrChecker = new int [3][9];
	
	public static void main(String[] args) {
		Player p = new Player();
		//Ticket t = new Ticket();
		//p.populateArrChecker();
		p.testCheckNumber();
		System.out.println("playerTicket is: ");
		NumberUtils.print2DIntArray(p.getPlayerTicket());
		
		System.out.println("ArrChecker is: ");
		NumberUtils.print2DIntArray(p.getArrChecker());
		
	}
	
	
	public int[][] getPlayerTicket() {
		return playerTicket;
	}


	public int[][] getArrChecker() {
		return arrChecker;
	}


	//This method sets the value of all numbers in the checking array arrChecker to -1
	/*public void populateArrChecker() {
		playerTicket = t.createTicket();
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				//Try to make this method the only one for initialising array with -1 and 0
				//Use if statement to check arrTicket
				if (playerTicket[i][j]!=0) {
					arrChecker[i][j] = 0;
				} else {
					arrChecker[i][j]=-1;
				}
				
				
			}
			
		}
	}*/
	
	public boolean testCheckNumber() {
		boolean checked = false;
		if(this.checkNumber(1)) {
			checked = true;
		}
		return checked;
	}
	
	public boolean checkNumber(int num) {
		boolean checked = false;
		
		//to set rows and columns of arrChecker according to location of num in arrTicket
		//int row = 0;
		//int column = 0;
		
		//search for given number in 2d array Ticket
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				if (playerTicket[i][j]==num) {
					//row = i;
					//column = j;
					arrChecker[i][j] = 1;
					checked = true;
					break;
				}
			}
		}
		
		if (!checked) {
			System.out.println("Number not found in ticket");
		}
		
		return checked;
	}
	

	public Player() {
		
		int[][] built = t.createTicket();
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				playerTicket[i][j] = built[i][j];
				arrChecker[i][j] = (built[i][j]!=0) ? 0 : -1;
				//Substitute or shorter line of code for
				/*
				
				if (playerTicket[i][j]!=0) {
					arrChecker[i][j] = 0;
				} else {
					arrChecker[i][j]=-1;
				}
				
				 */
			}
		}
	}

	

}
