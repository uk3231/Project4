import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MediaTypeSelectionView implements Serializable{

	private static final long serialVersionUID = 6168285086485102174L;

	JCheckBox jcbNewspaper = new JCheckBox();
	
	JCheckBox jcbTVNews = new JCheckBox();
	
	JCheckBox jcbOnline = new JCheckBox();
	
	private JLabel jlblMediaType = new JLabel();
	
	private JButton jbBlank = new JButton();
	
	JButton jbCancel = new JButton();
	
	JButton jbOkay = new JButton();
	
	private JPanel jpCompletionButtons = new JPanel();
	
	private JPanel jpMediaType = new JPanel();
	
	public MediaTypeSelectionView(){}
	
}
