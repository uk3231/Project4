import java.io.Serializable;
import java.time.LocalDate;

/**
 * Project 3, CS 2334, Section 010 March 8, 2017
 * <P>
 * A <code>NewsStory</code> is composed of the date the story was published, the
 * name of the source (such as newspaper or TV news program) where the story was
 * published, the length the story (in words for written stories; in seconds for
 * spoken news), the broad topic for the story, the specific subject matter of
 * the story, and two lead news makers in the story.
 * </P>
 * 
 * @author Dean Hougen
 * @version 2.0
 * 
 */
abstract class NewsStory implements Comparable<NewsStory>, Serializable {
	/**
	 * This is the first serializable version of NewsStory, so we select a
	 * serialVersionUID of 1L.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date the story was published/broadcast as a
	 * <code>java.time.LocalDate</code>.
	 */
	private LocalDate date;

	/** The name of the source in which the story was published. */
	private String source;

	/** The length of the story. */
	private int length;

	/** The broad topic of the story. */
	private String topic;

	/** The specific subject matter of the story. */
	private String subject;

	/** The first news maker featured in the story. */
	private NewsMaker newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMaker newsMaker2;

	/**
	 * The constructor for the class which takes objects of appropriate types to
	 * initialize all of the fields.
	 * <P>
	 * Note that in the length a story cannot be negative, so our class should
	 * model that fact. However, to keep the project relatively simple, this
	 * requirement was not made in the project description and this check
	 * doesn't need to be made yet.
	 * </P>
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param source
	 *            The name of the source in which the story was published.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param subject
	 *            The specific subject matter of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, String subject, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		this.date = date; // Note that LocalDate is immutable
		this.source = source;
		this.length = length; // TODO Restrict to positive values (for Project
								// 4)
		this.topic = topic;
		this.subject = subject;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}

	/**
	 * The accessor for the date field.
	 * <P>
	 * Note that <code>LocalDate</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The date the story was published.
	 */
	public LocalDate getDate() {
		return date; // Note that LocalDate is immutable
	}

	/**
	 * The accessor for the source name field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The name of the source in which the story was published.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The accessor for the length field.
	 * <P>
	 * Note that <code>int</code>s are passed by value, so it is fine to return
	 * the field itself.
	 * </P>
	 * 
	 * @return The count of the words in the story.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * The accessor for length equivalent in words.
	 * <P>
	 * This accessor for length allows both newspaper stories and TV news
	 * stories to be compared on the same basis: words. Since newspaper stories
	 * already have their length measured in words, for newspaper stories, we
	 * can simply return their length. For TV news stories, though, the measured
	 * value is duration in minutes, so we need to convert this to an
	 * approximate number of words before returning it.
	 * </P>
	 * <P>
	 * Note that the description above assumes we only have two subclasses, one
	 * for newspaper stories and one for TV news stories. However, this class
	 * should be flexible enough to allow for other types of news stories to be
	 * created as subclasses.
	 * </P>
	 * 
	 * @return The equivalent of the length in words
	 */
	public abstract int getLengthInWords();

	/**
	 * The accessor for the topic field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The broad topic of the story.
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * The accessor for the subject field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The specific subject matter of the story.
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * The accessor for the first news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The first news maker featured in the story.
	 */
	public NewsMaker getNewsMaker1() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker1;
	}

	/**
	 * The accessor for the second news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The second news maker featured in the story.
	 */
	public NewsMaker getNewsMaker2() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker2;
	}

	/**
	 * Overridden <code>equals</code> method considers equality of contents
	 * rather than memory locations.
	 * <P>
	 * Note that we compare all fields of news story but that
	 * <code>equals</code> for the news makers themselves does not compare their
	 * news story lists.
	 * </P>
	 * 
	 * @param o
	 *            The object to which to compare this.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof NewsStory) {
			NewsStory newsStory = (NewsStory) o;
			boolean equivalent = this.date.equals(newsStory.date);
			if (equivalent) {
				equivalent = this.source.equals(newsStory.source);
			}
			if (equivalent) {
				equivalent = this.length == newsStory.length;
			}
			if (equivalent) {
				equivalent = this.topic.equals(newsStory.topic);
			}
			if (equivalent) {
				equivalent = this.subject.equals(newsStory.subject);
			}
			if (equivalent) {
				equivalent = this.newsMaker1.equals(newsStory.newsMaker1);
			}
			if (equivalent) {
				equivalent = this.newsMaker2.equals(newsStory.newsMaker2);
			}
			return equivalent;
		}
		// If it isn't a NewsStory, it's not equivalent.
		else {
			return false;
		}
	}

	/**
	 * Overridden <code>compareTo</code> method to allow for sorting.
	 * <P>
	 * The natural ordering for news stories is topic.
	 * </P>
	 */
	@Override
	public int compareTo(NewsStory newsStory) {
		return this.topic.compareTo(newsStory.topic);
	}
}
