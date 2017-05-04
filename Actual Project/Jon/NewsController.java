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
	
	//https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
	private void addNewsMaker(){
		JFrame frame = new JFrame();
		String name = (String)JOptionPane.showInputDialog(frame, "Enter the news maker name.", 
				"News Maker Name", JOptionPane.QUESTION_MESSAGE, null, null,"");	
		NewsMakerModel newsMakerModel = new NewsMakerModel(name);
		if(!newsDataBaseModel.containsNewsMakerModel(newsMakerModel)){
			newsDataBaseModel.addNewsMakerModel(newsMakerModel);
		}
		else{
			int toReplace = JOptionPane.showConfirmDialog(frame, "Would you like to replace"
					+ "the existing news maker of this name?", "News Maker Already Exists",
					JOptionPane.YES_NO_OPTION);
			if(JOptionPane.YES_OPTION == toReplace){
				newsDataBaseModel.replaceNewsMakerModel(newsMakerModel);
			}
		}
	}
	
	private void editNewsMakers(){}
	
	private void deleteNewsMakers(){
		if(0 == selectionView.getSelectedNewsMakers().length){
			JOptionPane.showMessageDialog(null, "No news makers are selected.");
			return;
		}
		
		int[] selectedIndices = selectionView.getSelectedNewsMakers();
		
		for(int i = 0; i < selectedIndices.length; i++){
			NewsMakerModel toRemove = newsDataBaseModel.getNewsMakerListModel().get(selectedIndices[i]);
			NewsStoryListModel toBeCleared = toRemove.getNewsStoryListModel();
			
			for(int j = 0; j<toBeCleared.size(); ++j){
				NewsStory newsStory = toBeCleared.get(j);
				// if the first newsmaker is 
				if(newsStory.getNewsMaker1().equals(editNewsMakerView.newsMakerModel)){
					newsStory.getNewsMaker1().removeNewsStory(newsStory);
					newsStory.setNewsMaker1(newsDataBaseModel.none);
					newsDataBaseModel.none.addNewsStory(newsStory);
				}
				else if(newsStory.getNewsMaker2().equals(editNewsMakerView.newsMakerModel)){
					newsStory.getNewsMaker2().removeNewsStory(newsStory);
					newsStory.setNewsMaker2(newsDataBaseModel.none);
					newsDataBaseModel.none.addNewsStory(newsStory);
				}
			}
			newsDataBaseModel.getNewsMakerListModel().remove(toRemove);
		}
	}
	
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
			String name = editNewsMakerView.jtfName.getText();
			
			// if we don't already have a newsmaker  with this name, change its name
			// and resort
			if(!newsDataBaseModel.containsNewsMakerModel(new NewsMakerModel(name))){
				editNewsMakerView.newsMakerModel.setName(name);
				newsDataBaseModel.getNewsMakerListModel().sort();
			}
			// if it is already there, then ask if it should be replaced
			else{
				int toReplace = JOptionPane.showConfirmDialog(null, "Would you like to replace" // TODO figure out the frame
						+ "the existing news maker of this name?", "News Maker Already Exists",
						JOptionPane.YES_NO_OPTION);
				if(JOptionPane.YES_OPTION == toReplace){
					NewsMakerModel oldNewsMaker = newsDataBaseModel.getNewsMakerListModel().get(new NewsMakerModel(name));
					for(int i; i < oldNewsMaker.getNewsStoryListModel().size(); i++){
						NewsStory newsStory = oldNewsMaker.getNewsStoryListModel().get(i);
						
						// if the first newsmaker is the same
						if(newsStory.getNewsMaker1.equals(editNewsMakerView.newsMakerModel)){
							newsStory.getNewsMaker1.remove(newsStory);
							newsStory.setNewsMaker1(newsDataBaseModel.none);
							newsDataBaseModel.none.addNewsStory(newsStory);
						}
						else if(newsStory.getNewsMaker2.equals(editNewsMakerView.newsMakerModel)){
							newsStory.getNewsMaker2.remove(newsStory);
							newsStory.setNewsMaker2(newsDataBaseModel.none);
							newsDataBaseModel.none.addNewsStory(newsStory);
						}
					}
					newsDataBaseModel.getNewsMakerListModel().remove(oldNewsMaker);
					
					editNewsMakerView.newsMakerModel.setName(name);
				}
			}
		}
	}
	
	public class RemoveNewsMakerFromNewsStoriesListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent){
			// get the stories that were selected for the newsmaker
			int[] selectedIndicies = editNewsMakerView.getSelectedNewsStoryIndices();

			// get the stories that were selected for the newsmaker
			int[] selectedIndices = editNewsMakerView.getSelectedNewsStoryIndices();

			// loops through the list of indices and gets the associated story
			for(int i = 0; i < selectedIndices.length; i++){
				NewsStory newsStory = editNewsMakerView.newsMakerModel.getNewsStoryListModel().get(selectedIndices[i]);

				// if the first newsmaker is 
				if(newsStory.getNewsMaker1().equals(editNewsMakerView.newsMakerModel)){
					newsStory.getNewsMaker1().removeNewsStory(newsStory);
					newsStory.setNewsMaker1(newsDataBaseModel.none);
					newsDataBaseModel.none.addNewsStory(newsStory);
				}
				else if(newsStory.getNewsMaker2().equals(editNewsMakerView.newsMakerModel)){
					newsStory.getNewsMaker2().removeNewsStory(newsStory);
					newsStory.setNewsMaker2(newsDataBaseModel.none);
					newsDataBaseModel.none.addNewsStory(newsStory);
				}
			}
		}
	}
	
	public class AddEditNewsStoryListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) throws IllegalArgumentException {
			// get data from the panel after they push the button
			NewsMedia newsMedia = (NewsMedia) addEditNewsStoryView.jcbNewsStoryType.getSelectedItem();
			String source = (String) addEditNewsStoryView.jcbNewsStorySource.getSelectedItem();
			String topic = (String) addEditNewsStoryView.jcbNewsStoryTopic.getSelectedItem();
			String subject = (String) addEditNewsStoryView.jcbNewsStorySubject.getSelectedItem();
			String newsMaker1Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker1.getSelectedItem();
			String newsMaker2Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker2.getSelectedItem();
			
			// error checking, if the names are the same, throw illegal arugment exception
			if(newsMaker1Name.equals(newsMaker2Name) && !newsMaker1Name.equals("None")){
				throw new IllegalArgumentException();
			}
			
			int length = ((Number) addEditNewsStoryView.jftfNewsStoryLength.getValue()).intValue();
			int year = (Integer)addEditNewsStoryView.jcbNewsStoryYear.getSelectedItem();
			Month month = (Month) addEditNewsStoryView.jcbNewsStoryMonth.getSelectedItem();
			int day = (Integer) addEditNewsStoryView.jcbNewsStoryDay.getSelectedItem();

			/*
			 * Makes the newsmakers if they are not already made
			 * or uses the copy already in the list
			 * The first news maker is constructed based on the first news maker
			 * name read.
			 */
			NewsMakerModel newsMakerModel1 = new NewsMakerModel(newsMaker1Name);
			// If the news maker is on the list, use the copy already on the list
			if (newsDataBaseModel.containsNewsMakerModel(newsMakerModel1)) {
				newsMakerModel1 = newsDataBaseModel.getNewsMakerListModel.get(newsMakerModel1);
			}
			// Otherwise, add the new news maker to the list
			else {
				newsDataBaseModel.addNewsMakerModel(newsMakerModel1);
			}

			/*
			 * The second news maker is constructed based on the second news maker
			 * name read.
			 */
			NewsMakerModel newsMakerModel2 = new NewsMakerModel(newsMaker2Name);
			// If the news maker is on the list, use the copy already on the list
			if (newsDataBaseModel.containsNewsMakerModel(newsMakerModel2)) {
				newsMakerModel2 = newsDataBaseModel.getNewsMakerListModel.get(newsMakerModel2);
			}
			// Otherwise, add the new news maker to the list
			else {
				newsDataBaseModel.addNewsMakerModel(newsMakerModel2);
			}
				
			
			// make the localDate
			LocalDate date = LocalDate.of(year, month, day);
			
			// if we are adding a story, we construct a new story
			// TODO check if the constructor is right
			if(actionEvent.getActionCommand().equals("Add News Story")){
				NewsStory newsStory = new NewsStory(date, 
									source,
									length,
									subject,
									newsMakerModel1,
									newsMakerModel2);
				newsMakerModel1.addNewsStory(newsStory);
				newsMakerModel2.addNewsStory(newsStory);
				newsDataBaseModel.addNewsStory(newsStory);
			} 
			// otherwise, we should edit the fields of the story
			else if(actionEvent.getActionCommand().equals("Edit News Story")){
				if(editedNewsStory != null){
					// first, remove the news stories from the original newsmakers
					editedNewsStory.getNewsMaker1().removeNewsStory(editedNewsStory);
					editedNewsStory.getNewsMaker2().removeNewsStory(editedNewsStory);
					
					// change the other fields
					editedNewsStory.setDate(date);
					editedNewsStory.setSource(source);
					editedNewsStory.setLength(length);
					editedNewsStory.setTopic(topic);
					editedNewsStory.setSubject(subject);
					editedNewsStory.setNewsMaker1(newsMakerModel1);
					editedNewsStory.setNewsMaker2(newsMakerModel2);
				}
			}
			
			viewDialog.dispose();
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
