import java.util.ArrayList;


public class Vertex {
	
	private int weight;
	private String label;
	private Vertex last;
	private ArrayList<Vertex> neighbors;
	public boolean visited;
	private int xCoord;
	private int yCoord;
	
	//constructor
	public Vertex(String label, int x, int y){
		this.setLabel(label);
		this.setxCoord(x);
		this.setyCoord(y);
		neighbors = new ArrayList<Vertex>();
		visited = false;
	}
	//adds new neighbor
	public void AddNeighbor(Vertex newVertex){
		neighbors.add(newVertex);
	}
	//returns if has neighbors
	public boolean hasNeighbors(){
		if(this.getNumNeighbors() > 0){
			return true;
		}else{
			return false;
		}
	}
	//gets number of neighbors
	public int getNumNeighbors(){
		return this.getNeighbors().size();
	}
	//accessor
	public int getWeight() {
		return weight;
	}
	//mutator
	public void setWeight(int weight) {
		this.weight = weight;
	}
	//accessor
	public String getLabel() {
		return label;
	}
	//mutator
	public void setLabel(String label) {
		this.label = label;
	}
	//accessor
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
	//mutator
	public void setNeighbors(ArrayList<Vertex> neighbors) {
		this.neighbors = neighbors;
	}
	//accessor
	public Vertex getLast() {
		return last;
	}
	//mutator based on x coordinate then y
	public void setLast(Vertex last) {
		int lastX = last.getxCoord();
		int lastY = last.getyCoord();
		int thisX = this.getxCoord();
		int thisY = this.getyCoord();
		
		if(thisX == lastX){
			weight = Math.abs(thisY - lastY);
		}else{
			weight = Math.abs(thisX - lastX);
		}
		
		last.setWeight(weight);
		this.last = last;
	}
	//accessor
	public int getxCoord() {
		return xCoord;
	}
	//mutator
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	//accessor
	public int getyCoord() {
		return yCoord;
	}
	//mutator
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	//prints a string type of objects
	public String toString(){
		return this.getLabel() + ", (" + this.getxCoord() + ", " + this.getyCoord() + ")";
	}
}
