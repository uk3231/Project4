import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author uday kohli, jon kunjummen, Dr. Hougen
 * uday did stub code and wrote the methods
 *
 */
public class EditNewsMakerView extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*defualt*/ NewsMakerModel newsMakerModel;
	
	private NewsDataBaseModel newsDataBaseModel;
	
	private DefaultListModel<String> newsStoryStringList;
	
	private JList<String> jlNewsStoryList;
	
	private JScrollPane jspNewsStoryList = new JScrollPane();
	
	private JPanel jplNewsStoryList;
	
	/*defualt*/ JTextField jtfName;
	
	private JLabel jlbName = new JLabel("Name");
	
	/*default*/ JButton jbtRemoveFromStory = new JButton("Remove from Story");
	
	private JPanel jplName;
	
	
	public EditNewsMakerView(NewsMakerModel newsMakerModel,
			NewsDataBaseModel newsDataBaseModel){
		this.newsMakerModel = newsMakerModel;
		if(!this.newsMakerModel == null){
			this.newsMakerModel.addActionListener(this);
		}
		newsDataBaseModel = newsDataBaseModel; // TODO i cant't figure out why i need this
		
		// TODO his image shows a title "Editing News Maker" idk how to add that
		// this does what populateNewsStoriesJList should do
		newsStoryStringList = new DefaultListModel<String>();
		for(int i = 0; i < newsMakerModel.getNewsStoryListModel().size(); i++){
			// gets the news story at index i, turns it to a string, and adds it to the story
			newsStoryStringList.addElement(newsMakerModel.getNewsStoryListModel().get(i).toString());
		}
		jlNewsStoryList = new JList<String>(newsStoryStringList);
		
		// adds jlist to scroll pane, adds scroll pane to panel
		jspNewsStoryList.add(jlNewsStoryList);
		jplNewsStoryList = new JPanel();
		jplNewsStoryList.add(jspNewsStoryList);
		
		// makes jpanel for name with text field and label
		jtfName = new JTextField(newsMakerModel.getName());
		jplName = new JPanel(new GridLayout(1, 0, 5, 5));
		jplName.add(jlbName);
		jplName.add(jtfName);
		
		this.setLayout(new GridLayout(0, 1));
		this.add(jplName);
		this.add(jplNewsStoryList);				
	}
	
	public int[] getSelectedNewsStoryIndices(){
		return jlNewsStoryList.getSelectedIndices();	
	}
	
	private void populateNewsStoriesJList(){
		// not entirely sure what this should do
		newsStoryStringList = new DefaultListModel<String>();
		for(int i = 0; i < newsMakerModel.getNewsStoryListModel().size(); i++){
			// gets the news story at index i, turns it to a string, and adds it to the story
			newsStoryStringList.addElement(newsMakerModel.getNewsStoryListModel().get(i).toString());
		}
		jlNewsStoryList = new JList<String>(newsStoryStringList);
	}
	
	private void enableRemovalButton(){
		// enables the remove button if the news maker is not "none" and if there are 
		// news stories in the list
		if(!newsMakerModel.getName().equals("None") && 
				!newsMakerModel.getNewsStoryListModel().getNewsStories().isEmpty()){
			jbtRemoveFromStory.setEnabled(true);
		}
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		enableRemovalButton();
		populateNewsStoriesJList();
		repaint();
		// code from stackoverflow said to also revalidate
		// http://stackoverflow.com/questions/20048108/disabling-a-button-when-a-list-item-isnt-selected-in-java
	}
	
}