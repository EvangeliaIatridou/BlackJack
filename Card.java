//Evaggelia Iatridou ,A.M.:4676
import java.lang.Integer;
class Card{
	private String card;
	public Card(String card){
		this.card = card;
	}
	public int getValue(){
		if(this.card.equals("A")){
			return 1;
		}else if(this.card.equals("J")|| this.card.equals("Q")|| this.card.equals("K")){
			return 10;
		}else{
		    return Integer.valueOf(this.card); 
		}		
	}
	public boolean isAce(){
		if(this.card.equals("A")){
			return true;
		}
		return false;
	}
	public boolean equals(Card other){
		if(this.card.equals(other.card)){
			return true;
		}
		return false;
	}
	public String toString(){
		return this.card;
	}
}