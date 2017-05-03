import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;

//unfinished: Figuring out what "none" does, writing a pretty "remove all news stories" method, figuring out whether the 1st
//2 of the last 3 need to be synchronized.
public class NewsDataBaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4731282697611876377L;
	
	private ArrayList<ActionListener> actionListenerList;
	
	private Map<String, String> newsSourceMap;
	
	private Map<String, String> newsTopicMap;
	
	private Map<String, String> newsSubjectMap;
	
	//What even is this?
	NewsMakerModel none;
	
	private NewsMakerListModel newsMakerListModel;
	
	private NewsStoryListModel newsStoryListModel;
	
	public NewsDataBaseModel(){
		this.actionListenerList = new ArrayList<ActionListener>();		
		this.newsSourceMap = new HashMap<String, String>();		
		this.newsTopicMap = new HashMap<String, String>();		
		this.newsSubjectMap = new HashMap<String, String>();
		this.newsMakerListModel = new NewsMakerListModel();
		this.newsStoryListModel = new NewsStoryListModel();
	}
	
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel){
		this.newsMakerListModel = newsMakerListModel;
		this.newsStoryListModel = newsStoryListModel;
	}
	
	public Map<String, String> getNewsSourceMap(){
		return this.newsSourceMap;
	}
	
	public String[] getNewsSources(){
		String[] result = new String[this.newsSourceMap.size()];
		int i = 0;
		for(String l: this.newsSourceMap.values()){
			result[i] = l;
			i++;
		}
		return result;
	}
	
	public void setNewsSourceMap(Map<String,String> newsSourceMap){
		
		this.newsSourceMap = newsSourceMap;
	}
	
	public Map<String, String> getNewsTopicMap(){
		return this.newsTopicMap;
	}
	
	public String[] getNewsTopics(){
		String[] result = new String[this.newsSourceMap.size()];
		int i = 0;
		for(String l: this.newsSourceMap.values()){
			result[i] = l;
			i++;
		}
		return result;
	}
	
	public void setNewsTopicMap(Map<String,String> newsTopicMap){
		this.newsTopicMap = newsTopicMap;
	}
	
	public Map<String, String> getNewsSubjectMap(){
		return this.newsSubjectMap;
	}
	
	public String[] getNewsSubjects(){
		String[] result = new String[this.newsSubjectMap.size()];
		int i = 0;
		for(String l: this.newsSubjectMap.values()){
			result[i] = l;
			i++;
		}
		return result;
	}
	
	public void setNewsSubjectMap(Map<String,String> newsSubjectMap){
		this.newsSubjectMap = newsSubjectMap;
	}
	
	public boolean newsMakerListIsEmpty(){
		return this.newsMakerListModel.isEmpty();
	}
	
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel){
		return this.newsMakerListModel.contains(newsMakerModel);
	}
	
	public NewsMakerListModel getNewsMakerListModel(){
		return this.newsMakerListModel;
	}

	public String[] getNewsMakerNames(){
		return this.newsMakerListModel.getNewsMakerNames();
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		return this.newsMakerListModel.getNewsMakers();
	}
	
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel){
		this.newsMakerListModel = newsMakerListModel;
	}
	
	public void addNewsMakerListModel(NewsMakerModel newsMakerModel){
		this.newsMakerListModel.add(newsMakerModel);
	}
	
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel){
		this.newsMakerListModel.replace(newsMakerModel);
	}
	
	public void removeNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		this.newsMakerListModel.removeListOfNewsMakers(newsMakers);
	}
	
	public void removeAllNewsMakers(){
		this.newsMakerListModel.removeAllNewsMakers();
	}
	
	public void sortNewsMakerListModel(){
		this.newsMakerListModel.sort();
	}
	
	public boolean newsStoryListIsEmpty(){
		return this.newsStoryListModel.isEmpty();
	}
	
	public boolean containsNewsStory(NewsStory newsStory){
		return this.newsStoryListModel.contains(newsStory);
	}
	
	public NewsStoryListModel getNewsStoryListModel(){
		return this.newsStoryListModel;
	}
	
	public DefaultListModel<NewsStory> getNewsStories(){
		return this.newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
		this.newsStoryListModel = newsStoryListModel;
	}
	
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryArray){
		this.newsStoryListModel.setNewsStoriesFromArray(newsStoryArray);
	}

	public void addNewsStory(NewsStory newsStory){
		this.newsStoryListModel.add(newsStory);
	}
	
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories){
		this.newsStoryListModel.removeListOfNewsStories(newsStories);
	}
	
	public void removeAllNewsStories(){
		this.newsStoryListModel.removeListOfNewsStories(this.getNewsStories());
	}
	
	public synchronized void addActionListener(ActionListener l){
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
		actionListenerList.add(l);
	}
	
	public synchronized void removeActionListener(ActionListener l){
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	}
	
	private void processEvent(ActionEvent e){
		ArrayList<ActionListener> list;

		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}	
	}
	
}
