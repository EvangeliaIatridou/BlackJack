//Evaggelia Iatridou ,A.M.:4676
import java.util.Scanner;
class Player{
    private CasinoCustomer customer;
    private Hand hand = new Hand();
    private double bet;
    public Player(CasinoCustomer customer){
        this.customer = customer;
    }
    public Player(CasinoCustomer customer, Hand hand, double bet){ //#2
		this.customer = customer;
		this.hand = hand;
		this.bet = bet;
	}
    public CasinoCustomer getCasinoCustomer(){
        return this.customer;
    }
    public Hand getHand(){
        return this.hand;
    }
    public double getBet(){ 
        return this.bet;
    }
    public void wins(){ 
		System.out.println("Player "+customer+" won! Collect "+bet+"$.");
		customer.collectBet(bet);
	}
	public void winsBlackJack(){
		System.out.println("Blackjack! Player "+customer+" collects "+bet*1.5+"$.");
		customer.collectBet(bet*1.5);
	}
	public void loses(){
	    System.out.println("Player "+customer+" lost! Pay "+bet+"$.");
		customer.payBet(bet);
	}
	public void placeBet(){
		customer.printState();
		Scanner input = new Scanner(System.in);
		System.out.println(customer+" place your bet: ");
		double in = input.nextDouble();
		System.out.println();
		this.bet = in;
		while(customer.canCover(this.bet)==false || this.bet<1.0){ //
			System.out.println(customer+" place your bet: ");
			in = input.nextDouble();
			System.out.println();
		    this.bet = in;
		}
	}
	public void doubleBet(){
		this.bet = 2*this.bet;
	}
	public boolean wantsToDouble(){
		if(customer.canCover(2*this.bet)){
			Scanner input2 = new Scanner(System.in);
			System.out.print("Do you want to double? (y/n) ");
			String answer = input2.next();
			if(answer.equals("y")){
				return true;
			}else if(answer.equals("n")){
				return false;
			}			
		}return false;
	}
	public boolean wantsToSplit(){
		if(customer.canCover(2*this.bet) && this.hand.canSplit()==true){
			Scanner input3 = new Scanner(System.in);
			System.out.print("Do you want to split? (y/n) ");
			String answer2 = input3.next();
			if(answer2.equals("y")){
				return true;
			}else if(answer2.equals("n")){
				return false;
			}
		}return false;
	}
	public String toString(){
		return customer+": "+hand;
	}
	public static void main(String[] args){
		CasinoCustomer somecustomer = new CasinoCustomer("Eva",50);
		Player someplayer = new Player(somecustomer);
		someplayer.placeBet();
		someplayer.wantsToSplit();
		someplayer.getCasinoCustomer().printState();
		someplayer.wantsToDouble();	
        someplayer.getCasinoCustomer().printState();		
		someplayer.wins();
		someplayer.getCasinoCustomer().printState();
		someplayer.winsBlackJack();
		someplayer.getCasinoCustomer().printState();
		someplayer.loses();
		someplayer.getCasinoCustomer().printState();
	}	
}