package gameData.Quests;

import java.util.ArrayList;
import gameData.Skills.Skill;

public abstract class Quest {
	public static ArrayList<Quest> quests = new ArrayList<Quest>();
	protected String name, desc;
	private int phase;
	private final int MAX_PHASE;
	private ArrayList<Skill> reqs;
	private ArrayList<Skill> rewards;

	public Quest(int maxPhase) {
		Quest.quests.add(this);
		this.desc = setDesc(this.getPhase());
		this.reqs = setReqs();
		this.rewards = setRewards();
		this.phase = 0;
		this.MAX_PHASE = maxPhase;
	}

	/*******************
	 * ACCESSOR METHODS
	 *******************/
	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.desc;
	}

	public ArrayList<Skill> getReqs() {
		return (ArrayList<Skill>) this.reqs;
	}

	public ArrayList<Skill> getRewards() {
		return (ArrayList<Skill>) this.rewards;
	}

	public int getPhase() {
		return this.phase;
	}

	public boolean isComplete() {
		return this.phase == this.MAX_PHASE;
	}

	/*******************
	 * MUTATOR METHODS
	 *******************/
	public abstract String setDesc(int temp);

	public abstract ArrayList<Skill> setReqs();

	public abstract ArrayList<Skill> setRewards();

	/*******************
	 * MISCELLANEOUS METHODS
	 *******************/
	public String status() {
		if (this.phase == 0)
			return "";
		else if (this.phase > 0 && this.phase < this.MAX_PHASE)
			return "~";
		else
			return "V";
	}

	public void nextPhase() {
		this.phase++;
		this.desc = setDesc(this.phase);
	}

	public String toString() {
		ArrayList<Skill> tempReqs = this.getReqs(), tempRewards = this.getRewards();
		String outReqs = "", outRewards = "";

		// Gets quest requirements
		for (Skill questSkill : tempReqs) {
			outReqs += " - Level " + questSkill.getLvl() + " " + questSkill.getName();
		}

		// Gets quest rewards
		for (Skill questSkill : tempRewards) {
			outRewards += " - " + questSkill.getXp() + " " + questSkill.getName() + " XP";
		}

		return "<=-=-= " + this.getName() + " =-=-=>"
		+ "\n" + this.getDesc()
		+ "\n\nRequirements to Start " + this.getName()
		+ "\n" + outReqs
		+ "\n\nRewards Upon Completion of " + this.getName()
		+ "\n" + outRewards + "\n";
	}

}
