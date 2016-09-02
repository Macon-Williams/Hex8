package net.shadux.hex8.unit;

public class CrazyEight {
	private int attack = 8;
	private int defense = 8;
	private int speed = 4;
	private float health = 8;
	private String name;
	
	CrazyEight(String name) {
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
		return speed;
	}
	
	public float getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}

}
