//Evaggelia Iatridou ,A.M.:4676
import java.util.ArrayList;
class Hand{
	private ArrayList<Card> cardlist = new ArrayList<Card>();
	private int points;
	public void addCard(Card sth){
		this.cardlist.add(sth);
	}
	public int score(){ 
		int AceCounter = 0;
		int P = 0;
		for(Card c: cardlist){ 
			P+=c.getValue();
			if(c.isAce()){
				AceCounter++;
			}
		}
		if(AceCounter==0){
			this.points = P;
		}else if (AceCounter>=1 && P+10<=21){
			this.points = P+10;
		}else{
			this.points = P;
		}
		return this.points;
	}
	public boolean canSplit(){
		if(cardlist.size()==2){
			if(cardlist.get(1).equals(cardlist.get(0))){
				return true;
			}
			return false;
		}
		return false;
	}
	public Hand[] split(){
		if(canSplit()==true){
            Hand[] somehand = new Hand[2];
            Hand first = new Hand();
            Hand second = new Hand();
            first.cardlist.add(cardlist.get(0));			
			second.cardlist.add(cardlist.get(1));
            somehand[0] = first;
            somehand[1] = second;
		    return somehand;
		}
		return null;
	}
	public boolean isBlackJack(){
		if(this.points==21 && cardlist.size() == 2){ 
			return true;
		} 
		return false;
	}
	public boolean isBust(){
		if(this.points>21){
			return true;
		} 
		return false;
	}
	public String toString(){
		String s = "";
		for(Card c: cardlist){
			 s+=c+" ";
		}
		return s;
	}
	public static void main(String[] args){
		Hand hand = new Hand();
		hand.addCard(new Card("A"));
		hand.addCard(new Card("A"));
        System.out.println(hand);
		System.out.println(hand.score());
		System.out.println(hand.canSplit());
        Hand h = new Hand();
        Hand h2 = new Hand();
		h=hand.split()[0];
		h2=hand.split()[1];
        System.out.println(h);
        System.out.println(h2);
        h.addCard(new Card("K"));
        System.out.println(h);
        System.out.println(h.score());
        System.out.println(h.isBlackJack());
        h.addCard(new Card("A"));
        System.out.println(h);
    	System.out.println(h.score());
        h.addCard(new Card("10"));
        System.out.println(h);
        System.out.println(h.score());
        System.out.println(h.isBust());
		
	}
}