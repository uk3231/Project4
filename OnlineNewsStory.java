import java.time.LocalDate;

/**
 * Project 3, CS 2334, Section 010, March 8, 2017
 * <P>
 * A <code>OnlineNewsStory</code> is composed of the date snapshot of the story
 * was taken, <b>the part of the day when the snapshot happened,</b> the name of
 * the online news site that published the story, the length the story in words,
 * the broad topic for the story, the specific subject matter of the story, and
 * two lead news makers in the story.
 * </P>
 * <P>
 * Since most of these elements are present in <code>NewsStory</code>,
 * <code>OnlineNewsStory</code> is created as a subclass of
 * <code>NewsStory</code>. However, <code>OnlineNewsStory</code> can implement
 * <code>getLengthInWords</code> because we know the inherent length measurement
 * units for online news stories (words), whereas different news stories may use
 * different length units. In addition, each <code>OnlineNewsStory</code>
 * includes the part of the day when the snapshot happened (morning or
 * afternoon), which isn't true for all types of <code>NewsStory</code>. For
 * this reason, an additional field (<code>partOfDay</code>) and corresponding
 * accessor and mutator methods are included in <code>OnlineNewsStory</code>.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class OnlineNewsStory extends NewsStory {

	/**
	 * The part of the day that the news story was captured (morning or
	 * afternoon).
	 */
	private PartOfDay partOfDay;

	/**
	 * The constructor which takes parameters for all of the fields can simply
	 * pass most of them to the constructor for <code>NewsStory</code> and let
	 * it do most of the work. It only needs to handle <code>partOfDay</code>
	 * itself.
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param sourceName
	 *            The name of the source in which the story was published.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param subject
	 *            The specific subject matter of the story.
	 * @param partOfDay
	 *            The part of the day during which the story was captured.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	public OnlineNewsStory(LocalDate date, String sourceName, int length, String topic, String subject,
			PartOfDay partOfDay, NewsMaker newsMaker1, NewsMaker newsMaker2) {
		super(date, sourceName, length, topic, subject, newsMaker1, newsMaker2);
		// TODO: Check to ensure the part of day is valid.
		this.partOfDay = partOfDay;
	}

	/**
	 * Overrides the <code>getLengthInWords</code> method from
	 * <code>NewsStory</code>.
	 * <P>
	 * Because the inherent length measurement units for TV news stories are
	 * seconds, we need to convert the value we get from <code>getLength</code>.
	 * The design says we should use the conversion factor of 150 words per
	 * minute. (Of course, a minute is 60 seconds, so this is a conversion
	 * factor of 150/60.)
	 * </P>
	 * 
	 * @see NewsStory#getLengthInWords()
	 */
	@Override
	public int getLengthInWords() {
		return this.getLength();
	}

	/**
	 * Accessor method that returns the part of the day when the capture
	 * occurred.
	 * 
	 * @return The part of the day when the story was captured.
	 */
	public PartOfDay getPartOfDay() {
		return partOfDay;
	}

	/**
	 * Mutator method for the part of the day when the capture occurred.
	 * 
	 * @param partOfDay
	 *            The part of the day when the capture occurred.
	 */
	public void setPartOfDay(PartOfDay partOfDay) {
		if (partOfDay != PartOfDay.MORNING && partOfDay != PartOfDay.AFTERNOON) {
			throw new IllegalArgumentException(
					"Snapshots are only taken in the morning or the afternoon, not " + partOfDay);
		}
		this.partOfDay = partOfDay;
	}
	

	/**
	 * Overridden equals method to account for possible differences in
	 * <code>partOfDay</code>.
	 * <P>
	 * Note that we let the method in the parent do as much work as possible to
	 * reduce code duplication.
	 * </P>
	 * 
	 * @param o
	 *            The object to which to compare this.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof OnlineNewsStory) {
			if (super.equals(o)) {
				return this.partOfDay.equals(((OnlineNewsStory) o).partOfDay);
			} else {
				return false;
			}
		}
		// If it isn't an OnlineNewsStory, it's not equivalent.
		else {
			return false;
		}
	}
}
