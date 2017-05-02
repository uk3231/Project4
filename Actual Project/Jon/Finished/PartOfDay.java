
public enum PartOfDay {
	MORNING, AFTERNOON, EVENING, LATE_NIGHT;

	/**
	 * The overridden <code>toString</code> method gives the part of day in
	 * "Title Case."
	 */
	@Override
	public String toString() {
		switch (this) {
		case MORNING:
			return "Morning";
		case AFTERNOON:
			return "Afternoon";
		case EVENING:
			return "Evening";
		case LATE_NIGHT:
			return "Late Night";
		default:
			throw new IllegalArgumentException();
		}
	}
}
