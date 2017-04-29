import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	
	private JPanel jplNewsStoryList = new JPanel();
	
	/*defualt*/ JTextField jtfName = new JTextField();
	
	private JLabel jlbName = new JLabel("Name");
	
	/*default*/ JButton jbtRemoveFromStory = new JButton("Remove from Story");
	
	private JPanel jpllName = new JPanel();
	
	
	public EditNewsMakerView(NewsMakerModel newsMakerModel,
			NewsDataBaseModel newsDataBaseModel){
		
	}
	
	public int[] getSelectedNewsStoryIndices(){
		return null;	
	}
	
	private void populateNewsStoryJList(){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
