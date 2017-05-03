	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

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
		public NewsMakerListModel() {
		}
		
		public NewsMakerListModel(NewsMakerListModel newsMakerListModel){
		}

		public boolean isEmpty(){
			
		}
		
		public int size(){}
		
		public boolean contains(NewsMakerModel newsMakerModel){}
				
		public NewsMakerModel get(NewsMakerModel newsMakerModel) {
		}

		public NewsMakerModel getExactMatch(String newsMakerName) {
		}

		public NewsMakerModel getPartialMatch(String newsMakerName) {
		}
		
		public DefaultListModel<NewsMakerModel> getNewsMakers(){}
		
		public NewsMakerModel get(int index)
		
		public String[] getNewsMakerNames(){}
		
		public void add(NewsMakerModel newsMakerModel){}
		
		public void replace(NewsMakerModel newsMakerModel){}
		
		public void remove(NewsMakerModel newsMakerModel){}
		
		public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		}
		
		public void removeAllNewsMakers(){}
		
		public void setNewsMakeresFromNewsMakerList(NewsMakerListModel newsMakerListModel){}
		
		public void sort(){}		

}
