//Chris Cullati Comp 310 Assiter
public class City extends AtomicRegion {
	//private variables
	private String mayor;
	
	public City(){//default constructor
		super();
		mayor  = "";
	}
	public City(String initialName, int initialPopulation, double initialArea, String initialMayor){//specified constructor
		super(initialName, initialPopulation, initialArea);
		mayor = initialMayor;
	}
	
	public void setMayor(String newMayor){//mutator
		mayor = newMayor;
	}
	
	public String getMayor(){//accessor
		return mayor;
	}
	
	public String toString(){//method to output information
		String s = super.toString();
		return s +  "Mayor = " + mayor;
	}
	public static void main(String[] args) {
		City c = new City("Boston",100,100,"Menino"); //creates city with specific information
		System.out.println(c); //outputs city information with toString method
	}
	
}
