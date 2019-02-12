package gameData.Items.Potions;

import gameData.Player;

public class PotionTemplate extends Potion {

	public PotionTemplate() {
		super();
		this.name = "Enter Name Here";
		this.desc = "Enter item description here"
				+ "\n+Skill Effect Here";
	}

	public void consume() {
		--this.currDose;
		Player.findSkill("EnterSkillHere").addCurLvl(999);
	}
}