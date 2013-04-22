import java.util.ArrayList;

public class Graph {
	public int numVerticies;
	private Vertex start;
	private Vertex end;
	private int maxX;
	private int maxY;
	//constructor
	public Graph(){
		numVerticies = 0;
	}
	//adds vertex to graph
	public void Add(Vertex newVertex){
		if(this.getMaxX() < newVertex.getxCoord()){
			this.setMaxX(newVertex.getxCoord());
		}else if(this.getMaxY() < newVertex.getyCoord()){
			this.setMaxY(newVertex.getyCoord());
		}
		if(start == null){
			start = newVertex;
		}else if(end == null){
			end = newVertex;
			end.setLast(start);
			start.AddNeighbor(end);
			//end.AddNeighbor(start);
		}else{
			Vertex temp = end;
			end = newVertex;
			end.setLast(temp);
			temp.AddNeighbor(end);
			//end.AddNeighbor(temp);
		}
	}
	
	//adds new vertex and neighbor
	public void Add(Vertex newVertex, Vertex last){
		if(this.getMaxX() < newVertex.getxCoord()){
			this.setMaxX(newVertex.getxCoord());
		}else if(this.getMaxY() < newVertex.getyCoord()){
			this.setMaxY(newVertex.getyCoord());
		}
		last.AddNeighbor(newVertex);
		//System.out.println(last);
		newVertex.setLast(last);
	}
	
	//accessor
	public Vertex getStart() {
		return start;
	}
	//mutator
	public void setStart(Vertex start) {
		this.start = start;
	}
	//accessor
	public Vertex getEnd() {
		return end;
	}
	//mutator
	public void setEnd(Vertex end) {
		this.end = end;
	}
	//accessor
	public int getMaxX() {
		return maxX;
	}
	//mutator
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	//accessor
	public int getMaxY() {
		return maxY;
	}
	//mutator
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
}
