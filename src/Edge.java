
public class Edge {

	private Node destination;
	private int distance;
	private double time;

	/**
	 * Creates an edge that contains the destination, distance and time.
	 * @param destination the destination.
	 * @param distance the distance.
	 * @param time the time.
	 */
	public Edge(Node destination, int distance, double time) {
		this.destination = destination;
		this.distance = distance;
		this.time = time;

	}
	
	/**
	 * @return the the edge's weight in distance.
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * @return the edge's weight in time unit.
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @return the destination of the edge.
	 */
	public Node getDestination() {
		return destination;
	}
}
