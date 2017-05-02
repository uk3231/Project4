
public enum SortCriterion {
	SOURCE, TOPIC, SUBJECT, LENGTH, DATE_TIME;
	
	public String toString() {
		switch (this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		case LENGTH:
			return "Length";
		case DATE_TIME:
			return "Date/Time";
		default:
			throw new IllegalArgumentException();
		}
	}

}
