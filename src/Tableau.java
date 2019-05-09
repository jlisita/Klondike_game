import java.util.Map;
import java.util.TreeMap;

public class Tableau {


	// instance variables

	private Map<String,Pile> m;  // map containing all piles

	private Pile hand;         // pile hold by the player
	private String lastHand;  // name of the last pile take by the hand


	// constructor

	public Tableau()
	{
		this.m=new TreeMap<String,Pile>();
		Stock stock=new Stock();
		stock.shuffle();
		this.distribute(stock);
		this.hand=new Pile();
	}
	public Map getM()
	{
		return this.m;
	}

	// class methods

	public void distribute(Pile stock)
	{
		this.m.put("waste", new Waste());
		for(int i=1;i<8;i++)
			this.m.put("r"+i,new Row(stock.take(i)));
	for(int i=1;i<5;i++)
		this.m.put("f"+i, new Foundation());
		for(String s : m.keySet())
			m.get(s).flipCard();
		this.m.put("stock", stock);
	}

	// flip the pile

	public void flipPile(String pilename)
	{
		this.m.get(pilename).flipPile();
	}

	// flip the top card of the pile

	public void flipCard(String pilename)
	{
			this.m.get(pilename).flipCard();

	}

	// return true if n cards can be taken on the pile

	public boolean canTake(String pilename, int n)
	{
		return this.m.get(pilename).canTake(n);
	}

	// take n card and place it in the hand

	public void take(String pilename, int n)
	{
		if(this.hand.getPile().size()==0)
		{
			this.hand=this.m.get(pilename).take(n);
		    this.lastHand=pilename;
	    }
		else
		{
			System.out.println("Place hand before take a new pile");
		}
	}

	// return true if the hand can be placed on the pile

	public boolean canPlace(String pilename)
	{
		return this.m.get(pilename).canPlace(hand);
	}

	// place the hand on the pile

	public void place(String pilename)
	{
		if(!this.lastHand.equals(pilename))
			this.flip(this.lastHand);

		this.m.get(pilename).place(hand);
		hand.getPile().clear();
	}

	// flip the last card of the pile
	public void flip(String pilename)
	{
		this.flipCard(pilename);
	}

	// put back the hand on the initial pile

	public void cancel()
	{
		this.place(this.lastHand);
	}

	// flip card from the stock and place it on waste

	public void pick()
	{

		if(this.m.get("stock").getPile().size()==0)
		{
			this.flipPile("waste");
			this.take("waste", this.m.get("waste").getPile().size());
			this.place("stock");
		}
		this.take("stock",1);
	    this.place("waste");
		this.flip(this.lastHand);
		this.m.get("waste").flipCard();
	}

	// place cards on the Foundation if possible

	public boolean clickLeft()
	{
		boolean b=false;
		for(int i=1;i<8;i++)
			for(int j=1;j<5;j++)
			  {
				if(this.canTake("c"+i, 1)==true)
		              {
					     this.take("c"+i,1);
					     if(this.canPlace("r"+j)==true)
					     {
						    this.place("r"+j);
					        return true;
					      }
					        else
					        	this.cancel();
				       }
			  }
			return false;
	}

	// call clickLeft() method while it return true

	public void storeAll()
	{
		boolean b;
		do{
			b=this.clickLeft();

		}while(b==true);
	}


	public String toString()
	{
		String str=new String();
		for(String s: m.keySet())
			str+=s+": "+m.get(s)+"\n";
		str+="\n hand\n"+hand.toString();
		return str;
	}

}
