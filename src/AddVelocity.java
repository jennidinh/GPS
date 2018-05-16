import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddVelocity {
	
	
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File("Sverige"));
			PrintWriter pw = new PrintWriter("Sverige2", "UTF-8");
			while(scan.hasNext()) {
				String city1 = scan.next();
				String city2 = scan.next();
				String dist = scan.next();
				
				pw.println(city1 + "\t" + city2 + "\t" + dist + "\t" + ((int) (Math.random()*6 + 7))*10);

			}
			
			pw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
