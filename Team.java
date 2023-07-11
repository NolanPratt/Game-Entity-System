package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * 
 * @author nolan.pratt@snhu.edu
 * 
 */
public class Team extends Entity{

	// Private player roster
	private List<Player> players = new ArrayList<Player>();
	
	// Constructor inherited from Entity class
	public Team(long id, String name) {
		super(id, name);
	}

	// Adds player to the active roster
	public Player addPlayer(String name) {
		
		// Return the entered name if the team already exists
		for (Player player : players) {
			if (player.getName().equals(name)) {
				System.out.println("Player name unavailable: " + player);
				return player;
			}
		}
		
		// Access service instance for updating team roster
		GameService service = GameService.getInstance();
		// Create and append the new team to the game service
		Player newPlayer = new Player(service.getNextPlayerId(), name);
		players.add(newPlayer);
		//Return the new team if the team does not exist
		return newPlayer;
	}
	
	// Returns the desired player object based on the name
	public Player getPlayer(String name) {
		for(Player existingPlayer : players) {
			// Return the team if the name is found
			if (existingPlayer.getName().equals(name)) {
				return existingPlayer;
			}
		}
		
		// If the player does not exist, add it to the referenced team
		System.out.println(name + " does not exist. Adding to roster...");
		Player newPlayer = addPlayer(name);
		return newPlayer;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
