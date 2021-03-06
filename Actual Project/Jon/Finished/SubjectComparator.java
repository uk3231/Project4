import java.util.Comparator;

public class SubjectComparator implements Comparator<NewsStory> {

	public static final SubjectComparator SUBJECT_COMPARATOR = new SubjectComparator();

	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getSubject().compareTo(newsStory2.getSubject());
	}
}
