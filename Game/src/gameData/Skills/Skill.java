package gameData.Skills;

public class Skill {
	private final int MAX_LVL;
	private int xp, lvl, curLvl;
	protected String name, desc;
	private boolean buff;

	/*
	 * Combat Skills Melee: Attack (accuracy of hits), Strength (damage of hits),
	 * Defence (ability to withstand hits) Mage: Insight (accuracy of spells), Magic
	 * (damage of spells), Warding (ability to withstand spells) Ranger: Focus
	 * (accuracy of arrows), Ranged (damage of arrows), Agility (ability to
	 * withstand arrows)
	 *
	 * HP (health in battle), Vitality (ability to regenerate HP), Prayer (ability
	 * to spiritually enhance physical and magical capabilities), Slayer (ability to
	 * defeat beasts) Dexterity (ability to quickly attack), Evasion (ability to
	 * dodge attacks)
	 */

	/*
	 * Misc. Skills Enchanting (magically enhance && craft weapons && armor),
	 * Smithing (physically enhance && craft weapons && armor), Mining (ability to
	 * obtain ores && gems) Woodcutting (ability to cut down trees && vines),
	 * Firemaking (ability to create && sustain fire), Cooking (ability to cook)
	 * Crafting (ability to craft jewelry), Herblore (ability to brew potions)
	 *
	 */

	/*
	 * Buffs
	 *
	 */

	/*
	 * private boolean quickThinking, demonicRage, craggyExterior; // Atk, Str, Def
	 * private boolean thirdEye, innerFlame, spellShield; // Insight, Magic, Warding
	 * private boolean hawkEye, robinGrace, strafe; // Focus, Ranged, Agility
	 * private boolean demonHeart, fervor, heavenlyGuidance, archronicralStudies; //
	 * HP, Prayer, Slayer private boolean sleightOfHand, illusionist; // Dexterity,
	 * Evasion
	 *
	 * private boolean bookWurm, metallicBlood, prospective; private boolean
	 * treantlike, pyrocynist, spiced; private boolean craftsman, witchBlessing;
	 *
	 * private boolean omniscient; // add +2 to ALL abilities
	 */

	// "Lvl" Skill Constructor
	public Skill(int lvl_) {
		this.MAX_LVL = 10;
		this.lvl = lvl_;
		this.buff = false;
		this.xp = this.lvlToXp(this.lvl);
		this.curLvl = this.lvl;
	}

	// "XP" Skill Constructor
	public Skill(double xp_) {
		this.MAX_LVL = 10;
		this.xp = (int) xp_;
		this.buff = false;
		this.lvl = this.xpToLvl(this.xp);
		this.curLvl = this.lvl;
	}

	// **************
	// ACCESSOR METHODS
	// **************
	public int getMaxLvl() {
		return this.MAX_LVL;
	}

	public String getName() {
		return this.name;
	}

	public int getLvl() {
		return this.lvl;
	}

	public int getCurLvl() {
		return this.curLvl;
	}

	public int getXp() {
		return this.xp;
	}

	public boolean hasBuff() {
		return this.buff;
	}

	// **************
	// MUTATOR METHODS
	// **************
	public void addXp(int num) {
		this.xp += num;
	}

	public void addBuff() {
		this.buff = true;
	}

	public void addCurLvl(int num) {
			this.curLvl += num;
	}

	public void decCurLvl(int num) {
		if (this.curLvl - num < 0)
			this.curLvl = 0;
		else
			this.curLvl -= num;
	}

	public void setLvl(int num) {
		this.xp = this.lvlToXp(num);
		this.lvl = num;
		this.curLvl = num;
	}

	// **************
	// MISC. METHODS
	// **************
	
	public String buffStatus() {
		if (this.buff == true)
			return " ~";
		else
			return "";
	}

	// Short-info about the skill
	public String printSkill() {
		return this.name + "\t\t" + "[" + this.curLvl + "/" + this.lvl + "]";
	}

	public int lvlToXp(int lvl_) {
		if (lvl_ == 0)
			return -50;
		else if (lvl_ == 1)
			return 0;
		else if (lvl_ == 2)
			return 83;
		else if (lvl_ == 3)
			return 174;
		else if (lvl_ == 4)
			return 276;
		else if (lvl_ == 5)
			return 388;
		else if (lvl_ == 6)
			return 512;
		else if (lvl_ == 7)
			return 650;
		else if (lvl_ == 8)
			return 801;
		else if (lvl_ == 9)
			return 969;
		else if (lvl_ == 10)
			return 1500;
		else
			return 5000;
	}

	public int xpToLvl(int xp_) {
		if (xp_ >= -50 && xp_ < 0)
			return 0;
		else if (xp_ >= 0 && xp_ < 83)
			return 1;
		else if (xp_ >= 83 && xp_ < 174)
			return 2;
		else if (xp_ >= 174 && xp_ < 276)
			return 3;
		else if (xp_ >= 276 && xp_ < 388)
			return 4;
		else if (xp_ >= 388 && xp_ < 512)
			return 5;
		else if (xp_ >= 512 && xp_ < 650)
			return 6;
		else if (xp_ >= 650 && xp_ < 801)
			return 7;
		else if (xp_ >= 801 && xp_ < 969)
			return 8;
		else if (xp_ >= 969 && xp_ < 1500)
			return 9;
		else if (xp_ >= 1500)
			return 10;
		else
			return -1000;
	}

	// Nearly everything about the skill
	public String toString() {
		return this.name + this.buffStatus() + "\t[" + this.curLvl + "/" + this.lvl + "]"
				+ "\n-----------"
				+ "\nCurrent XP: " + this.xp
				+ "\nRemaining XP: " + (this.lvlToXp(this.lvl + 1) - this.xp)
				+ "\nNext Lvl XP: " + this.lvlToXp(this.lvl + 1) + "\n";
	}
}
