package gameData.Items.Weapons;

import gameData.Items.Item;

public abstract class Weapon extends Item {
	
	// Should durability be a feature?
	private int minDmg, maxDmg;
	
	public Weapon(int minDmg_, int maxDmg_) {
		super();
		this.minDmg = minDmg_;
		this.maxDmg = maxDmg_;
	}
	
	public int getMinDmg() {
		return this.minDmg;
	}
	
	public int getMaxDmg() {
		return this.maxDmg;
	}
	
	public String toString() {
		return this.getName() 
		+ "\n---------------" 
		+ "\n" + this.getDesc();
	}
}
