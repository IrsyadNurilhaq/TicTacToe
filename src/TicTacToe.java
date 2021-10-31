import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		 char[][] board = {
		            {' ', '|', ' ', '|', ' '},
		            {'-', '+', '-', '+', '-'},
		            {' ', '|', ' ', '|', ' '},
		            {'-', '+', '-', '+', '-'},
		            {' ', '|', ' ', '|', ' '},
		        };
		        
		        printBoard(board);
		        		        
		        while(true) {
		        	Scanner scan = new Scanner(System.in);
		        	System.out.println(" Masukkan posisi anda (1-9): ");
			        int playerPosition = scan.nextInt();
			        
			        while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
			        	System.out.println("Posisi ini sudah terisi, coba posisi lain");
			        	playerPosition = scan.nextInt();
			        }
			   
			        placePiece(board, playerPosition, "people");
			        String result = findWinner();
			        if(result.length() > 0) {
			        	System.out.println(result);
			        	break;
			        }
			        
			        Random rand = new Random();
			        int computerPosition = rand.nextInt(9) + 1;
			        while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
			        	System.out.println("Posisi ini sudah terisi, coba posisi lain");
			        	computerPosition = rand.nextInt(9) + 1;
			        }
			        placePiece(board, computerPosition, "computer");
			        
			        printBoard(board);
			        
			        result = findWinner();
			        if(result.length() > 0) {
			        	System.out.println(result);
			        	break;
			        }
		        }
		        
		       
	}
	
	public static void printBoard(char[][] board){
       for(char[] row : board){
          for(char c : row){
              System.out.print(c);
          }
          System.out.println();
      }
	}
	
	public static void placePiece(char[][] board, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("people")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if(user.equals("computer")) {
			symbol = 'O';
			computerPositions.add(pos);
		} 
		
		switch(pos){
	        case 1:
	            board[0][0] = symbol;
	            break;
	        case 2:
	            board[0][2] = symbol;
	            break;
	        case 3:
	            board[0][4] = symbol;
	            break;
	        case 4:
	            board[2][0] = symbol;
	            break;
	        case 5:
	            board[2][2] = symbol;
	            break;
	        case 6:
	            board[2][4] = symbol;
	            break;
	        case 7:
	            board[4][0] = symbol;
	            break;
	        case 8:
	            board[4][2] = symbol;
	            break;
	        case 9:
	            board[4][4] = symbol;
	            break;
	         default:
	        	break;
	    }
		
	}
	
	public static String findWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 9);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerPositions.containsAll(l)) {
				return "Yeay kamu menang!";
			} else if(computerPositions.containsAll(l)) {
				return "Anda kalah :(";
			} else if(playerPositions.size() + computerPositions.size() == 9) {
				return "SERI !";
			}
			
		}
		
		
		return "";
	}

}
