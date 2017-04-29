import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
	
	private JMenuItem jmiAddNewsStory = new JMenuItem("Add");
	
	private JMenuItem jmiEditNewsStory = new JMenuItem("Edit");
	
	private JMenuItem jmiSortNewsStories = new JMenuItem("Sort News Stories");
	
	private JMenuItem jmiDeleteNewsStory = new JMenuItem("Delete News Story");
	
	private JMenuItem jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
	
	private JMenu jmDisplay = new JMenu("Display");
	
	private JMenuItem jmiPieChart = new JMenuItem("Pie Chart");
	
	private JMenuItem jmiText = new JMenuItem("Text");
	
	private JList<NewsMakerModel> jlNewsMakerList = new JList<NewsMakerModel>();
	
	private JScrollPane jspNewsMakerList = new JScrollPane();
	
	private JPanel jpNewsMakerList = new JPanel();
	
	private JList<NewsStory> jlNewsStoryList = new JList<NewsStory>();
	
	private JScrollPane jspNewsStoryList = new JScrollPane();
	
	private JPanel jpNewsStoryList = new JPanel();
	
	private JSplitPane splitPane = new JSplitPane();
	
	
	
	/** constructor for selection view **/
	public SelectionView(){
		
	}
	
	/**
	 * @param fileMenuListener
	 */
	public void registerFileMenuListener(ActionListener fileMenuListener){
		
	}
	
	/**
	 * @param newsMakerMenuListener
	 */
	public void registerNewMakerMenuListener(ActionListener newsMakerMenuListener){
		
	}
	
	public void registerDisplayMenuListener(ActionListener displayMenuListener){
		
	}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
	}

	public int[] getSelectedNewsMakers(){
		return null;
	}

	public int[] getSelectedNewsStories(){
		
		return null;
	}
	
}
