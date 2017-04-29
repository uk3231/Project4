import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JDialog;

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
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){}
	
	public void setSelectionView(SelectionView selectionView){}
	
	private void loadNewsData(){}
	
	private void saveNewsData(){}
	
	private void importNoozStories(){}
	
	private void exportNewsStories(){}
	
	private void addNewsMaker(){}
	
	private void editNewsMakers(){}
	
	private void deleteNewsMakers(){}
	
	private void deleteNewsMakerList(){}
	
	private void addNewsStory(){}
	
	private void editNewsStories(){}
	
	private void sortNewsStories(){}
	
	private void deleteNewsStories(){}
	
	private void deleteAllNewsStories(){}
	
	private void displayPieCharts(){}
	
	private void displayTextViews(){}
	
	private class FileMenuListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}

	private class NewsMakerMenuListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}

	private class NewsStoryMenuListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	private class DisplayMenuListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	public class EditNewsMakerNameListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	public class RemoveNewsMakerFromNewsStoriesListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	public class AddEditNewsStoryListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	public class MediaTypeSelectionListener{
		public void actionPerformed(ActionEvent actionEvent){}
	}
	
	
}