//Evaggelia Iatridou ,A.M.:4676
class Dealer{
	private River river;
	private Hand hand = new Hand();
	public Dealer(River river){
		this.river = river;
	}
	public Hand getHand(){
		return this.hand;
	}
	public void draw(){
		this.hand.addCard(river.nextCard());
	}
	public void deal(Player player){
		player.getHand().addCard(river.nextCard());
	}
	public void play(){
		while(this.hand.score()<17){
			this.hand.addCard(river.nextCard());
		}
	}
	public void settle(Player player){
	    if(this.hand.isBust()==false){
			if(player.getHand().isBlackJack()==true){
				player.winsBlackJack();
			}
		    if(player.getHand().isBust()==false){
			    if(this.hand.score()==player.getHand().score()){
				    System.out.println("Tie with "+player.getCasinoCustomer()+". Nobody wins");
			    }else if(this.hand.score()<player.getHand().score()){ 
				    if(player.getHand().isBlackJack()==true){
					    player.winsBlackJack();
				    }else{
					    player.wins();
				    }
			    }else if(this.hand.score()>player.getHand().score()){ 
				    player.loses();
			    }
		    }else if (player.getHand().isBust()==true){
			    player.loses();
		    }
	    }else if (this.hand.isBust()==true){
		    if(player.getHand().isBust()==true){ 
			    player.loses();
		    }else if(player.getHand().isBust()==false){ 
		        if(player.getHand().isBlackJack()==true){
				    player.winsBlackJack();
			    }else{
				    player.wins();
			    }
		    }
	    }
    }
	public String toString(){
		return "Dealer: "+this.hand;
	}
	public static void main(String[] args){
		River someriver = new River(1);		
		Dealer somedealer = new Dealer(someriver);
		somedealer.play();
		System.out.println(somedealer); 
		CasinoCustomer customer = new CasinoCustomer("Eva",20);
		Player player = new Player(customer);
		somedealer.deal(player);
		somedealer.deal(player);
		System.out.println(player);
		somedealer.settle(player);
	}
}