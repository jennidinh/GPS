import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

public class GpsView extends JFrame {

	JButton searchButton = new JButton("SÖK");
	JLabel label = new JLabel("HH-Trafiken");
	JLabel from = new JLabel("Från:", SwingConstants.LEFT);
	JLabel to = new JLabel("Till:  ", SwingConstants.LEFT);
	JTextField text = new JTextField(15);
	JTextField text2 = new JTextField(15);
	JRadioButton button = new JRadioButton("Kortaste väg   ");
	JRadioButton button2 = new JRadioButton("Snabbaste väg");
	ButtonGroup group = new ButtonGroup();

	public GpsView() {
		group.add(button);
		group.add(button2);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		JPanel gpsPanel = new JPanel();

		gpsPanel.add(label);
		
		// från text och textruta
		JPanel fromPanel = new JPanel();
		fromPanel.setPreferredSize(new Dimension(400, 30));
		fromPanel.add(from);
		fromPanel.add(text);
		gpsPanel.add(fromPanel, BorderLayout.NORTH);

		// till text och textruta
		JPanel toPanel = new JPanel();
		toPanel.setPreferredSize(new Dimension(400, 30));
		toPanel.add(to);
		toPanel.add(text2);
		gpsPanel.add(toPanel, BorderLayout.NORTH);
		
		// välja kortaste- eller snabbaste väg
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		buttonPanel.setPreferredSize(new Dimension(150, 50));
		buttonPanel.add(button, Component.CENTER_ALIGNMENT);
		buttonPanel.add(button2, Component.CENTER_ALIGNMENT);
		gpsPanel.add(buttonPanel, BorderLayout.NORTH);

		// sök knappen
		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(400, 50));
		searchPanel.add(searchButton);
		gpsPanel.add(searchPanel, BorderLayout.SOUTH);

		this.add(gpsPanel);
	}
	

	public static void main(String[] args) {
		GpsView gps = new GpsView();

		gps.setVisible(true);

	}

}
