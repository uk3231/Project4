import java.awt.BorderLayout;
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

	/*default*/ NewsMakerModel newsMakerModel;
	
	private NewsDataBaseModel newsDataBaseModel;
		
	private JList<NewsStory> jlNewsStoryList;
	
	private JScrollPane jspNewsStoryList;
	
	private JPanel jplNewsStoryList;
	
	/*default*/ JTextField jtfName;
	
	private JLabel jlbName = new JLabel("Name");
	
	/*default*/ JButton jbtRemoveFromStory = new JButton("Remove from Story");
	
	private JPanel jplName;
	
	
	public EditNewsMakerView(NewsMakerModel newsMakerModel,
			NewsDataBaseModel newsDataBaseModel){
		this.newsMakerModel = newsMakerModel;
		if(!(this.newsMakerModel == null)){
			this.newsMakerModel.addActionListener(this);
		}
		this.newsDataBaseModel = newsDataBaseModel; // TODO i cant't figure out why i need this
		
		// this does what populateNewsStoriesJList should do
		jlNewsStoryList = new JList<NewsStory>(newsMakerModel.getNewsStoryListModel().getNewsStories());
		jlNewsStoryList.setModel(newsMakerModel.getNewsStoryListModel().getNewsStories());
		
		// adds jlist to scroll pane, adds scroll pane to panel
		jspNewsStoryList = new JScrollPane(jlNewsStoryList);
		jplNewsStoryList = new JPanel(new BorderLayout());
		jplNewsStoryList.add(jspNewsStoryList, BorderLayout.CENTER);
		jplNewsStoryList.add(jbtRemoveFromStory, BorderLayout.SOUTH);


		// makes jpanel for name with text field and label
		jtfName = new JTextField(newsMakerModel.getName());
		jplName = new JPanel();
		jplName.add(jlbName);
		jplName.add(jtfName);
		
		this.setLayout(new BorderLayout());
		this.add(jplName, BorderLayout.NORTH);
		this.add(jplNewsStoryList, BorderLayout.CENTER);				
	}

	public int[] getSelectedNewsStoryIndices(){
		return jlNewsStoryList.getSelectedIndices();	
	}

	private void enableRemovalButton(){
		// enables the remove button if the news maker is not "none" and if there are 
		// news stories in the list
		if(!newsMakerModel.getName().equals("None") && newsMakerModel.getNewsStoryListModel()!= null && 
				!newsMakerModel.getNewsStoryListModel().getNewsStories().isEmpty()){
			jbtRemoveFromStory.setEnabled(true);
		}
		else{
			jbtRemoveFromStory.setEnabled(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		enableRemovalButton();
		
		revalidate();
		repaint();
		// http://stackoverflow.com/questions/20048108/disabling-a-button-when-a-list-item-isnt-selected-in-java
	}
	
}
