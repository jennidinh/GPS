import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

public class GpsController {

	private GpsView theView;
	private Graph theModel;
	private Path path;

	public GpsController(GpsView theView, Graph theModel) {

		this.theView = theView;
		this.theModel = theModel;

		this.theView.addSearchListener(new SearchListener());
		this.theView.addGoBackListener(new GoBackListener());
		this.theView.addMoreInfoListener(new MoreInfoListener());
		this.theView.addNoInfoListener(new NoInfoListener());
	}

	class NoInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.showNoInfo();
		}
	}

	class MoreInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.showInfo(path);
		}
	}

	class GoBackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			theView.showPrev();
		}
	}

	class SearchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String fromCity;
			String toCity;
			String choice;
			try {
				fromCity = theView.getFromCity();
				toCity = theView.getToCity();
				choice = theView.getChoice();
				if (fromCity.equals("") || toCity.equals("")) {
					theView.displayErrorMsg("Skriv in två städer");
				}

				else if (choice.equals("Kortaste")) {

					try {
						path = theModel.findShortestPath(fromCity, toCity);
						theView.showResult("Kortaste vägen", path);
					} catch (NoSuchElementException err) {
						theView.displayErrorMsg("Skriv in en giltig stad");

					}

				}

				else if (choice.equals("Snabbaste")) {

					try {
						path = theModel.findFastestPath(fromCity, toCity);
						theView.showResult("Snabbaste vägen", path);
					} catch (NoSuchElementException err) {
						theView.displayErrorMsg("Skriv in en giltig stad");

					}

				}

			} catch (Exception e2) {
				System.out.println(e2);
				theView.displayErrorMsg("Välj korstaste- eller snabbaste vägen");
			}
		}
	}
}
