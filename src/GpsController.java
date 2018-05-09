import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GpsController {

	private GpsView theView;
	private Graph theModel;

	public GpsController(GpsView theView, Graph theModel) {

		this.theView = theView;
		this.theModel = theModel;

		this.theView.addSearchListener(new SearchListener());
	}

	class SearchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String fromCity = "";
			String toCity = "";
			String choice;
			try {
				fromCity = theView.getFromCity();
				toCity = theView.getToCity();
				choice = theView.getChoice();

				if (choice.equals("kortaste")) {
					theModel.findShortestPath();
				} else if (choice.equals("snabbaste")) {
					theModel.findFastestPath();

				} else {
					theView.displayErrorMsg("Välj korstaste- eller snabbaste vägen");
				}

			} catch (Exception e2) {
				theView.displayErrorMsg("Skriv två städer");
			}

		}

	}

}
