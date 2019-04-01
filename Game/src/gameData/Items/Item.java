package gameData.Items;

public class Item {
	
	protected String name, desc;
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String toString() {
		return getName()
				+ "\n-----------------"
				+ "\n" + getDesc();
	}
}
