package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * @author nolan.pratt@snhu.edu
 *
 */
public class Game extends Entity {
	
	// Private list of active team roster
	private List<Team> teams = new ArrayList<Team>();

	// Constructor inherited from Entity class
	public Game(long id, String name) {
		super(id, name);
	}
	
	// Adds the team to the active game
	public Team addTeam(String name) {
		
		// Return the entered name if the team already exists
		for (Team team : teams) {
			if (team.getName().equals(name)) {
				System.out.println("Team name unavailable: " + team);
				return team;
			}
		}
		
		// Access service instance for updating team roster
		GameService service = GameService.getInstance();
		// Create and append the new team to the game service
		Team newTeam = new Team(service.getNextTeamId(), name);
		teams.add(newTeam);
		//Return the new team if the team does not exist
		return newTeam;
	}
	
	// Returns the desired team object based on the name
	public Team getTeam(String name) {
		for(Team existingTeam : teams) {
			// Return the team if the name is found
			if (existingTeam.getName().equals(name)) {
				return existingTeam;
			}
		}
		
		// If the team does not exist, add it to the referenced game
		System.out.println(name + " does not exist. Adding to roster...");
		Team newTeam = addTeam(name);
		return newTeam;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}
}
