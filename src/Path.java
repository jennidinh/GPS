import java.util.ArrayList;

public class Path {
	ArrayList<String> list;
	private String path;
	private int dist;
	private double time;
	
	/**
	 * construct a path.
	 * @param path the destination city of the path.
	 * @param dist the distance.
	 * @param time the time.
	 */
	public Path(String path, int dist, double time) {
		this.path = path;
		this.dist = dist;
		this.time = time;
	}
	
	/**
	 * gets the distance.
	 * @return the distance.
	 */
	public int getDist() {
		return dist;
	}
	
	/**
	 * gets the destination city.
	 * @return the destination city.
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * gets the time.
	 * @return the time.
	 */
	public double getTime() {
		return time;
	}
}
