package com.frinty.games.tambola;
import com.frinty.util.*;
import java.util.ArrayList;

public class Host {
	
	//This class is the host class for playing the game Tambola. 
	//Once players have tickets from the ticket class, they should be able to play together, which this class enables
	
	//This class should call (generate) all the numbers from 1 to 90 (at random)
	
	//This class should check (validate) a ticket when a prize is claimed (e.g. house)
	//This class should then accordingly update the status of the prizes (e.g. house gone/remaining)
	
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
			//int i=0;
			
			int called = drawNum();
			System.out.println("Called number is "+called);
			//Action after called number
			
			System.out.println("Type t to tick, or leave blank to pass");
			String check = scanner.nextLine().trim().toLowerCase();
			boolean tick;
			if (check.equals("t")) {
				tick = p.checkNumber(called);
				System.out.println("Claim?");
				String claim = scanner.nextLine().trim().toLowerCase();
				//prizeClaim(p, claim);
				if (!prizeClaim(p,claim)) {
					System.out.println("Bogey, ending game now.");
					break;
				}

			}
			
			/*if (i%5==0) {
				NumberUtils.print2DIntArray(p.getArrChecker());
			}*/
			//just for testing purposes, to be able to print arrChecker every 5 times
			//i++;
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
	
	public boolean prizeClaim(Player p, String input) {
		boolean outcome = true;
		boolean claim = true;
		switch (input) {
		case "house":
			outcome = validateHouse(p);
			break;
		case "topline":
			outcome = validateLine(p,0);
			break;
		case "middleline":
			outcome = validateLine(p,1);
			break;
		case "bottomline":
			outcome = validateLine(p,2);
			break;
		case "fourcorners":
			outcome = validateFourCorners(p);
			break;
		case "earlyfive":
			outcome = validateEarlyFive(p);
		}
		if (input.equals("")) {
			System.out.println("Continuing with game");
		} else if (outcome) {
			System.out.println(input + " has been claimed." + input + " correct and gone - (although not gone from system yet, needs work hehe)");
		} else {
			claim = false;
			System.out.println(input + " claim is false. BOGEYYYY!!!");
		}
		return claim;
	}
	
	public boolean validateHouse(Player p) {
		
		int[][] ticket = p.getPlayerTicket();
		int[][] checker = p.getArrChecker();
		
		for (int r=0; r<3; r++) {
			for (int c=0; c<9; c++) {
				if (ticket[r][c]!=0) {
					if (checker[r][c]==0) {
						return false;
					}
					if (!board.contains(ticket[r][c])) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	
	public boolean validateFourCorners(Player p) {
		int [][] ticket = p.getPlayerTicket();
		int [][] checker = p.getArrChecker();
		
		int topLeft = -1;
		int topRight = -1;
		int bottomLeft = -1;
		int bottomRight = -1;
		
		
		//to find topLeft
		for (int i=0; i<ticket[0].length; i++) {
			if (ticket[0][i]!=0) {
				topLeft = i;
				break;
			}
		}
		
		//to find topRight
		for (int i=ticket[0].length-1; i>=0; i--) {
			if (ticket[0][i]!=0) {
				topRight = i;
				break;
			}
		}
		
		//to find bottom left
		for (int i=0; i<ticket[2].length; i++) {
			if (ticket[2][i]!=0) {
				bottomLeft = i;
				break;
			}
		}
		
		//to find bottomRight
		for (int i=ticket[2].length-1; i>=0; i--) {
			if (ticket[2][i]!=0) {
				bottomRight = i;
				break;
			}
		}
		
		//Now that all 4 locations are found, move to validation
		
		//validate topLeft
		
		//check if claimed
		if (checker[0][topLeft]!=1) {
			return false;
		}
		//check if in board
		if (!board.contains(ticket[0][topLeft])) {
			return false;
		}
		
		//validate topRight
		if (checker[0][topRight]!=1) {
			return false;
		}
		//check if in board
		if (!board.contains(ticket[0][topRight])) {
			return false;
		}
		
		//validate bottomLeft
		
		//check if claimed
		if (checker[2][bottomLeft]!=1) {
			return false;
		}
		//check if in board
		if (!board.contains(ticket[2][bottomLeft])) {
			return false;
		}
		
		//validate bottomRight
		
		//check if claimed
		if (checker[2][bottomRight]!=1) {
			return false;
		}
		//check if in board
		if (!board.contains(ticket[2][bottomRight])) {
			return false;
		}
		

		
		return true;
	}
	
	public boolean validateLine(Player p, int line) {
		int[][] ticket = p.getPlayerTicket();
		int[][] checker = p.getArrChecker();
		
		for (int i=0; i<ticket[line].length; i++) {
			if (ticket[line][i]!=0) {
				if (checker[line][i]!=1) {
					return false;
				} if (!board.contains(ticket[line][i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean validateEarlyFive(Player p) {
		int count = 0;
		int[][] ticket = p.getPlayerTicket();
		int[][] checker = p.getArrChecker();
		
		for (int i=0; i<ticket.length; i++) {
			for (int j=0; j<ticket[i].length; j++) {
				
				if (ticket[i][j]!=0) {
					if (checker[i][j]==1 && board.contains(ticket[i][j])) {
						count++;
						if (count>=5) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	
	public Host() {
		// TODO Auto-generated constructor stub
	}

}
