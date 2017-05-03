import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import java.io.Serializable;

public class NewsStoryListModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<NewsStory> newsStories;
	
	public NewsStoryListModel(){
		this.newsStories = new DefaultListModel<NewsStory>();
	}
	
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel){
		this.newsStories = newsStoryListModel.getNewsStories();
	}
	
	public boolean isEmpty(){
		return this.newsStories.isEmpty();
	}
	
	public int size(){
		return this.newsStories.size();
	}

	public boolean contains(NewsStory newsStory){
		return this.newsStories.contains(newsStory);
	}
	
	public NewsStory get(int index) {
		return this.newsStories.get(index);
	}
	
	public DefaultListModel<NewsStory> getNewsStories(){
		return this.newsStories;
	}
	
	public void add(NewsStory newsStory) {
		this.newsStories.addElement(newsStory);
	}
	
	public void remove(NewsStory newsStory){
		this.newsStories.remove(this.newsStories.indexOf(newsStory));
	}
	
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories){
		for(int i = 0; i<newsStories.size(); i++){
			this.remove(newsStories.get(i));
		}
	}
	
	public void setNewsStories(NewsStoryListModel newsStoryListModel){
		this.newsStories = newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray){
		this.newsStories.clear();
		for(NewsStory l: newsStoryArray){
			this.newsStories.addElement(l);
		}
	}


}
