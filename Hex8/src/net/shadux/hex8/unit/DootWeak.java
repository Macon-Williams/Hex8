package net.shadux.hex8.unit;

public class DootWeak {
	private final int MAX_HEALTH = 4;
	private int health = 4;
	private int attack = 2;
	private int defense = 2;
	private int speed = 2;
	private String name;
	
	DootWeak(String name) {
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
