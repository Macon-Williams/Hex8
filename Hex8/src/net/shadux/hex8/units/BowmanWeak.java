package net.shadux.hex8.units;

public class BowmanWeak {
	private int attack = 4;
	private int defense = 4;
	private int move = 4;
	private int range = 3;
	private String name;
	private float health = 4;
	
	BowmanWeak(String name) {
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
	
	public int getRange() {
		return range;
	}
	
	public float getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}
}