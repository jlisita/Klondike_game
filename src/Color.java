public enum Color {
	CLUBS, SPADES, HEARTS, DIAMONDS;



	public String toString()
	{
		if(this.compareTo(Color.CLUBS)==0)
			return "♣";
		if(this.compareTo(Color.SPADES)==0)
			return "♠";
		if(this.compareTo(Color.HEARTS)==0)
			return "♥";
		if(this.compareTo(Color.DIAMONDS)==0)
			return "♦";

		return " ";
		}

}
