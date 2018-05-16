import java.util.LinkedList;

public class Node implements Comparable<Node>{
	
	private String city;
	private LinkedList<Edge> paths;
	private int cost;
	private double time;
	private Node prevNode;
	private boolean visited;
	
	/**
	 * Creates a node.
	 * @param city name of city.
	 */
	public Node(String city) {
		paths = new LinkedList<Edge>();
		this.city = city;
		cost = Integer.MAX_VALUE;
		prevNode = null;
		visited = false;
		
	}
	
	/**
	 * set cost and time to max value.
	 */
	public void reset() {
		cost = Integer.MAX_VALUE;
		time = Double.MAX_VALUE;
		prevNode = null;
		visited = false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Node n) {
		return cost - n.getCost();
	}
	
	/**
	 * @param e add an edge.
	 */
	public void add(Edge e) {
		paths.add(e);
		
	}
	
	/**
	 * @return the name of the city (Node).
	 */
	public String getCity() {
		
		return city;
	}
	
	/**
	 * @return a linkedlist containing all edges connected to the nodes.
	 */
	public LinkedList<Edge> getPaths(){
		return paths;
	}
	
	/**
	 * @param i the cost.
	 */
	public void setCost(int i) {
		cost = i;
	}
	
	/**
	 * Set visited to true or false.
	 * @return true if node was visited, false otherwise.
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * Returns the cost.
	 * @return the cost.
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Set the variable visited to true or false.
	 * @param b the param.
	 */
	public void setVisited(boolean b) {
		visited = b;
	}
	
	/**
	 * Set the node which we came from.
	 * @param prev the previous Node.
	 */
	public void setPrev(Node prev) {
		prevNode = prev;
	}
	
	/**
	 * Returns the previous Node.
	 * @return the previous node.
	 */
	public Node getPrev() {
		return prevNode;
	}

	/**
	 * Return the time cost.
	 * @return the time cost.
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * set the time cost.
	 * @param t the time.
	 */
	public void setTime(double t) {
		time = t;
	}
	

}
