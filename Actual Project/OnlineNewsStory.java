import java.time.LocalDate;
import java.io.Serializable;

public class OnlineNewsStory extends NewsStory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3828142122581250642L;

	/**
	 * The part of the day that the news story was captured (morning or
	 * afternoon).
	 */
	private PartOfDay partOfDay;

	public OnlineNewsStory(LocalDate date, String source, int length, String topic, String subject,
			PartOfDay partOfDay, NewsMakerModel newsMaker1, NewsMakerModel newsMaker2) {
		super(date, source, length, topic, subject, newsMaker1, newsMaker2);
		// TODO: Check to ensure the part of day is valid.
		this.partOfDay = partOfDay;
	}

	public int getLengthInWords() {
		return this.getLength();
	}

	public PartOfDay getPartOfDay() {
		return partOfDay;
	}

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
