package gameData;

import java.util.*;

import gameData.Quests.*;
import gameData.Skills.*;
import gameData.Items.Item;
import gameData.Items.Potions.*;
import gameData.Items.Weapons.*;

public class Player {
	private static ArrayList<Skill> skills;
	private static ArrayList<Item> inv;
	private String race, name, majCareer, minCareer;

	public Player(String name_, String race_, String majCareer_, String minCareer_) {

		this.name = name_;
		this.race = race_;
		this.majCareer = majCareer_;
		this.minCareer = minCareer_;
		this.setGameStats();
		this.setGameInv();
	}

	// **************
	// ACCESSOR METHODS
	// **************

	public String getName() {
		return this.name;
	}

	public String getRace() {
		return this.race;
	}

	public String getMajCareer() {
		return this.majCareer;
	}

	public String getMinCareer() {
		return this.minCareer;
	}

	public ArrayList<Skill> findSkills() {
		return Player.skills;
	}

	public ArrayList<Item> getInv() {
		return Player.inv;
	}

	// **************
	// SKILLS METHODS
	// **************

	// Filler for Player.skills; Defaults all skills to Lvl. 1
	public void setGameStats() {
		Player.skills = new ArrayList<Skill>();

		Player.skills.add(new HP(10));
		Player.skills.add(new Attack(1));
		Player.skills.add(new Strength(1));
		Player.skills.add(new Defence(1));
		Player.skills.add(new Focus(1));
		Player.skills.add(new Ranged(1));
		Player.skills.add(new Agility(1));
		Player.skills.add(new Insight(1));
		Player.skills.add(new Magic(1));
		Player.skills.add(new Warding(1));
		Player.skills.add(new Vitality(1));
		Player.skills.add(new Woodcutting(1));
		Player.skills.add(new Firemaking(1));
		Player.skills.add(new Hunter(1));
		Player.skills.add(new Fishing(1));
		Player.skills.add(new Cooking(1));
		Player.skills.add(new Mining(1));
		Player.skills.add(new Smithing(1));
		Player.skills.add(new Crafting(1));
		Player.skills.add(new Enchanting(1));
		Player.skills.add(new Prayer(1));
		Player.skills.add(new Herblore(1));
		this.raceSkills();
		this.careerSkills();
	}

	// Helper method for setGameStats()
	// Affects combat skills. Use this if adding a new race.
	private void raceSkills() {
		// When the race is Elf...
		if (this.race.equals("Elf")) {
			Player.findSkill("Attack").setLvl(0);
			Player.findSkill("Strength").setLvl(0);
			Player.findSkill("Defence").setLvl(0);
			Player.findSkill("Focus").setLvl(2);
			Player.findSkill("Ranged").setLvl(2);
			Player.findSkill("Agility").setLvl(2);
		}
		// When the race is Dwarf...
		else if (this.race.equals("Dwarf")) {
			Player.findSkill("Insight").setLvl(0);
			Player.findSkill("Magic").setLvl(0);
			Player.findSkill("Warding").setLvl(0);
			Player.findSkill("Attack").setLvl(2);
			Player.findSkill("Strength").setLvl(2);
			Player.findSkill("Defence").setLvl(2);
		}
		// When the race is Ogre...
		else if (this.race.equals("Ogre")) {
			Player.findSkill("Focus").setLvl(0);
			Player.findSkill("Ragned").setLvl(0);
			Player.findSkill("Agility").setLvl(0);
			Player.findSkill("Insight").setLvl(2);
			Player.findSkill("Magic").setLvl(2);
			Player.findSkill("Warding").setLvl(2);
		}
	}

