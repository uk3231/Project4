import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NewsController {
	
	private NewsDataBaseModel newsDataBaseModel;
	
	private SelectionView selectionView;
	
	private EditNewsMakerView editNewsMakerView;
	
	private JDialog viewDialog;
	
	private AddEditNewsStoryView addEditNewsStoryView;
	
	private NewsStory editedNewsStory;
	
	private MediaTypeSelectionView mediaTypeSelectionView;
	
	private List<NewsMedia> selectedMediaTypes;
	
	public NewsController(){}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
	}
	
	public void setSelectionView(SelectionView selectionView){
		this.selectionView = selectionView;
	}
	
	private void loadNewsData(){
		JFileChooser fileChooser;
	}
	
	private void saveNewsData(){}
	
	private void importNoozStories(){}
	
	private void exportNewsStories(){}
	
	private void addNewsMaker(){}
	
	private void editNewsMakers(){}
	
	private void deleteNewsMakers(){}
	
	private void deleteNewsMakerList(){}
	
	private void addNewsStory(){}
	
	private void editNewsStories(){
		
	}
	
	private void sortNewsStories(){
		
	}
	
	private void deleteNewsStories(){
	}
	
	private void deleteAllNewsStories(){
		newsDataBaseModel.removeAllNewsStories();
	}
	
	/**
	 * This method is called to display pie charts when requested by the user.
	 * It gets the list of all selected news makers from the
	 * <code>SectionView</code> and displays one pie chart per news maker. For
	 * each pie chart it needs to determine the media type(s) to display, the
	 * news content type to display, and the news metric to use for display.
	 */
	private void displayPieCharts() {
		// Get the indices of the news makers selected in the selection view.
		int[] indices = selectionView.getSelectedNewsMakers();
		
		// If there are no selected news makers, alert the user and return.
		if (0 == indices.length) {
			JOptionPane.showMessageDialog(selectionView, "No newsmaker selected.", "Invalid Selection",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// If there are selected news makers, go through the process for each.
			NewsMakerListModel newsMakerListModel = this.newsDataBaseModel.getNewsMakerListModel();
			for (int index : indices) {
				NewsMakerModel newsMakerModel = newsMakerListModel.get(index);
				String newsMakerName = newsMakerModel.getName();

				// Get media types using MediaTypeSelectionView.
				this.selectedMediaTypes = null;
				this.mediaTypeSelectionView = new MediaTypeSelectionView();
				MediaTypeSelectionListener mediaTypeSelectionListener = new MediaTypeSelectionListener();
				this.mediaTypeSelectionView.jbOkay.addActionListener(mediaTypeSelectionListener);
				this.mediaTypeSelectionView.jbCancel.addActionListener(mediaTypeSelectionListener);

				this.viewDialog = new JDialog(selectionView, newsMakerName, true);
				this.viewDialog.add(mediaTypeSelectionView);
				this.viewDialog.setResizable(false);
				this.viewDialog.pack();
				this.viewDialog.setVisible(true);

				// If no media types were selected, go on to next news maker.
				if (null == this.selectedMediaTypes) {
					continue;
				}

				// Get content type using JOptionPane.
				NewsContent selectedNewsContent = null;
				selectedNewsContent = (NewsContent) JOptionPane.showInputDialog(selectionView,
						"Graph news stories based on which content?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
						NewsContent.values(), NewsContent.TOPIC);
				if (null == selectedNewsContent) {
					continue;
				}

				// Get metric type using JOPtionPane.
				NewsMetric selectedNewsMetric = null;
				selectedNewsMetric = (NewsMetric) JOptionPane.showInputDialog(selectionView,
						"Graph news stories based on which metric?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
						NewsMetric.values(), NewsMetric.LENGTH);
				if (null == selectedNewsMetric) {
					continue;
				}

				// Create the pie chart.
				PieChartView pieChartView = new PieChartView(newsMakerModel, selectedMediaTypes, selectedNewsContent,
						selectedNewsMetric);
				
				//Make sure the pie chart listens for model changes so that it can update itself.
				newsMakerModel.addActionListener(pieChartView);
			}
		}
	}	
	
	private void displayTextViews(){
		
	}
	
	private class FileMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			String command = actionEvent.getActionCommand();
			if(command.equals("Load")){
				
				JFileChooser fileChooser = new JFileChooser();
				
				
			}
			else if(command.equals("Save")){
				
			}
			else if(command.equals("Import")){
				
			}
			else if(command.equals("Export")){
				
			}
		}
	}

	private class NewsMakerMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}

	private class NewsStoryMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}
	
	private class DisplayMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}
	
	public class EditNewsMakerNameListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}
	
	public class RemoveNewsMakerFromNewsStoriesListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}
	
	public class AddEditNewsStoryListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			
		}
	}
	
	/**
	 * <code>MediaTypeSelectionListener</code> is an inner class (within
	 * <code>NewsController</code>) to listen for actions from a
	 * <code>MediaTypeSelectionView</code>. It has one method that does all the
	 * work -- the overridden <code>actionPerformed</code> method -- which is
	 * called when there is a relevant <code>actionEvent</code>.
	 * 
	 * @author Dean Hougen
	 * @version 1.0
	 *
	 */
	public class MediaTypeSelectionListener implements ActionListener {
		/**
		 * The overridden <code>actionPerformed</code> method that does all of
		 * the work. If the user indicates their selections are "OK" (the
		 * <code>actionCommand</code> is "OK"), it queries each
		 * <code>JCheckBox</code> of the <code>MediaTypeSelectionView</code> to
		 * see if it was selected. If so, it adds the corresponding
		 * <code>NewsMedia</code> type to the <code>selectedMediaTypes</code>
		 * list. If no check boxes were selected, it warns the user of this
		 * fact. Once it has extracted the relevant information from the
		 * <code>MediaTypeSelectionView</code>, it disposes of that view, which
		 * closes the modal window and allows the user to interact with other
		 * windows in <code>Nooz</code>.
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			selectedMediaTypes = new LinkedList<NewsMedia>();
			if ("OK".equals(actionEvent.getActionCommand())) {
				if (mediaTypeSelectionView.jcbNewspaper.isSelected()) {
					selectedMediaTypes.add(NewsMedia.NEWSPAPER);
				}
				if (mediaTypeSelectionView.jcbTVNews.isSelected()) {
					selectedMediaTypes.add(NewsMedia.TV);
				}
				if (mediaTypeSelectionView.jcbOnline.isSelected()) {
					selectedMediaTypes.add(NewsMedia.ONLINE);
				}
				if (null == selectedMediaTypes) {
					JOptionPane.showMessageDialog(selectionView, "No media type selected.", "Invalid Selection",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			viewDialog.dispose();
		}
	}
		
}
