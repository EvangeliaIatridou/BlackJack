//Evaggelia Iatridou ,A.M.:4676
import java.util.Scanner;
class BlackjackTable{ 
	private River river =  new River(6);
	private CasinoCustomer[] customerArray;
	private int customers;
	private CasinoCustomer createCasinoCustomer(){
		Scanner input = new Scanner(System.in);
		System.out.println("Give customer name and available money");
		String name = input.next();
		int money = input.nextInt();
		CasinoCustomer newCustomer = new CasinoCustomer(name,money);
		return newCustomer;			
	}
	public BlackjackTable(int customers){
		this.customers = customers;
		customerArray = new CasinoCustomer[customers];
		for(int i =0; i<customers; i++){
			customerArray[i] = createCasinoCustomer();
		}		
	}
	public void play(){
		int brokeCounter = 0;
		for(CasinoCustomer c: customerArray){
			if(c.isBroke()==true){
				brokeCounter++;
			}
		}
		while(brokeCounter!=customers){
			Round newRound = new Round(river);	
            brokeCounter = 0;			
			for(CasinoCustomer c2: customerArray){
				if(c2.isBroke()){
					brokeCounter++;					
				}else{
					newRound.addPlayer(c2);					
				}
			}
			if(this.river.shouldRestart()==true){
			    river.restart();
		    }
			if(brokeCounter!=customers){
				System.out.println();
			    System.out.println("---- New Round! ----");
		     	System.out.println();
		    	newRound.playRound();								
			}			
		}
	}
}