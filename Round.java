//Evaggelia Iatridou ,A.M.:4676
import java.util.ArrayList;
import java.util.Scanner;
class Round{ 
	private Dealer dealer;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Player> settleList = new ArrayList<Player>();
	public Round(River river){
		dealer = new Dealer(river);		
	} 
	public void addPlayer(CasinoCustomer cust){
		Player player = new Player(cust);
		playerList.add(player);
	}
	public void playRound(){ 
		for(Player p: playerList){
			p.placeBet(); 
		}
		for(Player p2: playerList){
			dealer.deal(p2);
		}
		dealer.draw();
		System.out.println(dealer);
		
		for(Player p3: playerList){
			dealer.deal(p3);
		}
		dealer.draw();
		for(Player p4:playerList){
			System.out.println(p4);
		} 
		System.out.println();
		if(dealer.getHand().isBlackJack()==true){
			for(Player p5: playerList){
				System.out.println("Player "+p5);
				 if(p5.getHand().isBlackJack()==false){
					  p5.loses();
			     }
			}
		}
		else if(dealer.getHand().isBlackJack()==false){
			for(Player p9: playerList){
				System.out.println("Player "+p9);
				if(p9.getHand().isBlackJack()==true){
					p9.winsBlackJack();
				}else{
					playPlayer(p9);
					System.out.println();
				}
			}
		} 
		System.out.println();
		dealer.play(); 
		for(Player p7: playerList){
			if((p7.getHand().isBust()==false || p7.getHand().isBlackJack()==false) && playerList.contains(p7)==false){
				settleList.add(p7);
			}
		}
		System.out.println(dealer); 
		for(Player p8: playerList){
			dealer.settle(p8);
		}		
	}
	private void playNormalHand(Player p6){
		Scanner input = new Scanner(System.in);
		System.out.print("Hit? (y/n) ");
		String in = input.next();
		while(in.equals("y")){
			dealer.deal(p6);
			System.out.println(p6);
			if(p6.getHand().isBust()==true){
				in = "n";
			}else{
				settleList.add(p6);
				System.out.print("Hit? (y/n) ");
			    in = input.next();
			}								
		}
	}
	
	private void playDoubledHand(Player player){	
		player.doubleBet();
	}
	private void playSplitHand(Player player){			
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		hand1 = player.getHand().split()[0];
		hand2 = player.getHand().split()[1];
		Player playerHand1 = new Player(player.getCasinoCustomer(),hand1,player.getBet());
		playNormalHand(playerHand1);
		System.out.println();
        Player playerHand2 = new Player(player.getCasinoCustomer(),hand2,player.getBet());
        playNormalHand(playerHand2);		
        if(hand1.isBust()==false && hand2.isBust()==false){
			if(hand1.score()>=hand2.score()){
				player = playerHand1;
			}else if(hand1.score()<hand2.score()){
				player = playerHand2;
			}
		}else{
			if(hand1.isBust()){
				player = playerHand2;
			}else if(hand2.isBust()){
				player = playerHand1;
			}
		}				
	}
	private void playPlayer(Player player){ 
		if(player.wantsToSplit()==true){
			playSplitHand(player);
		}
		else if(player.wantsToDouble()==true){
			playDoubledHand(player);
			System.out.println(player);
		}else{
			playNormalHand(player);
		}		
	}
	public static void main(String[] args){
		River newRiver = new River(6);
		Round newRound = new Round(newRiver);
		CasinoCustomer customer = new CasinoCustomer("Eva",100);
		newRound.addPlayer(customer);
		newRound.playRound();
	}
	
}