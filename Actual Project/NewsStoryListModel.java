import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import java.io.Serializable;

public class NewsStoryListModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<NewsStory> newsStories;
	
	public NewsStoryListModel(){}
	
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel){}
	
	public boolean isEmpty(){}
	
	public int size(){}

	public NewsStory get(int index) {
	}
	
	public DefaultListModel<NewsStory> getnewsStories(){}
	
	public void add(NewsStory newsStory) {
	}
	
	public void remove(NewsStory newsStory){}
	
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories){}
	
	public void setNewsStories(NewsStoryListModel newsStoryListModel){}
	
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray){}


}
