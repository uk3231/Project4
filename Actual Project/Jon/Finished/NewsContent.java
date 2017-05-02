
public enum NewsContent {

	SOURCE, TOPIC, SUBJECT;
	
	public String toString() {
		switch (this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
