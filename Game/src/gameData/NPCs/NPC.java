package gameData.NPCs;

public abstract class NPC {
	
	private String name;

	public NPC(String name_) {
		this.name = name_;
	}
	
	public abstract String dialogue(int choice);
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "uncompleted toString method";
	}
}
