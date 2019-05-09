import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pile {

	protected List<Card> pile;      // list of cards
	public Pile()
	{
		this.pile=new ArrayList<Card>();

	}

	// accessors

	public List<Card> getPile()
	{
		return this.pile;
	}
	public void setPile(List<Card> pile)
	{
		this.pile=pile;
	}

	// class methods

	public String toString()
	{
		String str=new String();
		for(int i=0;i<this.pile.size();i++)
		{
			str+=this.pile.get(i)+" ";

		}
		return str;
	}

	// return the last card of the pile
	public Card lastCard()
	{
		Card c=new Card();
		if(this.pile.size()!=0)
		c=this.pile.get(this.pile.size()-1);
		return c;
	}

	// return the first card of the pile
	public Card firstCard()
	{
		Card c=new Card();
		c=this.pile.get(0);
		return c;
	}

	// return the number of visible cards on the pile
	public int nbrVisible()
	{
		int n=0;
		for(Card c: this.pile)
			if(c.getView()==true)
				n++;
		return n;
	}

	// flip the top card of the pile
	public void flipCard()
	{
		if(this.pile.isEmpty()==false)
		{
				this.pile.get(pile.size()-1).setView(true);
		}
	}
	// flip the pile
	public void flipPile()
	{
		Collections.reverse(this.pile);
		for(Card c : this.pile)
		{
			if(c.getView()==false)
				c.setView(true);
			else
				c.setView(false);
		}
	}


	public boolean canTake(int n)
	{
		return false;
	}
	public boolean canPlace(Pile p)
	{
		return false;
	}


	// return pile of n cards of the pile
	public Pile take(int n)
	{
		List<Card> extractedList=this.pile.subList(this.pile.size()-n,this.pile.size());
		List<Card> l=new ArrayList<Card>(extractedList);
		this.pile=this.pile.subList(0,this.pile.size()-n);
		Pile p=new Pile();
		p.setPile(l);
		return p;
	}



	// place pile on the other pile
	public void place(Pile other)
	{
		for(Card c : other.getPile())
		{
			this.getPile().add(c);
		}
	}

}
