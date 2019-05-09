public class Card implements Comparable<Card>{

	// instance variables

	private Color c;   // color of card
	private Value v;    // value of card
	private boolean view; // true if the rank of the card is visible

	// default constructor

	public Card()
	{
		this.c=null;
		this.v=null;
		this.view=true;
	}

	// consructor with parameters

	public Card(Color c, Value v)
	{
		this.view=false;
		this.c=c;
		this.v=v;
	}

	// accessors

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public Value getV() {
		return v;
	}

	public void setV(Value v) {
		this.v = v;
	}
	public boolean getView()
	{
		return this.view;
	}
	public void setView(boolean b)
	{
		this.view=b;
	}

	// class methods

	public String toString()
	{
		if(this.view==true)
		return this.c+""+this.v;
		else return " ▓ ";
	}
	public int compareTo(Card other)
	{
		if(this.c.compareTo(Color.SPADES)==0|| this.c.compareTo(Color.CLUBS)==0)
			if(other.getC().compareTo(Color.DIAMONDS)==0 ||other.getC().compareTo(Color.HEARTS)==0)
				return 1;
			else return -1;
		if(this.c.compareTo(Color.DIAMONDS)==0|| this.c.compareTo(Color.HEARTS)==0)
			if(other.getC().compareTo(Color.CLUBS)==0 ||other.getC().compareTo(Color.SPADES)==0)
				return 1;
			else return -1;

		return 0;
	}

}
