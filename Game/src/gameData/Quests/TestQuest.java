package gameData.Quests;

import java.util.ArrayList;
import gameData.Skills.*;

public class TestQuest extends Quest {
	
	public TestQuest() {
		super();
		this.name = "TestQuest";
	}

	public String setDesc(int phase) {
		switch (phase) {
		default:
			return "This should be stage one...";
		case 1:
			return "This should be stage two...";
		case 2:
			return "This should be stage three...";
		case 3:
			return "This should be the last stage...";
		case 4:
			return "Quest is complete!";
			
		}
	}
	
	protected ArrayList<Skill> setReqs() {
		ArrayList<Skill> reqs = new ArrayList<Skill>();
		
		reqs.add(new Attack(2));
		
		return (ArrayList<Skill>) reqs;
	}
	
	protected ArrayList<Skill> setRewards() {
		ArrayList<Skill> rewards = new ArrayList<Skill>();
		
		rewards.add(new Attack(1550.0));
		
		return (ArrayList<Skill>) rewards;
	}

	protected int setMaxPhase() {
		return 4;
	}
}
