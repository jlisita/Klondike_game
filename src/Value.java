public enum Value {
	AS, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;


	public String toString()
	{
		if(this.compareTo(Value.AS)==0)
			return "AS";
		if(this.compareTo(Value.TWO)==0)
			return "2";
		if(this.compareTo(Value.THREE)==0)
			return "3";
		if(this.compareTo(Value.FOUR)==0)
			return "4";
		if(this.compareTo(Value.FIVE)==0)
			return "5";
		if(this.compareTo(Value.SIX)==0)
			return "6";
		if(this.compareTo(Value.SEVEN)==0)
			return "7";
		if(this.compareTo(Value.EIGHT)==0)
			return "8";
		if(this.compareTo(Value.NINE)==0)
			return "9";
		if(this.compareTo(Value.TEN)==0)
			return "10";
		if(this.compareTo(Value.JACK)==0)
			return "JACK";
		if(this.compareTo(Value.QUEEN)==0)
			return "QUEEN";
		if(this.compareTo(Value.KING)==0)
			return "KING";

		return this+" ";
	}
}