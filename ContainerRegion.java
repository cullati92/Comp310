//Chris Cullati Comp 310 Assiter
public class ContainerRegion extends Region{
	//private variables
	private Region[] region;
	private int nRegions;
	
	public ContainerRegion(){//default constructor
		super();
	}
	
	public void setNRegions(int n) { //sets number in array
		nRegions = n;
		region = new Region[nRegions];
	}
	
	public ContainerRegion(String initialName){//specified constructor
		super(initialName);
		
	}
	
	public void setRegion(int index,Region r){//mutator
		region[index]=r;
	}
	
	public Region[] getRegion(){//accessor
		return region;
	}
	public int getPopulation(){ //accessor from Region class
		for(int i=0;i<region.length;i++)
			region[i].getPopulation();
		return 0;
	}
	
	double getArea() { //accessor from Region class
		for(int i=0;i<region.length;i++)
			region[i].getArea();
		return 0;
	}
	
	public  void addRegion(Region inRegion){ //adds region to the array
		int size = 0;
		region[size++] = inRegion;
	}

	public String toString(){ //method to output information
		String s = super.toString();
		
	
		for (int i=0;i<region.length;i++) //loops to add each element to output
	      s+= region[i].toString();
		
		
		return s;
	}
	
}
