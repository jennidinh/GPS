import java.util.LinkedList;

public class Node {
	
	private String city;
	private LinkedList<Edge> paths;
	
	public Node(String city) {
		
		this.city = city;
		
	}
	
	public void add(Edge e) {
		paths.add(e);
		
	}
	
	public String getCity() {
		
		return city;
	}
	
	
	
	
	

}
