package com.gamingroom;

/**
 * A simple class to hold the top level information of each GameService entity
 * 
 * @author nolan.pratt@snhu.edu
 * 
 */


public class Entity {

	private long id;
	private String name;
	
	// Private constructor limits external creation of blank objects
	private Entity() {
		
	}
	
	// Constructor
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Returns the entity's id
	public long getId() {
		return id;
	}
	
	// Returns the entity's name
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
