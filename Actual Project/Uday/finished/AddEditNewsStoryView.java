import java.awt.GridLayout;
import java.text.NumberFormat;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Uday kohli, Dr. Hougen, Jon Kunjummen
 * 
 * TODO
 * Jon, I had no way to test this class out, but I feel like it should only 
 * need small tweaking from here
 * 
 * also, I feel like there should be a method to register an action listener on 
 * the button, but i'm not 100% sure. 
 */
public class AddEditNewsStoryView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NewsDataBaseModel newsDataBaseModel;
	private NewsStory newsStory;

	private JLabel jlbNewsStoryType = new JLabel("News Story Type");
	/*defualt*/ JComboBox<NewsMedia> jcbNewsStoryType;
	private JPanel jplNewsStoryType;

	private JLabel jlbNewsStorySource = new JLabel("News Story Source");
	/*defualt*/ JComboBox<String> jcbNewsStorySource;
	private JPanel jplNewsStorySource;

	private JLabel jlbNewsStoryTopic = new JLabel("News Story Topic");
	/*defualt*/ JComboBox<String> jcbNewsStoryTopic;
	private JPanel jplNewsStoryTopic;

	private JLabel jlbNewsStorySubject = new JLabel ("News Story Subject");
	/*defualt*/ JComboBox<String> jcbNewsStorySubject;
	private JPanel jplNewsStorySubject;

	private JLabel jlbNewsStoryNewsMaker1 = new JLabel("News Story News Maker 1");
	/*defualt*/ JComboBox<String> jcbNewsStoryNewsMaker1;
	private JPanel jplNewsStoryNewsMaker1;

	private JLabel jlbNewsStoryNewsMaker2 = new JLabel("News Story News Maker 2");
	/*defualt*/ JComboBox<String> jcbNewsStoryNewsMaker2;
	private JPanel jplNewsStoryNewsMaker2;

	private JLabel jlbNewsStoryLength = new JLabel("News Story Length");
	private NumberFormat integerFieldFormatter = NumberFormat.getIntegerInstance();
	/*defualt*/ JFormattedTextField jftfNewsStoryLength = 
			new JFormattedTextField(integerFieldFormatter);
	private JPanel jplNewsStoryLength;

	private JLabel jlbNewsStoryYear = new JLabel("News Story year");
	private Integer[] years;
	/*defualt*/ JComboBox<Integer> jcbNewsStoryYear = new JComboBox<Integer>();
	private JPanel jplNewsStoryYear;

	private JLabel jlbNewsStoryMonth = new JLabel("News Story Month");
	/*defualt*/ JComboBox<Month> jcbNewsStoryMonth = new JComboBox<Month>();
	private JPanel jplNewsStoryMonth;

	private JLabel jlbNewsStoryDay = new JLabel("News Story Day");
	private Integer[] days;
	/*defualt*/ JComboBox<Integer> jcbNewsStoryDay = new JComboBox<Integer>();
	private JPanel jplNewsStoryDay;

	private JLabel jlbNewsStoryPartOfDay = new JLabel("News Story Part of Day");
	/*defualt*/ JComboBox<PartOfDay> jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>();
	private JPanel jplNewsStoryPartOfDay;

	private JPanel jplNewsStoryWhen;

	/*defualt*/ JButton jbtAddEditNewsStory;
	private JPanel jplAddEditNewsStory;

	/**
	 * constructor for AddEditNewsStoryView
	 * @param newsDataBaseModel 
	 * @param newsStory
	 */
	public AddEditNewsStoryView(NewsDataBaseModel newsDataBaseModel, NewsStory newsStory){

		this.newsDataBaseModel = newsDataBaseModel;
		this.newsStory = newsStory;

		/* there are two different types of views that this class should be able to make
		 * the first is the "Add" view, which should be created if the newsStory passed 
		 * to this constructor is null
		 * 
		 * the other type is the "edit" view, which should be created if the newsStory is 
		 * not null
		 * 
		 * the "add" view will have empty fields whereas the edit view will be filled
		 */
		if(newsStory == null){

			// makes the panel for news story type, and adds label and combo box
			jplNewsStoryType = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryType.add(jlbNewsStoryType);
			jcbNewsStoryType = new JComboBox<NewsMedia>(NewsMedia.values());
			jplNewsStoryType.add(jcbNewsStoryType);

			// makes panel for source, adds label and editable combo box
			jplNewsStorySource = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStorySource.add(jlbNewsStorySource);
			jcbNewsStorySource = new JComboBox<String>(newsDataBaseModel.getNewsSources());
			jcbNewsStorySource.setEditable(true);
			jplNewsStorySource.add(jcbNewsStorySource);

			// makes panel for topic, adds label and editable combo box
			jplNewsStoryTopic = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryTopic.add(jlbNewsStoryTopic);
			jcbNewsStoryTopic = new JComboBox<String>(newsDataBaseModel.getNewsTopics());
			jcbNewsStoryTopic.setEditable(true);
			jplNewsStoryTopic.add(jcbNewsStoryTopic);

			// makes panel for subject, adds label and editable combo box
			jplNewsStorySubject = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStorySubject.add(jlbNewsStorySubject);
			jcbNewsStorySubject = new JComboBox<String>(newsDataBaseModel.getNewsSubjects());
			jcbNewsStorySubject.setEditable(true);
			jplNewsStorySubject.add(jcbNewsStorySubject);

			// makes panel for news maker 1, adds label and editable combo box
			jplNewsStoryNewsMaker1 = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryNewsMaker1.add(jlbNewsStoryNewsMaker1);
			jcbNewsStoryNewsMaker1 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
			jcbNewsStoryNewsMaker1.setEditable(true);
			jplNewsStoryNewsMaker1.add(jcbNewsStoryNewsMaker1);

			// makes panel for news maker 2, adds label and editable combo box
			jplNewsStoryNewsMaker2 = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryNewsMaker2.add(jlbNewsStoryNewsMaker2);
			jcbNewsStoryNewsMaker2 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
			jcbNewsStoryNewsMaker2.setEditable(true);
			jplNewsStoryNewsMaker2.add(jcbNewsStoryNewsMaker2);

			// makes panel for lenght, addes label and formatted text field
			jplNewsStoryLength = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryLength.add(jlbNewsStoryLength);
			jftfNewsStoryLength.setEditable(true);
			jplNewsStoryLength.add(jftfNewsStoryLength);

			// makes panel for year, populates array of Integers, adds combo box and label
			jplNewsStoryYear = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryYear.add(jlbNewsStoryYear);
			years = new Integer[18];
			for(int i = 0; i < 18; i++){
				years[i] = 2000 + i;
			}
			jcbNewsStoryYear = new JComboBox<Integer>(years);
			jplNewsStoryYear.add(jcbNewsStoryYear);

			// makes panel for month, adds label and combo box
			jplNewsStoryMonth = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryMonth.add(jlbNewsStoryMonth);
			jcbNewsStoryMonth = new JComboBox<Month>(Month.values()); //TODO does this work? or do we have to use our own enum?
			jplNewsStoryMonth.add(jcbNewsStoryMonth);

			// makes panel for day, populats array, adds label and combo box
			jplNewsStoryDay = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryDay.add(jlbNewsStoryDay);
			days = new Integer[31];
			for(int i = 1; i < 32; i++){
				days[i-1] = i;
			}
			jcbNewsStoryDay = new JComboBox<Integer>(days);
			jplNewsStoryDay.add(jcbNewsStoryDay);

			// makes panel for part of day, adds label and combo box
			jplNewsStoryPartOfDay = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryPartOfDay.add(jlbNewsStoryPartOfDay);
			jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>(PartOfDay.values());
			jplNewsStoryPartOfDay.add(jcbNewsStoryPartOfDay);

			// makes panel for when, which includes year, month, day, and part of day panels
			jplNewsStoryWhen = new JPanel(new GridLayout(0, 1, 5, 5));
			jplNewsStoryWhen.add(jplNewsStoryYear);
			jplNewsStoryWhen.add(jplNewsStoryMonth);
			jplNewsStoryWhen.add(jplNewsStoryDay);
			jplNewsStoryWhen.add(jplNewsStoryPartOfDay);

			// makes panel for button
			jplAddEditNewsStory = new JPanel(new GridLayout(1, 0, 5, 5));
			jbtAddEditNewsStory = new JButton("Add News Story");
			jplAddEditNewsStory.add(jbtAddEditNewsStory);

			// Set up the content pane and add all the panels to it.
			setLayout(new GridLayout(0, 1, 5, 5));
			add(jplNewsStoryType);
			add(jplNewsStorySource);
			add(jplNewsStoryTopic);
			add(jplNewsStorySubject);
			add(jplNewsStoryNewsMaker1);
			add(jplNewsStoryNewsMaker2);
			add(jplNewsStoryLength);
			add(jplNewsStoryWhen);
			add(jplAddEditNewsStory);	
			setVisible(true);
			
		} else{
			// makes the panel for news story type, and adds label and combo box
			jplNewsStoryType = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryType.add(jlbNewsStoryType);
			jcbNewsStoryType = new JComboBox<NewsMedia>(NewsMedia.values());
			// selects the value for the current news story
			if(newsStory instanceof NewspaperStory){
				jcbNewsStoryType.setSelectedItem(NewsMedia.NEWSPAPER);
			} else if(newsStory instanceof TVNewsStory){
				jcbNewsStoryType.setSelectedItem(NewsMedia.TV);
			} else {
				jcbNewsStoryType.setSelectedItem(NewsMedia.ONLINE);
			}
			jplNewsStoryType.add(jcbNewsStoryType);

			// makes panel for source, adds label and editable combo box
			jplNewsStorySource = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStorySource.add(jlbNewsStorySource);
			jcbNewsStorySource = new JComboBox<String>(newsDataBaseModel.getNewsSources());
			jcbNewsStorySource.setEditable(true);
			// selects the current story's source
			jcbNewsStorySource.setSelectedItem(newsStory.getSource());
			jplNewsStorySource.add(jcbNewsStorySource);

			// makes panel for topic, adds label and editable combo box
			jplNewsStoryTopic = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryTopic.add(jlbNewsStoryTopic);
			jcbNewsStoryTopic = new JComboBox<String>(newsDataBaseModel.getNewsTopics());
			jcbNewsStoryTopic.setEditable(true);
			// selects the current story's topic
			jcbNewsStoryTopic.setSelectedItem(newsStory.getTopic());
			jplNewsStoryTopic.add(jcbNewsStoryTopic);

			// makes panel for subject, adds label and editable combo box
			jplNewsStorySubject = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStorySubject.add(jlbNewsStorySubject);
			jcbNewsStorySubject = new JComboBox<String>(newsDataBaseModel.getNewsSubjects());
			jcbNewsStorySubject.setEditable(true);
			// selects the current story's subject
			jcbNewsStorySubject.setSelectedItem(newsStory.getSubject());
			jplNewsStorySubject.add(jcbNewsStorySubject);

			// makes panel for news maker 1, adds label and editable combo box
			jplNewsStoryNewsMaker1 = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryNewsMaker1.add(jlbNewsStoryNewsMaker1);
			jcbNewsStoryNewsMaker1 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
			jcbNewsStoryNewsMaker1.setEditable(true);
			// selects the current story's newsmaker 1
			jcbNewsStoryNewsMaker1.setSelectedItem(newsStory.getNewsMaker1());
			jplNewsStoryNewsMaker1.add(jcbNewsStoryNewsMaker1);

			// makes panel for news maker 2, adds label and editable combo box
			jplNewsStoryNewsMaker2 = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryNewsMaker2.add(jlbNewsStoryNewsMaker2);
			jcbNewsStoryNewsMaker2 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
			jcbNewsStoryNewsMaker2.setEditable(true);
			// selects the current story's 
			jcbNewsStoryNewsMaker2.setSelectedItem(newsStory.getNewsMaker2());
			jplNewsStoryNewsMaker2.add(jcbNewsStoryNewsMaker2);

			// makes panel for lenght, addes label and formatted text field
			jplNewsStoryLength = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryLength.add(jlbNewsStoryLength);
			jftfNewsStoryLength.setEditable(true);
			// sets the text to be the same as the news story's length
			jftfNewsStoryLenght.setText(newsStory.getLength()); // TODO does this need to be in word equivalents
			jplNewsStoryLength.add(jftfNewsStoryLength);

			// makes panel for year, populates array of Integers, adds combo box and label
			jplNewsStoryYear = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryYear.add(jlbNewsStoryYear);
			years = new Integer[18];
			for(int i = 0; i < 18; i++){
				years[i] = 2000 + i;
			}
			jcbNewsStoryYear = new JComboBox<Integer>(years);
			// selects the current story's year
			jcbNewsStoryYear.setSelectedItem(new Integer(newsStory.getDate().getYear()));
			jplNewsStoryYear.add(jcbNewsStoryYear);

			// makes panel for month, adds label and combo box
			jplNewsStoryMonth = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryMonth.add(jlbNewsStoryMonth);
			jcbNewsStoryMonth = new JComboBox<Month>(Month.values()); //TODO does this work? or do we have to use our own enum?
			// selects the current story's month
			jcbNewsStoryMonth.setSelectedItem(newsStory.getDate().getMonth());
			jplNewsStoryMonth.add(jcbNewsStoryMonth);

			// makes panel for day, populats array, adds label and combo box
			jplNewsStoryDay = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryDay.add(jlbNewsStoryDay);
			days = new Integer[31];
			for(int i = 1; i < 32; i++){
				days[i-1] = i;
			}
			jcbNewsStoryDay = new JComboBox<Integer>(days);
			// selects the current story's day
			jcbNewsStoryDay.setSelectedItem(new Integer(newsStory.getDate().getDayOfMonth()));
			jplNewsStoryDay.add(jcbNewsStoryDay);

			// makes panel for part of day, adds label and combo box
			jplNewsStoryPartOfDay = new JPanel(new GridLayout(1, 0, 5, 5));
			jplNewsStoryPartOfDay.add(jlbNewsStoryPartOfDay);
			jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>(PartOfDay.values());
			// selects the current story's part of day
			jcbNewsStoryPartOfDay.setSelectedItem(newsStory.getPartOfDay());
			jplNewsStoryPartOfDay.add(jcbNewsStoryPartOfDay);

			// makes panel for when, which includes year, month, day, and part of day panels
			jplNewsStoryWhen = new JPanel(new GridLayout(0, 1, 5, 5));
			jplNewsStoryWhen.add(jplNewsStoryYear);
			jplNewsStoryWhen.add(jplNewsStoryMonth);
			jplNewsStoryWhen.add(jplNewsStoryDay);
			jplNewsStoryWhen.add(jplNewsStoryPartOfDay);

			// makes panel for button
			jplAddEditNewsStory = new JPanel(new GridLayout(1, 0, 5, 5));
			jbtAddEditNewsStory = new JButton("Edit News Story");
			jplAddEditNewsStory.add(jbtAddEditNewsStory);

			// Set up the content pane and add all the panels to it.
			setLayout(new GridLayout(0, 1, 5, 5));
			add(jplNewsStoryType);
			add(jplNewsStorySource);
			add(jplNewsStoryTopic);
			add(jplNewsStorySubject);
			add(jplNewsStoryNewsMaker1);
			add(jplNewsStoryNewsMaker2);
			add(jplNewsStoryLength);
			add(jplNewsStoryWhen);
			add(jplAddEditNewsStory);	
			setVisible(true);
		}
	}
}


