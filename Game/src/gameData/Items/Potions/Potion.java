package gameData.Items.Potions;

import gameData.Items.Item;

public abstract class Potion extends Item {

	protected int currDose;
	private final int DOSES;

	public Potion() {
		super();
		this.currDose = 3;
		this.DOSES = 3;
	}

	public int getCurrDose() {
		return this.currDose;
	}

	public int getDoses() {
		return this.DOSES;
	}

	public abstract void consume();

	public String toString() {
		return this.getName()
				+ "\n-----------------"
				+ "\n" + this.getDesc()
				+ "\nDoses Remaining: " + this.getCurrDose() + "/" + this.getDoses();
	}
}
