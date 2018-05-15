import java.util.Comparator;

public class TimeComparator implements Comparator<Node>{
	public int compare(Node a, Node b) {
		double time1 = a.getTime();
		double time2 = b.getTime();
		
		if(time1 - time2 == 0) {
			return 0;
		}
		else if(time1 - time2 < 0) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
