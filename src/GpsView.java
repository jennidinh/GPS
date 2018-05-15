import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class GpsView extends JFrame {
	//
	JPanel gpsPanel;
	JButton searchButton = new JButton("SÖK");
	JLabel label = new JLabel("HH-Trafiken");
	JLabel from = new JLabel("Från:", SwingConstants.LEFT);
	JLabel to = new JLabel("Till:  ", SwingConstants.LEFT);
	JTextField text = new JTextField(15);
	JTextField text2 = new JTextField(15);
	JRadioButton button = new JRadioButton("Kortaste väg   ");
	JRadioButton button2 = new JRadioButton("Snabbaste väg");
	ButtonGroup group = new ButtonGroup();

	JPanel resultPanel;
	JButton goBack = new JButton("Ny sökning");
	JLabel chosenWay;
	JLabel time = new JLabel("Tid:      ", SwingConstants.LEFT);
	JTextField timeOutput = new JTextField(10);
	JLabel min = new JLabel("h");
	JLabel distance = new JLabel("Avstånd:", SwingConstants.LEFT);
	JTextField distanceOutput = new JTextField(10);
	JLabel km = new JLabel("km");
	JLabel way = new JLabel("Resa:", SwingConstants.LEFT);
	JLabel startCity;
	JLabel arrow = new JLabel("→");
	JLabel desCity;
	JButton moreInfoButton = new JButton("Mer info");

	JPanel infoPanel;
	JButton noInfoButton = new JButton("Tillbaka");
	JList<String> list;
	DefaultListModel<String> listModel;

	public GpsView() {
		group.add(button);
		group.add(button2);
		button.setActionCommand("Kortaste");
		button2.setActionCommand("Snabbaste");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 550);
		gpsPanel = new JPanel();
		gpsPanel.add(label);

		try {
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("src/van.gif"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setPreferredSize(new Dimension(350, 300));
			gpsPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		searchPanel.setPreferredSize(new Dimension(400, 500));
		searchPanel.add(searchButton);
		gpsPanel.add(searchPanel, BorderLayout.SOUTH);

		this.add(gpsPanel);
	}

	public String getFromCity() {
		return text.getText();

	}

	public String getToCity() {

		return text2.getText();

	}

	public String getChoice() {

		return group.getSelection().getActionCommand();
	}

	public void addSearchListener(ActionListener search) {

		searchButton.addActionListener(search);

	}

	public void addGoBackListener(ActionListener goBack) {

		this.goBack.addActionListener(goBack);
	}

	public void addMoreInfoListener(ActionListener moreInfo) {

		moreInfoButton.addActionListener(moreInfo);
	}

	public void addNoInfoListener(ActionListener noInfo) {

		noInfoButton.addActionListener(noInfo);
	}

	/**
	 * change laskdlaksdlkasd
	 * 
	 * @param res
	 *            ta in resultat och skriver den i res panel
	 */
	public void showResult(String res, Path path) {
		gpsPanel.setVisible(false);
		resultPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 550);
		JLabel titel = new JLabel("HH-Trafiken");
		resultPanel.add(titel);

		JPanel ChosenWayPanel = new JPanel();
		chosenWay = new JLabel(res);
		ChosenWayPanel.setPreferredSize(new Dimension(400, 20));
		ChosenWayPanel.add(chosenWay);
		resultPanel.add(ChosenWayPanel, BorderLayout.NORTH);

		try {
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("src/van.gif"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setPreferredSize(new Dimension(350, 300));
			resultPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel timePanel = new JPanel();
		timePanel.setPreferredSize(new Dimension(400, 30));
		timePanel.add(time);
		timeOutput.setEditable(false);
		DecimalFormat df = new DecimalFormat("#.##");
		timeOutput.setText("" + df.format(path.getTime()));
		timePanel.add(timeOutput);
		timePanel.add(min);
		resultPanel.add(timePanel, BorderLayout.NORTH);

		JPanel distancePanel = new JPanel();
		distancePanel.setPreferredSize(new Dimension(400, 30));
		distancePanel.add(distance);
		distanceOutput.setEditable(false);
		distanceOutput.setText("" + path.getDist());
		distancePanel.add(distanceOutput);
		distancePanel.add(km);
		resultPanel.add(distancePanel, BorderLayout.NORTH);

		JPanel wayPanel = new JPanel();
		wayPanel.setPreferredSize(new Dimension(500, 50));
		wayPanel.add(way);
		startCity = new JLabel(text.getText());
		wayPanel.add(startCity);
		wayPanel.add(arrow);
		desCity = new JLabel(text2.getText());
		wayPanel.add(desCity);
		resultPanel.add(wayPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(400, 50));
		buttonPanel.add(goBack);
		buttonPanel.add(moreInfoButton);
		resultPanel.add(buttonPanel, BorderLayout.NORTH);

		//reateInfo();

		this.add(resultPanel);

	}

	public void createInfo(Path path) {
		infoPanel = new JPanel();
		JPanel inPanel = new JPanel();
		JLabel titel = new JLabel("HH-Trafiken");
		infoPanel.add(titel);
		
		try {
			BufferedImage myPicture;
			myPicture = ImageIO.read(new File("src/van.gif"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setPreferredSize(new Dimension(350, 300));
			infoPanel.add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listModel = new DefaultListModel<String>();
		String[] arr = path.getPath().split(" ");
		for(String s : arr) {
			listModel.addElement(s);
		}
		// Create the list and put it in a scroll pane.
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// list.setSelectedIndex(0);
		//list.setVisibleRowCount(10);
		list.setPreferredSize(new Dimension(300, 400));
		JScrollPane listScrollPane = new JScrollPane(list);
		inPanel.add(listScrollPane);
		infoPanel.add(inPanel);
		infoPanel.add(noInfoButton);

		this.add(infoPanel);

	}

	public void showNoInfo() {
		infoPanel.setVisible(false);
		resultPanel.setVisible(true);

	}

	public void showInfo(Path path) {
		createInfo(path);
		resultPanel.setVisible(false);

	}

	public void showPrev() {
		resultPanel.setVisible(false);
		gpsPanel.setVisible(true);

	}

	public void displayErrorMsg(String errorMsg) {

		JOptionPane.showMessageDialog(this, errorMsg);
	}

	public static void main(String[] args) {
		GpsView gps = new GpsView();
		Graph g = new Graph();
		g.generateGraph("Svealand2");
		GpsController c = new GpsController(gps, g);
		gps.setVisible(true);

	}

}
