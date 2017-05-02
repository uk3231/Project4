
public enum NewsMetric {
	LENGTH, COUNT;
	
	public String toString(){
		switch(this){
		case LENGTH:
			return "Length";
		case COUNT:
			return "Length";
		default:
			throw new IllegalArgumentException();
		}
	}

}
