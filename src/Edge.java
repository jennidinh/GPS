
public class Edge {

	private Node destination;
	private int weight;

	public Edge(Node destination, int weight) {

		this.destination = destination;
		this.weight = weight;

	}
	
	public int getWeight() {
		return weight;
	}

	public Node getDestination() {
		return destination;
	}
}
