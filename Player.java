package com.gamingroom;

/**
 * A simple class to hold information about a player
 * 
 * @author nolan.pratt@snhu.edu
 *
 */
public class Player extends Entity{

	// Constructor inherited from Entity class
	public Player(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}
