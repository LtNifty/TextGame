package gameData.Quests;

import java.util.ArrayList;
import java.util.List;

import gameData.Skills.*;

public class TestQuest extends Quest {
	
	public TestQuest(int maxPhase) {
		super(maxPhase);
		this.name = "TestQuest";
		
	}

	@Override
	public String setDesc(int phaseNum) {
		switch (phaseNum) {
		default :
			return "Sebastian wanted to test out the setDesc() method"
					+ "\n and the switch statement. It works pretty well!";
		case 1 :
			return "This should be stage two...";
		case 2 :
			return "this should be stage three...";
		case 3 :
			return "this should be the last stage...";
			
		}
	}
	
	public ArrayList<Skill> setReqs() {
		List<Skill> reqs = new ArrayList<Skill>();
		
		reqs.add(new Attack(2));
		return (ArrayList<Skill>) reqs;
	}
	
	public ArrayList<Skill> setRewards() {
		List<Skill> rewards = new ArrayList<Skill>();
		
		rewards.add(new Attack(1550.0));
		return (ArrayList<Skill>) rewards;
	}
}
