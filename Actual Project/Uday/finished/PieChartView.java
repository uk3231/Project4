import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Uday Kohli, Dr. Hougen, Jon Kunjummen
 * 
 * Uday modified Dr. Hougen's code to make this class
 * Jon helped with lots of debugging
 * 
 * (btw, Jon, we may have to do a lot of debugging here)
 *
 */
public class PieChartView implements ActionListener{
	private PieChart pieChart;
	
	private NewsMakerModel newsMakerModel;
	
	private String media;
	
	private String content;
	
	private String measure;
	
	
	public PieChartView(NewsMakerModel newsMakerModel, List<NewsMedia> newsMedia, 
			NewsContent content, NewsMetric measure){
		this.newsMakerModel = newsMakerModel;
		
		// its a little complicated to construct media if there is a list of 
		// media enums that are passed to the constructor
		this.media = "";

		// if all three news media are used, then add nothng to the media type 
		if(newsMedia.size() == 3){
		} else if(newsMedia.size() == 2){
			// add the two media types with a slash
			media += newsMedia.get(0).toString() + "/" + newsMedia.get(1).toString();
		} else if(newsMedia.size() == 1){
			// add the one media type
			media = newsMedia.get(0).toString();
		} // there shouldn't be any other options

		this.content = content.toString();
		this.measure = measure.toString();
		
		List<Wedge> wedges = constructWedges();
		String title = constructTitle();
		
		pieChart = new PieChart(title, wedges);
	}
	
	/**
	 * Helper method to construct the title for the view. 
	 * The title consists of the news maker name, the specific news media types displayed 
	 * (unless all possible media types are selected, in which case this is omitted), 
	 * the content type displayed, and the metric used.

	 * @return the title
	 */
	private String constructTitle(){
		String title = newsMakerModel.getName() + " - " + 
				media + " " + content + " by " + measure;
		return title;
	}
	
	private List<Wedge> constructWedges(){
		NewsStoryListModel newsStoryList = newsMakerModel.getNewsStoryListModel();

		/* List to hold a copy of the relevant data. */
		List<NewsStory> selectedNewsStories = new ArrayList<NewsStory>();

		// Select the news stories of the media type(s) requested.
		for (int i = 0; i < newsStoryList.size(); i++) {
			NewsStory newsStory = newsStoryList.get(i);
			if ((media.contains(NewsMedia.NEWSPAPER) && newsStory instanceof NewspaperStory)
					|| (media.contains(NewsMedia.TV) && newsStory instanceof TVNewsStory)
					|| (media.contains(NewsMedia.ONLINE) && newsStory instanceof OnlineNewsStory)) {
				selectedNewsStories.add(newsStory);
			}
		}

		/*
		 * Map to keep track of the items found and the quantity for each (for
		 * the pie chart wedges). Note that the items could be sources, topics,
		 * or subjects and the quantity could be measured by length or count.
		 */
		Map<String, Integer> itemNameQuantityMap = new TreeMap<String, Integer>();

		/* Need total to determine percentage. */
		int totalQuantity = 0;

		// Run through all the selected stories to add up values.
		for (NewsStory newsStory : selectedNewsStories) {

			/* Get items of the correct content type. */
			String itemName = null;
			if ("source".equalsIgnoreCase(content.toString())) {
				itemName = newsStory.getSource();
			} else if ("topic".equalsIgnoreCase(content.toString())) {
				itemName = newsStory.getTopic();
			} else if ("subject".equals(content.toString())) {
				itemName = newsStory.getSubject();
			} // TODO: Check for invalid content type

			/*
			 * Need variable to hold quantity of item. If this item has not been
			 * added previously, we'll want to add it to the map with a starting
			 * quantity. If it is already in the map, we'll want to add to its
			 * previous quantity.
			 */
			Integer itemQuantity = itemNameQuantityMap.get(itemName);

			// If the measure is count, we'll just add one.
			if ("count".equalsIgnoreCase(measure.toString())) {
				if (itemQuantity == null) {
					itemNameQuantityMap.put(itemName, 1);
				} else {
					itemNameQuantityMap.put(itemName, itemQuantity + 1);
				}
				totalQuantity++;
			}
			// If the measure is length, we'll need to add the length.
			else if ("length".equalsIgnoreCase(measure.toString())) {
				int addedQuantity = newsStory.getLengthInWords();
				if (itemQuantity == null) {
					itemNameQuantityMap.put(itemName, addedQuantity);
				} else {
					itemNameQuantityMap.put(itemName, itemQuantity + addedQuantity);
				}
				totalQuantity += addedQuantity;
			} // TODO: Check for invalid measure count.
		}

		/* List of pie wedges to put in the chart. */
		List<Wedge> wedges = new ArrayList<Wedge>();

		/*
		 * The scaling factor takes into account the total quantity and the fact
		 * that wedges require percentages.
		 */
		double scale = totalQuantity / 100.0;

		// Take the data from the map and put it into the list of wedges.
		for (Map.Entry<String, Integer> entry : itemNameQuantityMap.entrySet()) {
			wedges.add(new Wedge(entry.getValue() / scale, entry.getKey()));
		}
		
		return wedges;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Overridden actionPerformed method 
	 * (called when listener is notified of an update by the model). 
	 * Constructs new title and wedges and repaints the pie chart.
	 * 
	 * TODO not sure if this will work
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String title = constructTitle();
		List<Wedge> wedges = constructWedges();
		
		pieChart.repaint();
	}
}