	// Helper method for setGameStats()
	// Affects all other skills i.e. skills affected by career choice.
	private void careerSkills() {
		// Vitality Career
		if (this.majCareer.equalsIgnoreCase("Boxer"))
			Player.findSkill("Vitality").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Boxer"))
			Player.findSkill("Vitality").setLvl(2);

		// Woodcutting Career
		if (this.majCareer.equalsIgnoreCase("Lumberjack") || this.majCareer.equalsIgnoreCase("Lumberjill"))
			Player.findSkill("Woodcutting").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Lumberjack") || this.minCareer.equalsIgnoreCase("Lumberjill"))
			Player.findSkill("Woodcutting").setLvl(2);

		// Firemaking Career
		if (this.majCareer.equalsIgnoreCase("Traveler"))
			Player.findSkill("Firemaking").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Traveler"))
			Player.findSkill("Firemaking").setLvl(2);

		// Hunter Career
		if (this.majCareer.equalsIgnoreCase("Hunter") || this.majCareer.equalsIgnoreCase("Huntress"))
			Player.findSkill("Hunter").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Hunter") || this.minCareer.equalsIgnoreCase("Huntress"))
			Player.findSkill("Hunter").setLvl(2);

		// Fishing Career
		if (this.majCareer.equalsIgnoreCase("Fisherman") || this.majCareer.equalsIgnoreCase("Fisherwoman"))
			Player.findSkill("Fishing").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Fisherman") || this.minCareer.equalsIgnoreCase("Fisherwoman"))
			Player.findSkill("Fishing").setLvl(2);

		// Cooking Career
		if (this.majCareer.equalsIgnoreCase("Chef"))
			Player.findSkill("Cooking").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Chef"))
			Player.findSkill("Cooking").setLvl(2);

		// Mining Career
		if (this.majCareer.equalsIgnoreCase("Miner"))
			Player.findSkill("Mining").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Miner"))
			Player.findSkill("Mining").setLvl(2);

		// Smithing Career
		if (this.majCareer.equalsIgnoreCase("Blacksmith"))
			Player.findSkill("Smithing").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Blacksmith"))
			Player.findSkill("Smithing").setLvl(2);

		// Enchanting Career
		if (this.majCareer.equalsIgnoreCase("Enchanter") || this.majCareer.equalsIgnoreCase("Enchantress"))
			Player.findSkill("Enchanting").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Enchanter") || this.minCareer.equalsIgnoreCase("Enchantress"))
			Player.findSkill("Enchanting").setLvl(2);

		// Prayer Career
		if (this.majCareer.equalsIgnoreCase("Priest") || this.majCareer.equalsIgnoreCase("Priestess"))
			Player.findSkill("Prayer").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Priest") || this.minCareer.equalsIgnoreCase("Priestess"))
			Player.findSkill("Prayer").setLvl(2);

		// Crafting Career
		if (this.majCareer.equalsIgnoreCase("Craftsman") || this.majCareer.equalsIgnoreCase("Craftswoman"))
			Player.findSkill("Crafting").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Craftsman") || this.minCareer.equalsIgnoreCase("Craftswoman"))
			Player.findSkill("Crafting").setLvl(2);

		// Herblore Career
		if (this.majCareer.equalsIgnoreCase("Herbalist"))
			Player.findSkill("Herblore").setLvl(3);
		else if (this.minCareer.equalsIgnoreCase("Herbalist"))
			Player.findSkill("Herblore").setLvl(2);

	}

	// Returns an auto-formatted list of skills
	public String printSkills(int num) {
		String str = "";

		for (Skill skill : this.organizeSkills(num))
			if (skill.getName().equals("HP") == false)
				str += "\n" + skill.printSkill() + skill.buffStatus();

		return "<=-=-= " + this.name + "\'s Data =-=-=>" + "\n" + Player.findSkill("HP").printSkill()
				+ "\n\nSkills\n------------------" + str + "\n";

	}

	// Helper organizer method for printSkills()
	private ArrayList<Skill> organizeSkills(int num) {
		ArrayList<Skill> arr = new ArrayList<Skill>();
		Skill temp = null;
		int xp;
		String name;

		Comparator<Skill> xpComparator = new Comparator<Skill>() {

			public int compare(Skill s1, Skill s2) {
				return s1.getXp() - s2.getXp();
			}
		};

		switch (num) {
		default:
			return Player.skills;

		case 2: // Increasing XP (highest XP is first)
			Collections.sort(Player.skills, xpComparator);
			return Player.skills;

		case 3: // Decreasing XP (lowest XP is first)
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MAX_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() < xp && arr.contains(skill) == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 4: // Alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "z";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) < 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 5: // Reverse-alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "a";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) > 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 6: // Buffs First - Increasing XP
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MIN_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() > xp && arr.contains(skill) == false && skill.hasBuff()) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MIN_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() > xp && arr.contains(skill) == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 7: // Buffs First - Decreasing XP
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MAX_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() < xp && arr.contains(skill) == false && skill.hasBuff()) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MAX_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() < xp && arr.contains(skill) == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 8: // Buffs First: Alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "z";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) < 0 && arr.contains(skill) == false && skill.hasBuff()) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "z";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) < 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 9: // Buffs First: Reverse-alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "a";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) > 0 && arr.contains(skill) == false && skill.hasBuff()) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "a";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) > 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 10: //Buffs First: Increasing XP
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MIN_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() > xp && arr.contains(skill) == false && skill.hasBuff() == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MIN_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() > xp && arr.contains(skill) == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 11: // Buffs last - Decreasing XP
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MAX_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() < xp && arr.contains(skill) == false && skill.hasBuff() == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			for (int i = 0; i < Player.skills.size(); i++) {
				xp = Integer.MAX_VALUE;
				for (Skill skill : Player.skills) {
					if (skill.getXp() < xp && arr.contains(skill) == false) {
						xp = skill.getXp();
						temp = skill;
					}
				}
				arr.add(temp);
			}

