import java.util.ArrayList;

public class Path {
	ArrayList<String> list;
	private String path;
	private int dist;
	private double time;
	
	public Path(String path, int dist, double time) {
		this.path = path;
		this.dist = dist;
		this.time = time;
	}
	
	public int getDist() {
		return dist;
	}
	
	public String getPath() {
		return path;
	}
}
