public class Foundation extends Pile {

	public Foundation()
	{
		super();
	}

	// redefinition of pile method with Foundation rules

	public boolean canTake(int n)
	{
		if(n==1)
			return true;
		else return false;
	}


	public boolean canPlace(Pile other)
	{
		if(other.getPile().size()==1)
		{
			if (this.pile.size()==0)
				if(other.lastCard().getV().compareTo(Value.AS)==0)
					return true;
			  else return false;
		else{
			if(this.lastCard().getV().compareTo(other.lastCard().getV())==-1 && this.lastCard().getC().compareTo(other.lastCard().getC())==0)
			return true;
		}
		}else
			{
			System.out.println("You can take only one card on this pile !");
			return false;
			}
		return false;
	}


}
