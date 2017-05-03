import java.io.Serializable;
import javax.swing.DefaultListModel;

public class NewsMakerListModel implements Serializable {

	/**
	 * This is the first serializable version of NewsMakerList, so we select a
	 * serialVersionUID of 1L.
	 */
	private static final long serialVersionUID = 1L;

	/** The list of news makers. */
	private DefaultListModel<NewsMakerModel> newsMakerDefaultListModel;

	/**
	 * The no-argument constructor initializes the list to be an empty
	 * <code>ArrayList</code> of <code>NewsMaker</code> objects.
	 */
	public NewsMakerListModel(){
		newsMakerDefaultListModel = new DefaultListModel<NewsMakerModel>();
	}
	
	public NewsMakerListModel(NewsMakerListModel newsMakerListModel){
		this.newsMakerDefaultListModel = newsMakerListModel.getNewsMakers();
	}

	public boolean isEmpty(){
		return this.newsMakerDefaultListModel.isEmpty();
	}
	
	public int size(){
		return this.newsMakerDefaultListModel.size();
	}
	
	public boolean contains(NewsMakerModel newsMakerModel){
		return this.newsMakerDefaultListModel.contains(newsMakerModel);
	}
			
	public NewsMakerModel get(NewsMakerModel newsMakerModel) {
		int index = newsMakerDefaultListModel.indexOf(newsMakerModel);
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakerDefaultListModel.get(index);
		} else {
			return null;
		}
	}

	public NewsMakerModel getExactMatch(String newsMakerName) {
		NewsMakerModel newsMaker = new NewsMakerModel(newsMakerName);
		int index = this.newsMakerDefaultListModel.indexOf(newsMaker);
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakerDefaultListModel.get(index);
		} else {
			return null;
		}
	}

	public NewsMakerModel getPartialMatch(String newsMakerName) {
		for (int i = 0; i<newsMakerDefaultListModel.size();++i) {
			if (newsMakerDefaultListModel.get(i).toString().equals(newsMakerName)) {
				return newsMakerDefaultListModel.get(i);
			}
		}
		return null;
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		return this.newsMakerDefaultListModel;
	}
	
	public NewsMakerModel get(int index){
		return this.newsMakerDefaultListModel.get(index);
	}
	
	public String[] getNewsMakerNames(){
		String[] result = new String[this.newsMakerDefaultListModel.size()];
		for(int i = 0; i<this.newsMakerDefaultListModel.size();++i){
			result[i] = this.newsMakerDefaultListModel.get(i).toString();
		}
		return result;
	}
	
	public void add(NewsMakerModel newsMakerModel){
		this.newsMakerDefaultListModel.addElement(newsMakerModel);
	}
	
	public void replace(NewsMakerModel newsMakerModel){
		this.remove(newsMakerModel);
		this.add(newsMakerModel);
	}
	
	public void remove(NewsMakerModel newsMakerModel){
		this.newsMakerDefaultListModel.removeElementAt(this.newsMakerDefaultListModel.indexOf(newsMakerModel));
	}
	
	public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		for(int i = 0; i<newsMakers.size(); i++){
			this.remove(newsMakers.get(i));
		}
	}
	
	public void removeAllNewsMakers(){
		this.newsMakerDefaultListModel.clear();
	}
	
	public void setNewsMakersFromNewsMakerList(NewsMakerListModel newsMakerListModel){
		this.newsMakerDefaultListModel = newsMakerListModel.getNewsMakers();
	}
	
	public void sort(){
		DefaultListModel<NewsMakerModel> sorted = new DefaultListModel<NewsMakerModel>();
		for(int i = 0; i<this.newsMakerDefaultListModel.size(); ++i){
			for(int j = 0; j<=i; ++j){
				if(this.newsMakerDefaultListModel.get(i).compareTo(sorted.get(j))<0){
					sorted.add(j, this.newsMakerDefaultListModel.get(i));
					break;
				}
			}
		}
	}		
}
