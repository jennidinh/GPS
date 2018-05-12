import java.util.LinkedList;

public class Node implements Comparable<Node>{
	
	private String city;
	private LinkedList<Edge> paths;
	private int cost;
	private Node prevNode;
	private boolean visited;
	
	public Node(String city) {
		paths = new LinkedList<Edge>();
		this.city = city;
		cost = Integer.MAX_VALUE;
		prevNode = null;
		visited = false;
		
	}
	
	public void reset() {
		cost = Integer.MAX_VALUE;
		prevNode = null;
		visited = false;
	}
	
	public int compareTo(Node n) {
		return cost - n.getCost();
	}
	
	public void add(Edge e) {
		paths.add(e);
		
	}
	
	public String getCity() {
		
		return city;
	}
	
	public LinkedList<Edge> getPaths(){
		return paths;
	}
	
	public void setCost(int i) {
		cost = i;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setVisited(boolean b) {
		visited = b;
	}
	
	public void setPrev(Node prev) {
		prevNode = prev;
	}
	
	public Node getPrev() {
		return prevNode;
	}


	

}
