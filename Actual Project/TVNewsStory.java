import java.time.LocalDate;
import java.io.Serializable;

public class TVNewsStory extends NewsStory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4849689623763059399L;
	
	/**
	 * The part of the day that the news story was broadcast (morning,
	 * afternoon, evening, or late night).
	 */
	private PartOfDay partOfDay;

	public TVNewsStory(LocalDate date, String source, int length, String topic, String subject, PartOfDay partOfDay,
			NewsMakerModel newsMaker1, NewsMakerModel newsMaker2) {
	}

	public int getLengthInWords() {
		return this.getLength() * 150 / 60;
	}

	public PartOfDay getPartOfDay() {
		return partOfDay;
	}

	public boolean equals(Object o) {
		if (o instanceof TVNewsStory) {
			if (super.equals(o)) {
				return this.partOfDay.equals(((TVNewsStory) o).partOfDay);
			} else {
				return false;
			}
		}
		// If it isn't a TVNewsStory, it's not equivalent.
		else {
			return false;
		}
	}
}
