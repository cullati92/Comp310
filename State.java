//Chris Cullati Comp 310 Assiter
public class State extends ContainerRegion {
	//private variables
	private String governer;
	
	public State(){//default constructor
		super();
		governer = "";
	}
	
	public State(String initialName, String initialGoverner){//specified constructor
		super(initialName);
		governer = initialGoverner;
	}
	
	public void setGoverner(String newGoverner){//mutator
		governer = newGoverner;
	}
	
	public String getGoverner(){//accessor
		return governer;
	}
	
	public static void main(String[] args) {
		State s = new State("MA","Patrick"); //new state with specific information
		
		City boston = new City("Boston", 53238, 38594.23, "Menino"); //new city with specific information
		s.setNRegions(1); //sets number in array to 1
		s.setRegion(0,boston); //sets index in array to [0] and adds city 'boston' to array
		System.out.print(s); //uses toString method to output information in array
	}

	public String toString(){ //outputs the information
		String s = super.toString();
		return s + "Governer = " + governer;
	}
}
