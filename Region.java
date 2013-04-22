//Chris Cullati Comp 310 Assiter
public abstract class Region {
	//private variable
	private String name;
	
	public Region(){ //default constructor
		name = "";
	}
	
	public Region(String initialName){ //specified constructor
		name = initialName;
	}
	
	public String getName(){ //accessor
		return name;
	}
	
	public void setName(String newName){//mutator
		name = newName;
	}
	
	public String toString(){ //method to output information
		return "Name = " + name;
	}
	
	abstract int getPopulation(); //calls abstract methods
	
	abstract double getArea();
	
}
