
public class Main {
	public static void main(String[] args) {
		GpsView gps = new GpsView();	//view
		Graph g = new Graph(); //model
		g.generateGraph("Sverige2");
		GpsController c = new GpsController(gps, g); //controller
		gps.setVisible(true);
	}
}
