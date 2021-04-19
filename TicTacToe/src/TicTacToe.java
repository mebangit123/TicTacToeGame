import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		System.out.println("Tic Tac Toe Game");
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
						
		printBoard(gameBoard);
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your Placement: (1-9)");
			int playerPos = sc.nextInt();
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
				System.out.println("Position taken! Enter a correct Position");
				playerPos = sc.nextInt();
			}
			
			placePiece(gameBoard,playerPos,"player");
			printBoard(gameBoard);
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) +1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				cpuPos = sc.nextInt();
			}
			placePiece(gameBoard,cpuPos,"cpu");
			printBoard(gameBoard);	
		}
		
	}
	public static void printBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
		
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		}
		else if(user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos){
			case 1:
				gameBoard[0][0] = symbol;
				
				break;	
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
	}
}