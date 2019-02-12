package gameData.Skills;

public class HP extends Skill {

	public HP(int lvl_) {
		super(lvl_);
		this.name = "HP";
		this.desc = "A skill that affects your number of hitpoints.";
	}
	
	public HP(double xp_) {
		super(xp_);
		this.name = "HP";
		this.desc = "A skill that affects your number of hitpoints.";
	}
	
}
