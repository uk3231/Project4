import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextView implements ActionListener{
	
	private JFrame jfText = new JFrame();
	
	private NewsMakerModel newsMakerModel;
	
	private List<NewsMedia> newsMedia;
	
	private List<SortCriterion> sortCriteria;
	
	private String listOfStories;
	
	private String summaryLine;
	
	private JTextArea jtaNewsStoryList = new JTextArea(); 
	
	private JScrollPane jspNewsStoryList = new JScrollPane();
	
	private JTextArea jtaSummaryLine = new JTextArea();
	
	
	public TextView(NewsMakerModel newsMakerModel, 
			List<NewsMedia> newsMedia, 
			List<SortCriterion> sortCriteria){
		
	}
	
	private void constructNewsStoriesAndSummary(){
		
	}
	
	private String constructTitle(){
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}
}
