//Chris Cullati Comp 310 Assiter
public class Country extends ContainerRegion{
	//private variables
	private String flagcolors;
	
	public Country(){//default constructor
		super();
		flagcolors = "";
	}
	
	public Country(String initialName, String initialFlagColors){//specified constructor
		super(initialName);
		flagcolors = initialFlagColors;
	}
	
	public void setFlagColors(String newFlagColors){//mutator
		flagcolors = newFlagColors;
	}
	
	public String getFlagColors(){//accessor
		return flagcolors;
	}
	
	public String toString(){ //outputs information
		String s = super.toString();
		return s + "Flag Colors = " + flagcolors;
	}

	public static void main(String[] args) {
		Country usa = new Country("USA", "Red White and Blue"); //creates new country with specific information
		State massachusetts = new State("Massachusetts", "Deval Patrick"); //creates new state with specific information
		City boston = new City("Boston", 53238, 38594.23, "Menino");//creates new city with specific information
		massachusetts.setNRegions(1);//sets number in array to 1
		massachusetts.setRegion(0,boston);//adds city 'boston' to array index 0
		usa.setNRegions(1);//sets number in array to 1
		usa.setRegion(0, massachusetts);//adds state 'massachusetts' to array index 0
		System.out.println(usa); //outputs all information under 'usa'
	}
	
	
	
}
