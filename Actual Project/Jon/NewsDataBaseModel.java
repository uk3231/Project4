import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultListModel;

public class NewsDataBaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4731282697611876377L;
	
	private ArrayList<ActionListener> actionListenerList;
	
	private Map<String, String> newsSourceMap;
	
	private Map<String, String> newsTopicMap;
	
	private Map<String, String> newsSubjectMap;
	
	NewsMakerModel none;
	
	private NewsMakerListModel newsMakerListModel;
	
	private NewsStoryListModel newsStoryListModel;
	
	public NewsDataBaseModel(){		
	}
	
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel){
		
	}
	
	public Map<String, String> getNewsSourceMap(){
	}
	
	public String[] getNewsSources(){
	}
	
	public void setNewsSourceMap(Map<String,String> newsSourceMap){
		
	}
	
	public Map<String, String> getNewsTopicMap(){
	}
	
	public String[] getNewsTopics(){
	}
	
	public void setNewsTopicMap(Map<String,String> newsTopicMap){
		
	}
	
	public Map<String, String> getNewsSubjectMap(){
	}
	
	public String[] getNewsSubjects(){
	}
	
	public void setNewsSubjectMap(Map<String,String> newsSubjectMap){
		
	}
	
	public boolean newsMakerListIsEmpty(){
		
	}
	
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel){
		
	}
	
	public NewsMakerListModel getNewsMakerListModel(){
		
	}

	public String[] getNewsMakerNames(){
		
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		
	}
	
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel){
		
	}
	
	public void addNewsMakerListModel(NewsMakerModel newsMakerModel){
		
	}
	
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel){
		
	}
	
	public void removeNewsMakers(DefaultListMode<NewsMakerModel> newsMakers){
		
	}
	
	public void removeAllNewsMakers(){
		
	}
	
	public void sortNewsMakerListModel(){
		
	}
	
	public boolean newsStoryListIsEmpty(){
		
	}
	
	public boolean containsNewsStory(NewsStory newsStory){
		
	}
	
	public NewsStoryListModel getNewsStoryListModel(){
		
	}
	
	public DefaultListModel<NewsStory> getNewsStories(){
		
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
		
	}
	
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryArray){
	}

	public void addNewsStory(NewsStory newsStory){
		
	}
	
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories){
		
	}
	
	public void removeAllNewsStories(){
		
	}
	
	public void addActionListener(ActionListener l){
		
	}
	
	public void removeActionListener(ActionListener l){
		
	}
	
	private void processEvent(ActionEvent e){
		
	}
	
}
