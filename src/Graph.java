
public class Graph {

	private Hashtable cities;

	public Graph() {

		cities = new Hashtable();

	}

	public void generateGraph(String file) {

	}

	public Node getNode(String city) {
		return new Node(city);

	}

	public void add(String startCity, String destinationCity, int weight) {
		Node s = getNode(startCity);
		Node d = getNode(destinationCity);
		Edge e = new Edge(d, weight);
		s.add(e);

	}

	public void findShortestPath() {

	}

	public void findFastestPath() {

	}

}
