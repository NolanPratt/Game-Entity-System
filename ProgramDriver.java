package com.gamingroom;

import java.util.Random;

/**
 * Application start-up program
 * 
 * @author nolan.pratt@snhu.edu
 * 
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Obtain local reference to the singleton instance
		GameService service = GameService.getInstance();
		
		System.out.println("\nInitializing game data...\n");
		
		// Initialize random number generator
		Random rand = new Random();
		
		// Initialize 10 games with random number of teams and players
		for (int i = 1; i <= 3; i++) {
			Game newGame = service.addGame("Game #" + i);
			System.out.println("Game #" + i);
			
			// Print out the header to showcase active teams within the game
			System.out.println("Teams:");
			
			// Add teams to the games
			for (int j = 1; j <= 2 /* rand.nextInt(20) + 8 */; j++) {
				Team newTeam = newGame.addTeam("Team #" + j);
				System.out.println("\n" + newTeam);
				
				// Print out the header to showcase active players within the team
				System.out.println("Players:");
				
				// Add players to the teams
				for (int k = 1; k <= 2/* rand.nextInt(8) + 5 */; k++) {
					Player newPlayer = newTeam.addPlayer("Player #" + k);
					System.out.println(newPlayer);
				}
			}
			// Divider for each game
			System.out.println("\n+-----------------------------+\n");
		}
		
		System.out.println("\nTesting existing entities...\n");
		
		// Testing existing entity assignment indexing
		System.out.println(service.getGame("Game #2"));
		System.out.println(service.getGame("Game #1").getTeam("Team #1"));
		System.out.println(service.getGame("Game #1").getTeam("Team #2").getPlayer("Player #1"));

		System.out.println("\nTesting entity additions...\n");
		
		// Testing existing entity assignments against new additions
		service.addGame("Game #1");
		service.getGame("Game #1").addTeam("Team #1");
		service.getGame("Game #1").getTeam("Team #1").addPlayer("Player #1");
		service.getGame("Game #1").getTeam("Team #1").addPlayer("Player #3");
		System.out.println(service.getGame("Game #1").getTeam("Team #3"));
		System.out.println(service.getGame("Game #1").getTeam("Team #3").getPlayer("Player #1"));
		System.out.println(service.getGame("Game #1").getTeam("Team #1").getPlayer("Player #3"));

		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
