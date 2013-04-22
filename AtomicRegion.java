//Chris Cullati Comp 310 Assiter
public class AtomicRegion extends Region {
	//private variables
	private int population;
	private double area;

	public AtomicRegion(){//default constructor
		super();
		population = 0;
		area = 0.0;
	}
		
	public AtomicRegion(String initialName, int initialPopulation, double initialArea){//specified constructor
		super(initialName);
		population = initialPopulation;
		area = initialArea;
	}
	
	public void setPopulation(int newPopulation){//mutator
		population = newPopulation;
	}
	
	public void setArea(double newArea){//mutator
		area = newArea;
	}
	
	public int getPopulation(){//accessor
		return population;
	}
	
	public double getArea(){//accessor
		return area;
	}
	
	public String toString(){//method to output information
		String s = super.toString();
		return s + "Population = " + population + "\n Area = " + area;
	}
	
}
