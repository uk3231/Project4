import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class NewsMakerModel implements Serializable {

		private static final long serialVersionUID = 1L;

		private ArrayList<ActionListener> actionListenerList;
		
		private String name;

		private NewsStoryListModel newsStoryListModel;

		NewsMakerModel() {
		}

		public NewsMakerModel(String name) {
			this.name = name;
		}
				

		public String getName() {
			return this.name;
		}
		
		public NewsStoryListModel getNewsStoryListModel() {
		}

		public void addNewsStory(NewsStory newsStory) {
		}
		
		public void setName(String name){}
		
		public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){}
		
		public void removeNewsStory(NewsStory newsStory){}		

		public boolean equals(Object o) {
		}

		public int compareTo(NewsMakerModel newsMakerModel) {
		}
		
		public String toString(){}
		
		public void addActionListener(ActionListener actionListener){}
		
		public void removeActionListener(ActionListener actionListener){}
		
		private void processEvent(ActionEvent actionEvent){}

}
