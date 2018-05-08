import javax.swing.*;

public class GpsView extends JFrame{
	
	
	JButton searchButton = new JButton("SÖK");
	JLabel label = new JLabel("GPS över Sverige");
	JLabel from = new JLabel("Från:");
	JLabel to = new JLabel("Till:");
	JTextField text = new JTextField(10);
	JTextField text2 = new JTextField(10);
	JRadioButton button = new JRadioButton("Kortaste väg");
	JRadioButton button2 = new JRadioButton("Snabbaste väg");
	ButtonGroup group = new ButtonGroup();
	
	public GpsView() {
		
		JPanel gpsPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 200);
		
		gpsPanel.add(label);
		gpsPanel.add(from);
		gpsPanel.add(text);
		gpsPanel.add(to);
		gpsPanel.add(text2);
		gpsPanel.add(button);
		gpsPanel.add(button2);
		gpsPanel.add(searchButton);
		
		this.add(gpsPanel);
		
		
		
		
		
		
	}
	
	public static void main(String [] args) {
		GpsView gps = new GpsView();
		
		gps.setVisible(true);
		
	}

}
