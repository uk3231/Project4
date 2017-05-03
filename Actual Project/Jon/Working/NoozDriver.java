
public class NoozDriver {
	
	private static NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	
	private static SelectionView selectionView = new SelectionView();
	
	private static NewsController newsController = new NewsController();
	
	public static void main(String[] args){
		// Any view displaying data from the model to the user needs to know
		// about the model.
		selectionView.setNewsDataBaseModel(newsDataBaseModel);

		// Any controller sending updates to the model needs to know about the
		// model.
		newsController.setNewsDataBaseModel(newsDataBaseModel);

		// Any controller interacting with a view needs to know about that view.
		newsController.setSelectionView(selectionView);
	}
	
}
