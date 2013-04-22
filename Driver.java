import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {
		Graph maze = new Graph();
		
		//creates vertexes
		Vertex one = new Vertex("Start", 1, 1);
		Vertex two = new Vertex("Two", 1, 5);
		Vertex three = new Vertex("Three", 8, 5);
		Vertex a = new Vertex("A", 1, 4);
		Vertex b = new Vertex("Exit", 2, 4);
		Vertex c = new Vertex("C", 5, 5);
		
		//adds vertexes to maze 
		maze.Add(one);
		maze.Add(two);
		maze.Add(three);
		//adds neighbors to vertexes
		maze.Add(a, one);
		maze.Add(b, a);
		maze.Add(c, three);
		
		solve(maze);
	}
	
	//finds exit point using arraylist
	public static void solve(Graph g){
		Vertex start = g.getStart();
		start.visited = true;
		ArrayList<Vertex> neighbors = start.getNeighbors();
		Vertex endpoint = explore(neighbors); //calls explore method to find exit
		Vertex current = endpoint;
		System.out.println("End: " + endpoint);
	}
	
	//explores through neighbors to look for exit point. Returns endpoint. Method is recursive.
	public static Vertex explore(ArrayList<Vertex> list){
		System.out.println(list.size() + " neighbors of: " + list.get(0).getLast());
		for(Vertex next : list){
			System.out.println(next);
			if(next.getLabel().equalsIgnoreCase("Exit")){
				System.out.println("Found!");
				return next;
			}
		}
		for(Vertex next : list){
			if(next.hasNeighbors()){
				next = explore(next.getNeighbors()); //recursive call to find neighbors of neighbors
			}else{
				continue;
			}
			if(next == null){
				continue;
			}else{
				return next;
			}
		}
		return null;
	}
	
}
