import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * @author Uday Kohli, Dr. Hougen, Jonathan Kunjummen
 *
 */
public class SelectionView extends JFrame implements ActionListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NewsDataBaseModel newsDataBaseModel;
	
	private JMenuBar jmb = new JMenuBar();
	
	private JMenu jmFile = new JMenu("File");
	
	private JMenuItem jmiLoad = new JMenuItem("Load");
	
	private JMenuItem jmiSave = new JMenuItem("Save");
	
	private JMenuItem jmiImport = new JMenuItem("Import");
	
	private JMenuItem jmiExport = new JMenuItem("Export");
	
	private JMenu jmNewsMaker = new JMenu("News Maker");
	
	private JMenuItem jmiAddNewsMaker = new JMenuItem("Add News Maker");
	
	private JMenuItem jmiEditNewsMaker = new JMenuItem("Edit News Maker");
	
	private JMenuItem jmiDeleteNewsMaker = new JMenuItem("Delete News Maker");
	
	private JMenuItem jmiDeleteNewsMakerList = new JMenuItem ("Delete News Maker List");
	
	private JMenu jmNewsStory = new JMenu("NewsStory");
	
	private JMenuItem jmiAddNewsStory = new JMenuItem("Add News Story");
	
	private JMenuItem jmiEditNewsStory = new JMenuItem("Edit News Story");
	
	private JMenuItem jmiSortNewsStories = new JMenuItem("Sort News Stories");
	
	private JMenuItem jmiDeleteNewsStory = new JMenuItem("Delete News Story");
	
	private JMenuItem jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
	
	private JMenu jmDisplay = new JMenu("Display");
	
	private JMenuItem jmiPieChart = new JMenuItem("Pie Chart");
	
	private JMenuItem jmiText = new JMenuItem("Text");
	
	private JList<NewsMakerModel> jlNewsMakerList;
	
	private JScrollPane jspNewsMakerList = new JScrollPane(jlNewsMakerList);
	
	private JPanel jplNewsMakerList;
	
	private JList<NewsStory> jlNewsStoryList;
	
	private JScrollPane jspNewsStoryList = new JScrollPane(jlNewsStoryList);
	
	private JPanel jplNewsStoryList;
	
	private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	
	
	
	/** constructor for selection view **/
	public SelectionView(){
		setTitle("Nooz");
		
		// adds jmenu items to the jmenu file
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.add(jmiImport);
		jmFile.add(jmiExport);
		
		// disable save and export, becuase data is not loaded yet
		jmiSave.setEnabled(false);
		jmiExport.setEnabled(false);
		
		// adds jmenu items to the jmenu news maker
		jmNewsMaker.add(jmiAddNewsMaker);
		jmNewsMaker.add(jmiEditNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMakerList);
		
		// disable edit and delete jmis 
		jmiEditNewsMaker.setEnabled(false);
		jmiDeleteNewsMaker.setEnabled(false);
		jmiDeleteNewsMakerList.setEnabled(false);
		
		// adds jmenu items to the jmenu news story
		jmNewsStory.add(jmiAddNewsStory);
		jmNewsStory.add(jmiEditNewsStory);
		jmNewsStory.add(jmiSortNewsStories);
		jmNewsStory.add(jmiDeleteNewsStory);
		jmNewsStory.add(jmiDeleteAllNewsStories);
		
		// disable edit, sort, and delete
		jmiEditNewsStory.setEnabled(false);
		jmiSortNewsStories.setEnabled(false);
		jmiDeleteNewsStory.setEnabled(false);
		jmiDeleteAllNewsStories.setEnabled(false);
		
		// adds jmenu items to the jmenu display
		jmDisplay.add(jmiPieChart);
		jmDisplay.add(jmiText);
		
		// adds jmenus to the jmenu bar
		jmb.add(jmFile);
		jmb.add(jmNewsMaker);
		jmb.add(jmNewsStory);
		jmb.add(jmDisplay);
		
		// constructs a jpanel for the newsmaker list
		jplNewsMakerList = new JPanel(new GridLayout(0, 1, 5, 5));
		// adds a label to the panel
		jplNewsMakerList.add(new JLabel("News Makers"));
		
		// constructs a jlist with the newsmakerlist model from the database model
		jlNewsMakerList = new JList(newsDataBaseModel.getNewsMakerListModel);
		
		// adds the jlist to the scroll pane
		jspNewsMakerList.add(jlNewsMakerList);
		// adds the scroll pane to the jpanel
		jplNewsMakerList.add(jspNewsMakerList);
		
		// constructs a jpanel for the newsstory list
		jplNewsStoryList = new JPanel(new GridLayout(0, 1, 5, 5));
		// add a label to the panel
		jplNewsStoryList.add(new JLabel("News Stories"));
		
		// constructs a jlist with the newsstorylist model from the database model
		jlNewsStoryList = new JList(newsDataBaseModel.getNewsStoryListModel);
		
		// adds the jlit to the scrool pane
		jspNewsStoryList.add(jlNewsStoryList);
		// adds the scroll pane to the jpanel
		jplNewsStoryList.add(jspNewsStoryList);
		
		// adds JPanels to the splitpane
		splitPane.setLeftComponent(jplNewsMakerList);
		splitPane.setRightComponent(jplNewsStoryList);
		
		// Set up the content pane and add all the panels to it.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jmb);
		add(splitPane);
		pack();
		setVisible(true);
	}
	
	/**
	 * @param fileMenuListener
	 */
	public void registerFileMenuListener(ActionListener fileMenuListener){
		jmFile.addActionListener(fileMenuListener);
	}
	
	/**
	 * @param newsMakerMenuListener
	 */
	public void registerNewsMakerMenuListener(ActionListener newsMakerMenuListener){
		jmNewsMaker.addActionListener(newsMakerMenuListener);
	}
	
	public void registerNewsStoryMenuListener(ActionListener newsStoryMenuListener){
		jmNewsStory.addActionListener(newsStoryMenuListener);
	}
	
	public void registerDisplayMenuListener(ActionListener displayMenuListener){
		jmDisplay.addActionListener(displayMenuListener);
	}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
		
		if(newsDataBaseModel != null){
			// register the view as an action listener for the model
			newsDataBaseModel.addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// if both lists are empty, we should not be able to load or export
		// otherwise, we should
		if(newsDataBaseModel.newsMakerListIsEmpty() &&
				newsDataBaseModel.newsStoryListIsEmpty()){
			jmiSave.setEnabled(false);
			jmiExport.setEnabled(false);
		} else{
			jmiSave.setEnabled(true);
			jmiExport.setEnabled(true);
		}
		
		// if the newsmakerlist is empty, edit and delete should be inactive
		// otherwise they should be active
		if(newsDataBaseModel.newsMakerListIsEmpty()){
			jmiEditNewsMaker.setEnabled(false);
			jmiDeleteNewsMaker.setEnabled(false);
			jmiDeleteNewsMakerList.setEnabled(false);
		} else{
			jmiEditNewsMaker.setEnabled(false);
			jmiDeleteNewsMaker.setEnabled(false);
			jmiDeleteNewsMakerList.setEnabled(false);
		}
		
		// if the story list is empty, these should be disabled
		// otherwise, they should be enabled
		if(newsDataBaseModel.newsStoryListIsEmpty()){
			jmiEditNewsStory.setEnabled(false);
			jmiSortNewsStories.setEnabled(false);
			jmiDeleteNewsStory.setEnabled(false);
			jmiDeleteAllNewsStories.setEnabled(false);
		} else{
			jmiEditNewsStory.setEnabled(true);
			jmiSortNewsStories.setEnabled(true);
			jmiDeleteNewsStory.setEnabled(true);
			jmiDeleteAllNewsStories.setEnabled(true);
		}
	}

	public int[] getSelectedNewsMakers(){
		return jlNewsMakerList.getSelectedIndices();
	}

	public int[] getSelectedNewsStories(){
		return jlNewsStoryList.getSelectedIndices();
	}	
}

