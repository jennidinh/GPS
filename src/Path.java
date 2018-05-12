import java.util.ArrayList;

public class Path {
	ArrayList<String> list;
	private String path;
	private int dist;
	
	public Path(String path, int dist) {
		this.path = path;
		this.dist = dist;
	}
	
	public int getDist() {
		return dist;
	}
	
	public String getPath() {
		return path;
	}
}
