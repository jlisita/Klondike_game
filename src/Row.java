public class Row extends Pile {


	public Row(Pile p)
	{
		super();
		this.pile=p.getPile();
	}


	// return true if n card can be taken from the pile
	public boolean canTake(int n)
	{
		if (this.nbrVisible()>=n)
			return true;
			else return false;
	}

	// return true if the pile can be placed over the other pile
	public boolean canPlace(Pile other)
	{
		if(this.pile.size()==0)
			if(other.firstCard().getV().compareTo(Value.KING)==0)
				return true;
				else return false;
			else{

				if(this.lastCard().getV().compareTo(other.firstCard().getV())==1 && this.lastCard().compareTo(other.firstCard())==1 )
					return true;
			}
			return false;
	}

}
