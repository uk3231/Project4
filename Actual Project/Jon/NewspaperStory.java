import java.time.LocalDate;
import java.io.Serializable;

public class NewspaperStory extends NewsStory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4564194341819810659L;

	public NewspaperStory(LocalDate date, String sourceName, int length, String topic, String subject,
			NewsMakerModel newsMaker1, NewsMakerModel newsMaker2) {
		super(date, sourceName, length, topic, subject, newsMaker1, newsMaker2);
	}

	/**
	 * Overrides the <code>getLengthInWords</code> method from
	 * <code>NewsStory</code>.
	 * <P>
	 * Because the inherent length measurement units for newspaper stories are
	 * words, we can simply return the value we get from <code>getLength</code>.
	 * </P>
	 * 
	 * @see NewsStory#getLengthInWords()
	 */
	@Override
	public int getLengthInWords() {
		return this.getLength();
	}
}
