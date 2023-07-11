package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author nolan.pratt@snhu.edu
 * 
 */
public class GameService {


	// List of the active games
	private List<Game> games = new ArrayList<Game>();

	// Holds the next Id number for discerning games within the service
	private long nextGameId = 1;
	private long nextTeamId = 0;
	private long nextPlayerId = 0;


	// Create a private static instance of the GameService
	private static GameService instance;
	
	// Create a private constructor to prevent other classes from creating an instance of this class
	private GameService() {
	}

	// Returns the Singleton instance of the GameService object
	public static synchronized GameService getInstance() {
		if (instance == null) {
			instance = new GameService();
		}
		return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		for (Game existingGame : games) {
			if (existingGame.getName().equals(name)) {
				System.out.println("Game name unavailable: " + existingGame);
				return existingGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		game = new Game(nextGameId++, name);
		games.add(game);

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * **Scope is package/local for testing purposes**
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	public Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for (Game existingGame : games) {
			if (existingGame.getId() == id) {
				game = existingGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		for (Game existingGame : games) {
			if (existingGame.getName().equals(name)) {
				game = existingGame;
				break;
			}
		}

		return game;
	}


	// Returns the number of games currently active
	public int getGameCount() {
		return games.size();
	}
	
	// Returns the next team identifier and increments the current id
	public long getNextTeamId() {
		nextTeamId++;
		return nextTeamId;
	}
	
	// Returns the next player identifier and increments the current id
	public long getNextPlayerId() {
		nextPlayerId++;
		return nextPlayerId;
	}
}
