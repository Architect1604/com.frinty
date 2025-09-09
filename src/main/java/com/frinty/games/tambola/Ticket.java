package com.frinty.games.tambola;
import java.util.ArrayList;
import com.frinty.util.NumberUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ticket {
	private static Logger logger = LogManager.getLogger(Ticket.class);
	
	int[][] arrTicket = new int[3][9];
	
	
	//TODO remove later
	public static void main (String[] args) {
		Ticket t = new Ticket();
		
		
		while (t.isColumnEmpty()) {
			t.arrTicket = new int[3][9];
			t.createTicket();
		}
		t.sortTicket();
		t.printTicket();
		
		System.out.println();
		for (int i=0; i<3; i++) {
			logger.info("The number count of line " + i + " is " + t.countNumsInLine(i)); 
		}
		
		/*ArrayList<Integer> nums = t.createSampleList();
		
		t.sortArrayList(nums);
		
		for (int i=0; i<nums.size(); i++) {
			System.out.println("The " + i + "th index is " + nums.get(i));
		}*/
		
		//t.sortTicket();
		//t.createLine();
		/*for (int i=0; i<10; i++) {
			t.printIntArray(t.generatePositions());	
			System.out.println("");
		}*/
		
		//System.out.println(t.isNumInArray(2, arr));
		//System.out.println("Randomly generated number is " + t.generateRandom(10, 20));
	}
	
	public void clearTicket() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<9; j++) {
				arrTicket[i][j]=0;
			}
		}
	}
	
	
	public int[][] createTicket() {
		
		System.out.println("Entered create ticket method");
		
		for (int i=0; i<3; i++) {
			
			System.out.println("####### Creating line "+i + " #########");
			createLine(i);
			System.out.println("@@@@@@@@@ Created line "+i + " @@@@@@@@@");
		}
		
		return arrTicket;
	}
	
	
	//This method generates 9 random numbers, each within the specific range of the tambola ticket column
	//e.g. first number is between 1-9, second between 10-19, etc, last between 80-90
	//They are added to the first row of the 2d array, column by column
	public void firstNine () {
		//Generate 9 numbers randomly in ranges 1-9, 10-19,...
				
				//First, you want a random number between 1 (inclusive) and 10 (exclusive) - or 1 and 9 (inclusive)
				//Then, 10-19
				//Then, 20-29 and so on
				
				
				//random = min + (int) (Math.random()*(max-min)+1);
				
				//random = min + (int) (Math.random()*(9)+1);
				
				//creating for loop of the size 9 to generate those 9 numbers
		
		for (int i=0; i<9; i++) {
			int random;
			
			int min;
			int max;
			
			if(i==0) {
				min = 0;
				max = 9;
			} else if (i==8) {
				min = 79;
				max = 11;
			}
			else {
				min = (i*10)-1;
				max = 10;
			}
			
			random = min + (int) (Math.random()*(max)+1);
			arrTicket [0][i] = random;
			System.out.println("Ticket number "+(i+1) + " is " +random);

				}
				//end of for loop
				
				
				
	}
	
	//This method generates the next 6 numbers for the ticket after the first 9 (one from each column) have been generated
	//These numbers are generated randomly
	//However, the method needs to check whether these numbers previously exist in the array
	//If that is the case, a new (replacement) number needs to be generated
	//The method also needs to check whether each column already has 3 numbers in it
	//If that is the case, a new (replacement) number needs to be generated, but outside the range of the column of the previous number
	public void nextSix() {
		//Step 1: Generate 6 random numbers within range 1-90
		System.out.println("Entered NextSix");
		for (int i=0; i<6; i++) {
			int random;
			
			int max=90;
			
			random = (int) (Math.random()*(max)+1);
			System.out.println("Random number is " + random);
			
			//Consider floordiv e.g. 69 -- 6th column etc
			int colNum;
			
			//setting colNum to 8 at 90 as well for ease so that 80-90 is all covered in same range in for loop
			if (random==90) {
				colNum=8;
			} else {
				colNum = Math.floorDiv(random, 10);	
			}
			
			//System.out.println(colNum);
			
			
			//need to iterate array to fill it
			//if colNum is 0, move "random" to arrTicket [][]
			//check if empty
			
			for (int j=0; j<2; j++) {
				for (int k=0; k<9; k++) {
					if (colNum==k) {
						
						System.out.println("Current arrTicket is " + arrTicket[j][k]);
					
						//check if it is empty
						if (arrTicket[j][k]==0) {
							arrTicket[j][k] = random;
						} else if (j+1<3){
							arrTicket[j+1][k] = random;
						}
						
						
						
						System.out.println("New is " + random);
					}
				}
			}
			
			
		}
		
		//Step 2: Add number to array by checking which column they belong in
		//Step 3: Validation #1: Check if numbers exist in array
		//Step 4: If yes, re-generate a different number
		//Step 5: Validation #2: Check if column already has 3
		//Step 6: If yes, re-generate a different number in a different column
		//Step 7: Validation #3: Does line have 5?
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
		System.out.println("Pos in generateNumInLine is " + pos);
		Ticket t = new Ticket();
		int num = 0;
		
		/*
		switch (pos) {
			case 1:
				num = t.generateRandom(1, 9);
				break;
			case 2:
				num = t.generateRandom(10,20);
				break;
			case 3:
				num = t.generateRandom(20, 29);
				break;
			case 4:
				num = t.generateRandom(30, 39);
				break;
			case 5:
				num = t.generateRandom(40, 49);
				break;
			case 6:
				num = t.generateRandom(50, 59);
				break;
			case 7:
				num = t.generateRandom(60, 69);
				break;
			case 8:
				num = t.generateRandom(70, 79);
				break;
			case 9:
				num = t.generateRandom(80, 90);
				break;
		}*/
		
		switch (pos) {
		case 0:
			num = NumberUtils.generateRandom(0,9);
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
		System.out.println("Num is " + num);
		System.out.println("Column is " + column);
		boolean isNumInColumn = false;
		for (int i=0; i<3; i++) {
			if (num == arrTicket[i][column]) { 
				System.out.println("The number is in the column");
				isNumInColumn = true;
				break;
			} else {
				System.out.println("The number is NOT in the column");
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
		System.out.println("isUnique(): the number " + num + " in column " + column + " is unique:"+isUnique);
		return isUnique;
	}
	
	public void createLine(int l) {
		//System.out.println("Entered createLine method");
		
		Ticket t = new Ticket();
		int num = 0;
		int[] positions = generatePositions();
		
		System.out.println("Positions from position array are:");
		NumberUtils.printIntArray(positions);
		int f=0;
		int numsinticket=0;
		for (int i=0; i<positions.length; i++) {

			//generate number
			num = t.generateNumInLine(positions[i]);
			System.out.println("In for loop for the positions[i]=" +positions[i] + ", generated num="+num+ " forcount="+f++);

			//int w=0;
			while (!isUnique(num, positions[i])) {
				//System.out.println("In while loop"+ w++); 
				//if(w==100) {break;}
				num = t.generateNumInLine(positions[i]);
				System.out.println("The number generated for the line is " + num);
			}
			
			System.out.println("setting the actual value of the array index as num " + num + " numsinticket="+numsinticket);
			arrTicket[l][positions[i]] = num;	
			numsinticket++;
			
			if (numsinticket == 5) {
				System.out.println("\n\n****************************\n\n");
			}
			
			
			//generate random number in range
			//val
			//while (!isUnique) {
			
		}
		
		//create array for line
		
		/*
		for (int i=0; i<5; i++) {
			switch (positions[i]) {
			case 1:
				t.generateRandom(1, 9);
			case 2:
				t.generateRandom(10,19);
			case 3:
				t.generateRandom(20, 29);
			case 4:
				t.generateRandom(30, 39);
			case 5:
				t.generateRandom(40, 49);
			case 6:
				t.generateRandom(50, 59);
			case 7:
				t.generateRandom(60, 69);
			case 8:
				t.generateRandom(70, 79);
			case 9:
				t.generateRandom(80, 90);
			}
		}*/
		
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
	
	//This method populates a single line (at the moment) of the tambola ticket
	//It selects 5 out of 9 possible positions in the line
	//Then it generates 5 random numbers to place in these positions
	//Each number corresponds to the column number it is in (using FloorDiv)
	public void createLine2() {
		
		//Step 1: Select positions (out of 9 possible spaces)
		//To do this, generate 5 random numbers between 0 and 8 (or 1 and 9)
		boolean repeat = true;
		int[] position = new int[5];
		
		
		for (int i=0; i<5; i++) {
			int randomPos = 0;
			
			int min = -1;
			int max = 9;
			
			randomPos = min + (int) (Math.random()*(max)+1);
			System.out.println("initial number is "+randomPos);
			
			
			for (int j=0; j<5; j++) {
				if (randomPos==position[j]) {
					repeat = true;
					continue;
				}
			}
			System.out.println(repeat);
			if (repeat==false) {
				position[i] = randomPos;
			}
			System.out.println("Position is " + position[i]);
		
		/*
		for (int i=0; i<5; i++ ) {
			
			while (repeat) {
				//repeat = false;
				int randomPos = 0;
				
				int min = -1;
				int max = 9;
				
				randomPos = min + (int) (Math.random()*(max)+1);
				System.out.println("initial number is "+randomPos);
				
				for (int j=0; j<5; j++) {
					if (randomPos==position[j]) {
						repeat = true;
						continue;
					} else {
						repeat = false;
					}
				}
			}*/
			
			
			
			/*
			while (repeat = false) {
				randomPos = min + (int) (Math.random()*(max)+1);
				
				for (int j=0; j<5; j++) {
					if (randomPos == position[j]) {
						repeat = true;
					}
				}
			}*/
			
			
			//random = (int) (Math.random()*(max)+1);
	
			//System.out.println("Random position is " + randomPos);
		
		//Step 2: Use the number and do floordiv to decide where the number goes
		//Store step 2 result as a potential variable, and use the result to populate ticket
		
		//Step 3: Generate random numbers based on the parameters of the column as defined in step 2
		}
	}
	
	
	
	public void sortTicket() {
		Ticket t = new Ticket();
		
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
	
	public void sortTicket2() {
		Ticket t = new Ticket();
		for (int i=0; i<9; i++) {
			int colCount = 0;
			for (int j=0; j<3; j++) {
				if (arrTicket[j][i]!=0) {
					colCount++;
				}
				//System.out.println("In i value " + i+ " and j value " + j + "Column count is " +colCount);	
			}
			
			if (colCount==1) {
				continue;
			} else {
				
				ArrayList<Integer> rowPositions = new ArrayList<Integer>();
				ArrayList<Integer> nums = new ArrayList<Integer>();
				
				for (int j=0; j<3; j++) {
					
					if (arrTicket[j][i]==0) {
						//j++;
						continue;
					} else {
						rowPositions.add(j);
						nums.add(arrTicket[j][i]);
					}
				}
				
				nums = NumberUtils.sortArrayList(nums);
				for (int j=0; j<nums.size(); j++) {
					arrTicket[rowPositions.get(j)][i] = nums.get(j);
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
