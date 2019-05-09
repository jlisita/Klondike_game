public class Waste extends Pile {


	public Waste()
	{
		super();
	}

	// redefinition of pile method with Waste rules

	public boolean canTake(int n)
	{
		if (n==1)
			return true;
		else
			{
			System.out.println("You can take only one card on this pile !");
			return false;
			}
	}

	public  boolean canPlace(Pile other)
	{
		return false;
	}

	public String toString()
	{
		String str=new String();
		for(int i=0;i<this.pile.size();i++)
			if(this.pile.get(i).getView()==true)
				str+=this.pile.get(i)+" ";

		return str	;
	}

}
