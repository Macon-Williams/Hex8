package net.shadux.hex8.units;

public class KnightHorse {
	private int attack = 6;
	private int defense = 10;
	private int move = 10;
	private String name;
	private float health = 6;
	
	KnightHorse(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHealth(float health) {
		this.health = health;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getMove() {
		return move;
	}
	
	public float getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}

}
