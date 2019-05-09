import java.util.Scanner;

public class Patience {


	private Tableau t;  // game board
	int error;
	private int nbrTurns;  // number of times a card is places

	public Patience()
	{
		this.t=new Tableau();
		this.error=0;
		this.nbrTurns=0;

	}

	// class method


	// ask player to enter a command

	public void play()
	{

		System.out.println("New game: \nlist of commands:\n-take pilename nbrcards"
	    +"\n-place pilename\n-Cancel to put back card\n-Enter to pick a card from stock"
        +"\n-play again\n-quit\n");
		String command =new String();
		Scanner sca=new Scanner(System.in);

		do{
			System.out.println(t);
			System.out.println("Enter a command:");
			command=sca.nextLine();
			this.execute(command);
			if(error>=5)
			{
				System.out.println("You should read game rules again!");
				error=0;
			}
		}while(!command.equals("quit") && this.testEnd()==false);


		System.out.println("enter reset ti play again");
		command=sca.nextLine();
		if(command.equals("reset")){
			new Patience();

		}

	}
	// reset the board game

	public void reset()
	{
		this.t=new Tableau();
	}

	// return true when all foundation are full

	public boolean testEnd()
	{
		int s=0;
		for(int i=1;i<5;i++)
			s= s+ ((Pile) this.t.getM().get("r"+i)).getPile().size();
		if(s==52)
		    {
			    System.out.println("Congratulation ! You have finish in "+this.nbrTurns+" turns.");
			    return true;
			}
		return false;
	}

	// check command enter by the player

	public void execute(String command)
	{
		Scanner sc=new Scanner(command);
		if (command.length()==0)
			this.t.pick();
		else{
		String com1 =sc.next();
		try{
		String name;
		int n;
		if (com1.compareTo("take")==0)
		{
			 name =sc.next();
			 n=sc.nextInt();
			 if(t.canTake(name,n)==true)
				 this.t.take(name,n);
			 else {
				 this.error++;
				 System.out.println("invalid choice");
			 }
		}
		if(com1.compareTo("place")==0)
		{
			name=sc.next();
			if(t.canPlace(name)==true)
			{
				nbrTurns++;
				this.t.place(name);
			}
			else
				{
				    System.out.println("invalid move");
				    error++;
				}
		}
		if(com1.compareTo("cancel")==0)
			this.t.cancel();
		if(com1.compareTo("reset")==0)
			this.reset();
		if(com1.compareTo("store")==0)
			this.t.clickLeft();
		}catch(Exception e){
			System.out.println("invalid command");

		};
		}
	}
}
