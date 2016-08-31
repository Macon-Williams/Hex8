package net.shadux.hex8.units;

public class WarriorWeak {
	private int attack = 2;
	private int defense = 6;
	private int move = 4;
	private String name;
	private float health = 4;
	
	WarriorWeak(String name) {
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