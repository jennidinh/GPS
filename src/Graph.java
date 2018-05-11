import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Graph {

	private Hashtabell cities;

	public Graph() {

		cities = new Hashtabell(10);

	}

	public void generateGraph(String filename) {

		try {
			
			File file = new File(filename);
			
			Scanner scan = new Scanner(file);
			Edge edge;
			String from;
			String dest;
			int weight;
			
			
			while(scan.hasNext()) {
				
				from = scan.next();
				dest = scan.next();
				weight = Integer.parseInt(scan.next());
				addEdge(from, dest, weight);
				
			}
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	

	public void add(String startCity, String destinationCity, int weight) {
		Node s = getNode(startCity);
		Node d = getNode(destinationCity);
		Edge e = new Edge(d, weight);
		addEdge(startCity, destinationCity, weight);

	}
	public void addEdge(String startCity, String destCity, int weight) {
		
		Node start = getNode(startCity);
		Node dest = getNode(destCity);
		start.getPaths().add( new Edge( dest, weight ) );
		
	}
	
	public Node getNode(String name) {
		Node node = cities.find(name);
		if(node == null) {
			node = new Node(name);
			cities.add(node);
		}
		return node;
	}

	public void findShortestPath() {

	}

	public void findFastestPath() {

	}

}
