import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Uday Kohli, Jon Kunjummen, Dr. Hougen
 * 
 * Jon did the stub code, Uday wrote the methods
 *
 */
public class NewsMakerModel implements Serializable {

		private static final long serialVersionUID = 1L;

		private ArrayList<ActionListener> actionListenerList;
		
		private String name;

		private NewsStoryListModel newsStoryListModel = new NewsStoryListModel();

		NewsMakerModel() {
			this.name = "None";
		}

		public NewsMakerModel(String name) {
			this.name = name;
		}
				

		public String getName() {
			return this.name;
		}
		
		public NewsStoryListModel getNewsStoryListModel() {
			return this.newsStoryListModel;
		}

		public void addNewsStory(NewsStory newsStory) {
			// if its not already there, add it
			if(! newsStoryListModel.contains(newsStory)){
				this.newsStoryListModel.add(newsStory);

				// inform the listener of the change
				processEvent(new ActionEvent(this, 
						ActionEvent.ACTION_PERFORMED, 
						"Added a News Story"));
			}

		}

		public void setName(String name){
			
			// update name
			if(!this.name.equals(name)){
				this.name = name;

				// inform action listeners of the change 
				processEvent(new ActionEvent(this, 
						ActionEvent.ACTION_PERFORMED, 
						"Changed Name of News Maker"));
			}
		}

		public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
			// update model
			this.newsStoryListModel = newsStoryListModel;
			
			// inform action listeners of the change
			processEvent(new ActionEvent(this,
					ActionEvent.ACTION_PERFORMED,
					"Changed news story list model"));
		}
		
		public void removeNewsStory(NewsStory newsStory){
			// check if the story is in the list
			if(this.newsStoryListModel.contains(newsStory)){
				// removes the story 
				this.newsStoryListModel.remove(newsStory);
				
				// inform action listeners of the change
				processEvent(new ActionEvent(this, 
						 ActionEvent.ACTION_PERFORMED, 
						 "Removed News Story"));
			}
		}		

		public boolean equals(Object o) {
			if(o instanceof NewsMakerModel){
				NewsMakerModel otherNewsMaker = (NewsMakerModel) o;
				return this.name.equals(otherNewsMaker.getName());
			}
			
			return false;
		}

		public int compareTo(NewsMakerModel newsMakerModel) {
			return this.name.compareTo(newsMakerModel.getName());
		}
		
		public String toString(){
			return this.name;
		}
		
		public synchronized void addActionListener(ActionListener actionListener){
			if(actionListenerList == null){
				actionListenerList = new ArrayList<ActionListener>();
			}
			actionListenerList.add(actionListener);
		}
		
		public synchronized void removeActionListener(ActionListener actionListener){
			if (actionListenerList != null && actionListenerList.contains(actionListener)) {
				actionListenerList.remove(actionListener);
			}
		}
		
		private void processEvent(ActionEvent actionEvent){
			ArrayList<ActionListener> list;
			synchronized (this) {
				if (actionListenerList == null)
					return;
				// Do not worry about the cast warning here.
				list = (ArrayList<ActionListener>) actionListenerList.clone();
			}
			for (int i = 0; i < list.size(); i++) {
				ActionListener listener = list.get(i);
				listener.actionPerformed(e);
			}
		}

}

