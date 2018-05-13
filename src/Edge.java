
public class Edge {

	private Node destination;
	private int weight;
	private double time;

	public Edge(Node destination, int weight, double time) {

		this.destination = destination;
		this.weight = weight;
		this.time = time;

	}
	
	public int getWeight() {
		return weight;
	}
	
	public double getTime() {
		
		return time;
	}

	public Node getDestination() {
		return destination;
	}
}
