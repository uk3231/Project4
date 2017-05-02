import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum NewsMedia {

	NEWSPAPER, ONLINE, TV;
	
	//This method of intializing a list in one step is 
	//taken from stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
	public static final List<NewsMedia> valuesAsList = new ArrayList<NewsMedia>(
			Arrays.asList(NEWSPAPER, ONLINE, TV));
	
	public String toString() {
		switch (this) {
		case NEWSPAPER:
			return "Newspaper";
		case ONLINE:
			return "Online";
		case TV:
			return "TV";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public List<NewsMedia> valuesAsList(){
		return valuesAsList;
	}

}
