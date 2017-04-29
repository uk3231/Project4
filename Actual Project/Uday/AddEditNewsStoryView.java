import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddEditNewsStoryView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NewsDataBaseModel newsDataBaseModel;
	
	private NewsStory newsStory;
	
	private JLabel jlbNewsStoryType = new JLabel("News Story Type");
	
	/*defualt*/ JComboBox<NewsMedia> jcbNewsStoryType = new JComboBox<NewsMedia>();
	
	private JPanel jplNewsStoryType = new JPanel();
	
	private JLabel jlbNewsStorySource = new JLabel("News Story Source");
	
	/*defualt*/ JComboBox<String> jcbNewsStorySource = new JComboBox<String>();
	
	private JPanel jplNewsStorySource = new JPanel();
	
	private JLabel jlbNewsStoryTopic = new JLabel("News Story Topic");
	
	/*defualt*/ JComboBox<String> jcbNewsStoryTopic = new JComboBox<String>();
	
	private JPanel jplNewsStoryTopic = new JPanel();
	
	private JLabel jlbNewsStorySubject = new JLabel ("News Story Subject");
	
	/*defualt*/ JComboBox<String> jcbNewsStorySubject = new JComboBox<String>();
	
	private JPanel jplNewsStorySubject = new JPanel();
	
	private JLabel jlbNewsStoryNewsMaker1 = new JLabel("News Story News Maker 1");
	
	/*defualt*/ JComboBox<String> jcbNewsStoryNewsMaker1 = new JComboBox<String>();
	
	private JPanel jpNewsStoryNewsMaker1 = new JPanel();
	
	private JLabel jlbNewsStoryNewsMaker2 = new JLabel("News Story News Maker 2");
	
	/*defualt*/ JComboBox<String> jcbNewsStoryNewsMaker2 = new JComboBox<String>();
	
	private JPanel jplNewsStoryNewsMaker2 = new JPanel();
	
	private JLabel jlbNewsStoryLength = new JLabel("News Story Length");
	
	private NumberFormat integerFieldFormatter; //TODO fix this
	
	/*defualt*/ JFormattedTextField jftfNewsStoryLength = new JFormattedTextField(integerFieldFormatter);
		
	private JPanel jplNewsStoryLength = new JPanel();
	
	private JLabel jlbNewsStoryYear = new JLabel("News Story year");
	
	private Integer[] years;
	
	/*defualt*/ JComboBox<Integer> jcbNewsStoryYear = new JComboBox<Integer>();
	
	private JPanel jplNewsStoryYear = new JPanel();
	
	private JLabel jlbNewsStoryMonth = new JLabel("News Story Month");
	
	/*defualt*/ JComboBox<Month> jcbNewsStoryMonth = new JComboBox<Month>();
	
	private JPanel jplNewsStoryMonth = new JPanel();
	
	private JLabel jlbNewsStoryDay = new JLabel("News Story Day");
	
	private Integer[] days;
	
	/*defualt*/ JComboBox<Integer> jcbNewsStoryDay = new JComboBox<Integer>();
	
	private JPanel jplNewsStoryDay = new JPanel();
	
	private JLabel jlbNewsStoryPartOfDay = new JLabel("News Story Part of Day");
	
	/*defualt*/ JComboBox<PartOfDay> jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>();
	
	private JPanel jplNewsStoryPartOfDay = new JPanel();
	
	private JPanel jplNewsStoryWhen = new JPanel();
	
	/*defualt*/ JButton jbtAddEditNewsStory = new JButton("Add Edit News Story");
	
	private JPanel jplAddEditNewsStory = new JPanel();
	
	public AddEditNewsStoryView(NewsDataBaseModel newsDataBaseModel, NewsStory newsStory){
		//TODO 
	}
	
	
}
