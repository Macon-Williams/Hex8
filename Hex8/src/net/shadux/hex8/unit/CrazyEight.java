package net.shadux.hex8.unit;

public class CrazyEight {
	private final int MAX_HEALTH = 8;
	private int attack = 8;
	private int defense = 8;
	private int speed = 4;
	private int health = 8;
	private String name;
	
	CrazyEight(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHealth(int mod) {
		if (health + mod <= MAX_HEALTH) {
			health = mod;
		}
		else {
			health = MAX_HEALTH;
		}
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getMove() {
		return speed;
	}
	
	public float getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}

}
