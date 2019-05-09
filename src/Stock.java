import java.util.Collections;

public class Stock extends Pile {


	// constructor

	public Stock()
	{
		super();
		for(Color c : Color.values())        // add 52 different cards on the pile
			for(Value v : Value.values())
				this.pile.add(new Card(c,v));
	}

	// Shuffle cards of the pile

	public void shuffle()
	{
		Collections.shuffle(this.pile);
	}

	// redefinition of pile method with Stock rules

	public boolean canTake(int n)
	{
		return false;
	}

	public boolean canPlace(Pile other)
	{
		return false;
	}

	public String toString()
	{

		return this.pile.size()+" cards";
	}


}
