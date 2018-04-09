/**
 * 
 */
package consolidation;

import java.util.ArrayList;
import java.util.List;

import tools.CheckGrid;
import tools.Grid;
import tools.PlayersGrid;
import tools.Scan;

/**
 * @author Frederick
 *
 *         class to play at TicTacToe
 */
public class TicTacToe {
	private static int userChoice; // attribute to save the user choice about main menu

	/**
	 * method to manage the party of the game
	 * 
	 * @param grid
	 * @param players
	 */
	private static void playGame(Grid grid, List<PlayersGrid> players) {
		int choice = -1; // variable to manage the user choice about game menu
		do {
			// display the scores before restart for a new game
			if (choice == 2) {
				for (PlayersGrid player : players) {
					System.out.println(player);
					player.setScore(0);
				}
				System.out.println("Now it's a new game and the scores have been reset.");
			}
			// Reset the grid for a new game or replay
			if (choice == 1 || choice == 2) {
				for (int i = 0; i != grid.getGrid().length; i++) {
					for (int j = 0; j != grid.getGrid()[i].length; j++) {
						grid.getGrid()[i][j] = null;
					}
				}
			}
			String winPlayer = gamePlay(grid, players); // play the game until you have a winner or match null
			grid.displayGrid(grid.getGrid()); // display the grid when the game is finished
			System.out.println("this part is finished.");
			// display the result of the game
			if (winPlayer.equals("")) {
				System.out.println("Match null !");
			} else {
				System.out.println("The winner is " + winPlayer + " !");
			}
			choice = simpleGameMenu(); // display the simple game menu
		} while (choice == 1 || choice == 2); // choice 1= replay and choice 2= restart a game
		// to display the final result (score by player)
		for (PlayersGrid player : players) {
			System.out.println(player);
		}
	}

	/**
	 * method to display the simple game menu after have finished a game
	 * 
	 * @return
	 */
	private static int simpleGameMenu() {
		int choice = -1;
		while (choice == -1) {
			System.out.println("What do you want to do ?");
			System.out.println("1 - Replay the game.");
			System.out.println("2 - Restart the game.");
			System.out.println("3 - Back to the main menu.");
			System.out.println("0 - Quit the game.");
			choice = Scan.userInputIntPositive("your choice : ");
			if (choice > 3) {
				System.err.println("Your choice is not correct, please try again.");
				choice = -1;
			}
			if (choice == 0) {
				userChoice = 0;
				System.out.println("Thank you and goodbye !");
			}
		}
		return choice;
	}

	/**
	 * method for managing game turns until you have a winner or more possible play
	 * 
	 * @param grid
	 * @param players
	 * @return
	 */
	private static String gamePlay(Grid grid, List<PlayersGrid> players) {
		boolean finishedGame = false;
		String winPlayer = "";
		for (int i = 0; i != players.size() && !finishedGame; i++) {
			grid.displayGrid(grid.getGrid()); // display the grid
			int playerBox = selectBox(grid, players, i); // ask the user choice to play and check it
			saveChoiceBox(grid, players, i, playerBox); // save the user play when it's ok
			// check if there is a winner or if it's possible to play again
			if (CheckGrid.checkGridLineOK(grid.getGrid(), players.get(i).getSign())) {
				winPlayer = players.get(i).getName();
				players.get(i).setScore(players.get(i).getScore() + 1);
				finishedGame = true;
			}
			if (CheckGrid.checkGridIsComplete(grid.getGrid())) {
				finishedGame = true;
			}
			// restart the players list when they all played once.
			if (i == (players.size() - 1)) {
				i = -1;
			}
		}
		return winPlayer;
	}

	/**
	 * method to check the user choice of box
	 * 
	 * @param grid
	 * @param players
	 * @param indexPlayer
	 * @return
	 */
	private static int selectBox(Grid grid, List<PlayersGrid> players, int indexPlayer) {
		int playerBox = -1;
		boolean box = false;
		while (!box) {
			playerBox = Scan.userInputIntPositiveWithout0(
					players.get(indexPlayer).getName() + " which box do you want to play ?");
			if (playerBox > grid.getNbTotalBoxes()) {
				System.err.println("Your choice is not a possible box in your grid.");
			} else {
				if (!CheckGrid.checkGridBoxIsFree(grid.getGrid(), grid.getCoordY(playerBox),
						grid.getCoordX(playerBox))) {
					System.out.println("Your box has been played, please choose another.");
				} else {
					box = true;
				}
			}
		}
		return playerBox;
	}

	/**
	 * method to save the user play
	 * 
	 * @param grid
	 * @param players
	 * @param indexPlayer
	 * @param playerBox
	 */
	private static void saveChoiceBox(Grid grid, List<PlayersGrid> players, int indexPlayer, int playerBox) {
		String[][] tempGrid = grid.getGrid();
		tempGrid[grid.getCoordY(playerBox)][grid.getCoordX(playerBox)] = Character
				.toString(players.get(indexPlayer).getSign());
		grid.setGrid(tempGrid);
	}

	/**
	 * @param args
	 * 
	 *            main body to start the game
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the game TicTacToe");
		System.out.println("the first who draws a line (horizontal, vertical, or diagonally) wins");
		// int userChoice = -1;
		do {
			System.out.println("What do you want to play ?");
			System.out.println("1 - Play the classic version.");
			System.out.println("0 - Quit the game.");
			userChoice = Scan.userInputIntPositive("Your choice : ");
			switch (userChoice) {
			case 1:
				// the classic version is played by 2 players with a grid of 3 boxes wide
				List<PlayersGrid> playersList = new ArrayList<>();
				playersList.add(new PlayersGrid("player 1", 'X')); // initialisation of first player
				playersList.add(new PlayersGrid("player 2", 'O')); // initialisation of second player
				Grid grid = new Grid(3); // initialisation of the grid
				playGame(grid, playersList);
				break;
			case 0:
				System.out.println("Thank you and goodbye !");
				break;
			default:
				System.err.println("Your choice is not possible, please try again.");
				break;
			}
		} while (userChoice != 0);
	}

}