			return arr;


		case 12: // Buffs last - Alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "z";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) < 0 && arr.contains(skill) == false && skill.hasBuff() == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}

			for (int i = 0; i < Player.skills.size(); i++) {
				name = "z";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) < 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;

		case 13: // Buffs last - Reverse-alphabetically
			for (int i = 0; i < Player.skills.size(); i++) {
				name = "a";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) > 0 && arr.contains(skill) == false && skill.hasBuff() == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}

			for (int i = 0; i < Player.skills.size(); i++) {
				name = "a";
				for (Skill skill : Player.skills) {
					if (skill.getName().compareToIgnoreCase(name) > 0 && arr.contains(skill) == false) {
						name = skill.getName();
						temp = skill;
					}
				}
				arr.add(temp);
			}
			return arr;
		}
	}

	// "Universal" method that grabs a skill based off name
	public static Skill findSkill(String str) {
		Skill temp = null;

		for (Skill skill : skills)
			if (skill.getName().equals(str))
				temp = skill;

		return temp;
	}

	// **************
	// QUEST METHODS
	// **************

	// Prints a list of ALL quests
	public String printQuests(int num) {
		String str = "";
		ArrayList<Quest> arr = this.organizeQuests(num);

		for (Quest temp : arr) {
			str += temp.getName() + temp.status();
		}

		return "Quests"
		+ "\n------------------"
		+ "\n" + str + "\n";
	}

	// Prints info about one quest
	public String printQuest(String str) {
		return Player.findQuest(str).toString();
	}

	// Adds XP to main skill list from quest skill rewards list
	public void addQuestStats(Quest quest) {
		for (Skill skill : quest.getRewards())
			Player.findSkill(skill.getName()).addXp(skill.getXp());
	}

	// Helper organizer method for printQuests()
	private ArrayList<Quest> organizeQuests(int num) {
		ArrayList<Quest> arr = new ArrayList<Quest>();
		String name;
		Quest temp = null;

		Comparator<Quest> phaseComparator = new Comparator<Quest>() {

			public int compare(Quest q1, Quest q2) {
				return q1.getPhase() - q2.getPhase();
			}
		};

		// ONGOING QUESTS
		for (int i = 0; i < Quest.quests.size(); i++) {
			name = "z";
			for (Quest quest : Quest.quests) {
				if (quest.getName().compareToIgnoreCase(name) < 0 && arr.contains(quest) == false && quest.getPhase() > 0 && quest.isComplete() == false) {
					name = quest.getName();
					temp = quest;
				}
			}
			arr.add(temp);
		}
		// INCOMPLETE QUESTS
		for (int i = 0; i < Quest.quests.size(); i++) {
			name = "z";
			for (Quest quest : Quest.quests) {
				if (quest.getName().compareToIgnoreCase(name) < 0 && arr.contains(quest) == false && quest.getPhase() == 0) {
					name = quest.getName();
					temp = quest;
				}
			}
			arr.add(temp);
		}
		// COMPLETE QUESTS
		for (int i = 0; i < Quest.quests.size(); i++) {
			name = "z";
			for (Quest quest : Quest.quests) {
				if (quest.getName().compareToIgnoreCase(name) < 0 && arr.contains(quest) == false && quest.isComplete()) {
					name = quest.getName();
					temp = quest;
				}
			}
			arr.add(temp);
		}
		return arr;
	}

	// "Universal" method that grabs a quest based off name
	public static Quest findQuest(String name) {
		Quest temp = null;

		for (Quest quest : Quest.quests)
			if (quest.getName().equals(name))
				temp = quest;

		return temp;
	}

	// **************
	// COMBAT METHODS
	// **************

	public int getDmgInstance(Weapon wep) {
		return 6;
	}

	public String consume(Potion pot) {
		pot.consume();
		return pot.getName() + " has " + pot.getCurrDose() + " out of " + pot.getDoses() + " doses remaining.";
	}

	// **************
	// INVENTORY METHODS
	// **************

	public static Item getItem(String str) {
		Item temp = null;

		for (Item item : Player.inv)
			if (item.getName().equals(str))
				temp = item;

		return temp;
	}

	public void addQ(Item item, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Player.inv.add(item);
		}
	}

	public void setGameInv() {
		Player.inv = new ArrayList<Item>();
		this.addQ(new TinyHPPotion(), 3);
	}
}
