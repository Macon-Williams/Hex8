package net.shadux.hex8.unit;

public class FighterStrong {
	private final int MAX_HEALTH = 6;
	private int health = 6;
	private int attack = 6;
	private int defense = 6;
	private int speed = 3;
	private String name;
	
	FighterStrong(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int mod) {
		if (health + mod <= MAX_HEALTH) {
			health = health + mod;
		}
		else {
			health = MAX_HEALTH;
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int mod) {
		attack = attack + mod;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int mod) {
		defense = defense + mod;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int mod) {
		speed = speed + mod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
