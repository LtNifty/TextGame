package gameData.Quests;

import java.util.ArrayList;
import gameData.Skills.Skill;

public abstract class Quest {
	public static ArrayList<Quest> quests = new ArrayList<Quest>();
	protected String name, desc;
	protected final int MAX_PHASE;
	private int phase;
	private ArrayList<Skill> reqs, rewards;

	public Quest() {
		Quest.quests.add(this);
		this.desc = this.setDesc(this.getPhase());
		this.reqs = this.setReqs();
		this.rewards = this.setRewards();
		this.MAX_PHASE = this.setMaxPhase();
		this.phase = 0;
	}

	// ****************
	// ACCESSOR METHODS
	// ****************
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

	public int getMaxPhase() {
		return this.MAX_PHASE;
	}

	public int getPhase() {
		return this.phase;
	}

	// ****************
	// MUTATOR METHODS
	// ****************

	protected abstract String setDesc(int temp);

	protected abstract ArrayList<Skill> setReqs();

	protected abstract ArrayList<Skill> setRewards();

	protected abstract int setMaxPhase();

	// **************
	// MISC. METHODS
	// **************

	// Formats quest requirements
	public String printReqs() {
		String str = "";

		for (Skill skill : this.reqs)
			str += "\n - Level " + skill.getLvl() + " " + skill.getName();

		return "Requirements:" + str;
	}

	// Formats quest rewards
	public String printRewards() {
		String str = "";

		for (Skill skill : this.rewards)
			str += "\n- " + skill.getXp() + " " + skill.getName() + " XP";

		return "Rewards:" + str;
	}

	public int progress() {
		if (this.phase == this.MAX_PHASE)
			return 100;
		return (int) (((double) this.phase / this.MAX_PHASE) * 100);
	}

	public void nextPhase() {
		if (this.phase != this.MAX_PHASE) {
			this.phase++;
			this.desc = setDesc(this.phase);
		}
	}

	public String toString() {
		return "<=-= " + this.name.toUpperCase() + " (" + this.progress() + "%)" + " =-=>"
				+ "\n" + this.desc
				+ "\n\n" + this.printReqs()
				+ "\n" + this.printRewards();
	}

}
