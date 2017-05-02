import java.io.Serializable;
import java.time.LocalDate;

public abstract class NewsStory implements Comparable<NewsStory>, Serializable {

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
	private NewsMakerModel newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMakerModel newsMaker2;

	protected NewsStory(LocalDate date, String source, int length, String topic, String subject, NewsMakerModel newsMaker1,
			NewsMakerModel newsMaker2) {
		this.date = date; // Note that LocalDate is immutable
		this.source = source;
		this.length = length; // TODO Restrict to positive values (for Project
								// 4)
		this.topic = topic;
		this.subject = subject;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}

	public LocalDate getDate() {
		return date; // Note that LocalDate is immutable
	}

	public String getSource() {
		return source;
	}

	public int getLength() {
		return length;
	}

	public abstract int getLengthInWords();

	public String getTopic() {
		return topic;
	}

	public String getSubject() {
		return subject;
	}

	public NewsMakerModel getNewsMaker1() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker1;
	}

	public NewsMakerModel getNewsMaker2() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker2;
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public void setTopic(String topic){
		this.topic = topic;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public void setNewsMaker1(NewsMakerModel newsMaker1){
		this.newsMaker1 = newsMaker1;
	}
	
	public void setNewsMaker2(NewsMakerModel newsMaker2){
		this.newsMaker2 = newsMaker2;
	}
	
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

	public int compareTo(NewsStory newsStory) {
		return this.topic.compareTo(newsStory.topic);
	}

}
