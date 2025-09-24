package com.frinty.games.tambola;
import java.util.ArrayList;
import com.frinty.util.NumberUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ticket {
	private static Logger logger = LogManager.getLogger(Ticket.class);
	
	int[][] arrTicket = new int[3][9];
	
	
	public static void main (String[] args) {
		Ticket t = new Ticket();
		
		t.createTicket();
	}
	
	public int[][] createTicket() {
		//Ticket t = new Ticket();
		
		
		while (isColumnEmpty()) {
			this.arrTicket = new int[3][9];
			populateTicket();
		}
		sortTicket();
		printTicket();
		System.out.println();
		return this.arrTicket;
	}
	
	public int[][] populateTicket() {
		
		//System.out.println("Entered create ticket method");
		
		for (int i=0; i<3; i++) {
			
			//System.out.println("####### Creating line "+i + " #########");
			createLine(i);
			//System.out.println("@@@@@@@@@ Created line "+i + " @@@@@@@@@");
		}
		
		return this.arrTicket;
	}
	
	
	//This method has been moved to NumberUtils.java class in com.frinty.util package
	/*
	public boolean isNumInArray (int num, int[] arr) {
		boolean check = false;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]==num) {
				check = true;
				break;
			}
		}
 		
		return check;
	}*/
	
	
	public int [] generatePositions() {
		int[] positions = new int [5];
		for (int i=0; i<5; i++) {
			positions[i] = -1;
		}
		
		
		int randomNum = 0;
		
		
		int i = 0;
		
		while (i<5) {
			//NumberUtils.generateRandom(0,8);
			randomNum = NumberUtils.generateRandom(0,8);
			if (NumberUtils.isNumInArray(randomNum,positions)) {
				continue;
			} else {
				positions [i] = randomNum;
				i++;
			}
			
		}
			
		return positions;
	}
	
	
	public int generateNumInLine (int pos) {
		//System.out.println("Pos in generateNumInLine is " + pos);
		//Ticket t = new Ticket();
		int num = 0;
		
		switch (pos) {
		case 0:
			num = NumberUtils.generateRandom(1,9);
			break;
		case 1:
			num = NumberUtils.generateRandom(10,19);
			break;
		case 2:
			num = NumberUtils.generateRandom(20,29);
			break;
		case 3:
			num = NumberUtils.generateRandom(30,39);
			break;
		case 4:
			num = NumberUtils.generateRandom(40,49);
			break;
		case 5:
			num = NumberUtils.generateRandom(50,59);
			break;
		case 6:
			num = NumberUtils.generateRandom(60,69);
			break;
		case 7:
			num = NumberUtils.generateRandom(70,79);
			break;
		case 8:
			num = NumberUtils.generateRandom(80,90);
			break;
	}
		
		//System.out.println("Number generated for line is " + num);
		
		return num;
	}
	
	public boolean isNumInColumn (int num, int column) {
		//System.out.println("Num is " + num);
		//System.out.println("Column is " + column);
		boolean isNumInColumn = false;
		for (int i=0; i<3; i++) {
			if (num == arrTicket[i][column]) { 
				//System.out.println("The number is in the column");
				isNumInColumn = true;
				break;
			} else {
				//System.out.println("The number is NOT in the column");
				isNumInColumn = false;
			}
		}

		return isNumInColumn;
	}
	
	public boolean isUnique (int num, int column) {
		boolean isUnique = true;
		
		for (int i=0; i<3; i++) {
			//System.out.println("arrTicket[i][column]="+arrTicket[i][column]);
			
			if (num == arrTicket[i][column]) {
				isUnique = false;
				break;
			} else {
				isUnique = true;
			}
		}
		//System.out.println("isUnique(): the number " + num + " in column " + column + " is unique:"+isUnique);
		return isUnique;
	}
	
	public void createLine(int l) {
		//System.out.println("Entered createLine method");
		
		//Ticket t = new Ticket();
		int num = 0;
		int[] positions = generatePositions();
		
		//System.out.println("Positions from position array are:");
		//NumberUtils.printIntArray(positions);
		//int f=0;
		int numsinticket=0;
		for (int i=0; i<positions.length; i++) {

			//generate number
			num = this.generateNumInLine(positions[i]);
			//System.out.println("In for loop for the positions[i]=" +positions[i] + ", generated num="+num+ " forcount="+f++);

			//int w=0;
			while (!isUnique(num, positions[i])) {
				//System.out.println("In while loop"+ w++); 
				//if(w==100) {break;}
				num = this.generateNumInLine(positions[i]);
				//System.out.println("The number generated for the line is " + num);
			}
			
			//System.out.println("setting the actual value of the array index as num " + num + " numsinticket="+numsinticket);
			arrTicket[l][positions[i]] = num;	
			numsinticket++;
		}
		
	}
	
	
	public boolean isColumnEmpty () {
		boolean isColumnEmpty = false;
		for (int i=0; i<9; i++) {
			
			if (arrTicket[0][i]==0 && arrTicket[1][i]==0 && arrTicket[2][i]==0) {
				isColumnEmpty = true;
			}
			
		}
		
		return isColumnEmpty;
	}
	
	
	public int countNumsInLine (int l) {
		int numsInLine = 0;
		
		for (int i=0; i<9; i++) {
			if (arrTicket[l][i]!=0) {
				numsInLine++;
			}
		}
		
		
		return numsInLine;
	}
	
	//This method has been moved to NumberUtils.java class in com.frinty.util package
	/*
	public void printIntArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}*/
	
	
	public void sortTicket() {
		//Ticket t = new Ticket();
		
		for (int col=0; col<9; col++) {
			ArrayList<Integer> rowPositions = new ArrayList<Integer>();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			
			for (int row = 0; row<3; row++) {
				if (arrTicket[row][col]!=0) {
					rowPositions.add(row);
					nums.add(arrTicket[row][col]);
				}
			}
			if (nums.size()>1) {
				NumberUtils.sortArrayList(nums);
				
				for (int k = 0; k<rowPositions.size(); k++) {
					arrTicket[rowPositions.get(k)][col] = nums.get(k);
				}
			}
			
		}
	}
	
	
	
	
	/*public ArrayList<Integer> createSampleList() {
	    ArrayList<Integer> nums = new ArrayList<>();

	    // Add 50 single-digit numbers, jumbled
	    nums.add(7); nums.add(3); nums.add(9); nums.add(1); nums.add(5);
	    nums.add(2); nums.add(8); nums.add(6); nums.add(4); nums.add(0);
	    nums.add(9); nums.add(2); nums.add(7); nums.add(1); nums.add(3);
	    nums.add(6); nums.add(5); nums.add(8); nums.add(0); nums.add(4);
	    nums.add(1); nums.add(9); nums.add(7); nums.add(6); nums.add(2);
	    nums.add(5); nums.add(8); nums.add(4); nums.add(3); nums.add(0);
	    nums.add(7); nums.add(2); nums.add(6); nums.add(1); nums.add(9);
	    nums.add(8); nums.add(4); nums.add(5); nums.add(3); nums.add(0);
	    nums.add(6); nums.add(9); nums.add(2); nums.add(7); nums.add(1);
	    nums.add(8); nums.add(5); nums.add(0); nums.add(4); nums.add(3);

	    return nums;
	}*/
	
	//This method has been moved to NumberUtils.java class in com.frinty.util package
	//this method sorts using (efficient) bubble sort
	/*public ArrayList<Integer> sortArrayList (ArrayList<Integer> arrayList) {
		boolean sorted = false;
		int n = arrayList.size();
		
		while (!sorted) {
			sorted = true;
			
			for (int i=0; i<n-1; i++) {
				
				if (arrayList.get(i)>arrayList.get(i+1)) {
					
					//sort
					int temp = -1;
					temp = arrayList.get(i);
					arrayList.set(i, arrayList.get(i+1));
					arrayList.set(i+1, temp);	
					sorted = false;
				}
				
			}
			n--;
		}
		
		
		return arrayList;
	}*/

	
	//This method generates a random integer number between the specified range
	//The range is defined through the parameters lower and higher (inclusive)
	//Moved to NumberUtils class (under package com.frinty.util)
	/*
	public int generateRandom(int lower, int higher) {
		int randomNum=0;
		//System.out.println("Lower is " + lower);
		//System.out.println("Higher is " + higher);
		randomNum = lower + (int) (Math.random()*(higher-lower+1));
		
		return randomNum;
	}*/
	
	//This method is constructed and finished, for now
	public void printTicket() {
		System.out.println("Ticket is: ");
		
		//checked, correct
		for (int i=0; i<46; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				
				//second attempt, not in use
				/*
				if (j==8) {
					if (arrTicket[i][j]==0) {
						System.out.print("  "+" |");
					} else if (arrTicket[i][j]<10) {
						System.out.print("0"+arrTicket[i][j]+" |");
					} else {
						System.out.print(arrTicket[i][j]+" |");
					}
				} else if (j==0) {
					if (arrTicket[i][j]==0) {
						System.out.print("| "+"  ");
					} else if (arrTicket[i][j]<10) {
						System.out.print("| "+"0"+arrTicket[i][j]+" | ");
					} 
					else {
						System.out.print("| "+arrTicket[i][j]+" | ");
					}
				} else {
					if (arrTicket[i][j]==0) {
						System.out.println(" " + " | ");
					} else if (arrTicket[i][j]<10) {
						System.out.print("0"+arrTicket[i][j]+" | ");
					} else {
						System.out.print(arrTicket[i][j]+" | ");
					}
				}*/
				
				
				
				//third attempt
				
				if (j==0) {
					if (arrTicket[i][j]==0) {
						System.out.print("| "+"  " + " | ");
					} else if (arrTicket[i][j]<10) {
						System.out.print("| "+"0" + arrTicket[i][j] + " | ");
					}
				} else {
					if (arrTicket[i][j]==0) {
						System.out.print("  " + " | ");
					} else {
						System.out.print(arrTicket[i][j]+" | ");
					}
				}
				
				/*
				if (j==0) {
					if (arrTicket[i][j]==0) {
						System.out.print("| " + "  ");
					}
				}*/
				
				// first attempt, originally (somewhat) functional version (to copy/steal from)
				/*
				if (j==8) {
					if (arrTicket[i][j]<10) {
						System.out.print("0"+arrTicket[i][j]+" |");	
					} else if (arrTicket[i][j]==0) {
						System.out.print("  "+" |");	
					}
					else {
						System.out.print(arrTicket[i][j]+" |");
					}
				} else if (j==0) {
					if (arrTicket[i][j]<10) {
						System.out.print("| "+"0"+arrTicket[i][j]+" | ");
					} 
					else {
						System.out.print("| "+arrTicket[i][j]+" | ");
					}
				}
				
				else {
					if (arrTicket[i][j]<10) {
						System.out.print("0"+arrTicket[i][j]+" | ");
					} else {
						System.out.print(arrTicket[i][j]+" | ");
					}
				}*/
			}
			System.out.println("");
		}
		for (int i=0; i<46; i++) {
			System.out.print("-");
		}
	}
	
	public Ticket() {
		
		
	}

}
