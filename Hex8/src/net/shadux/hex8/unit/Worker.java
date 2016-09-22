package net.shadux.hex8.unit;

public class Worker {
	private final int MAX_HEALTH = 4;
	private int health = 4;
	private int build = 2;
	private int repair = 2;
	private String name;
	
	Worker(String name) {
		this.name = name;
	}
	
	public void setHealth(int mod) {
		if (health + mod <= MAX_HEALTH) {
			health = health + mod;
		}
		else {
			health = MAX_HEALTH;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getBuild() {
		return build;
	}
	
	public int getRepair() {
		return repair;
	}
	
	public String getName() {
		return name;
	}
 
}
