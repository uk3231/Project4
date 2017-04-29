import java.util.Comparator;

/**
 * Project 3, CS 2334, Section 010, March 8, 2017
 * <P>
 * The SourceComparator compares the sources of two news stories.
 * </P>
 * <P>
 * Note that the constructor has nothing to do, so it is omitted.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class SourceComparator implements Comparator<NewsStory> {
	/**
	 * We create a single comparator object for the class and make a public
	 * final field that references that object. This comparator can then be used
	 * any time it is needed, simply by using its name.
	 */
	public static final SourceComparator SOURCE_COMPARATOR = new SourceComparator();

	/**
	 * The required <code>compare</code> method for implementing
	 * <code>Comparator</code>.
	 * 
	 * @param newsStory1
	 *            The first news story to compare based on source.
	 * @param newsStory2
	 *            The second news story to compare based on source.
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getSource().compareTo(newsStory2.getSource());
	}

}