package net.shadux.hex8.units;

public class WarriorStrong {
	private int attack = 4;
	private int defense = 8;
	private int move = 4;
	private String name;
	private float health = 6;
	
	WarriorStrong(String name) {
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