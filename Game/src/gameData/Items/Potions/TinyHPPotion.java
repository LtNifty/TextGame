package gameData.Items.Potions;

import gameData.Player;

public class TinyHPPotion extends Potion {

	public TinyHPPotion() {
		super();
		this.name = "Tiny Health Potion";
		this.desc = "A vial of a vibrant red solution. It slightly vitalizes the body."
				+ "\n+2 HP";
	}

	public void consume() {
		--this.currDose;
		Player.findSkill("HP").addCurLvl(2);
	}
}
