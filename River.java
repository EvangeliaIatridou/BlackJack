//Evaggelia Iatridou ,A.M.:4676
import java.util.Random;
class River{ 
	private Card[] allcards;
	private int cardsLeft; 
	private int numberOfCards;
	private String[] cardArray = {"2","3","4","5","6","7","8","9","10","A","J","K","Q"};
	public River(int packs){
		numberOfCards = packs*cardArray.length*4;
        this.allcards = new Card[numberOfCards];
        int c =0;
		for(int i=c;i<numberOfCards;i++){
            if(i>0 && i%cardArray.length==0){
               c+=cardArray.length;
            }
            this.allcards[i] = new Card(cardArray[i-c]);
        } 		
		cardsLeft = numberOfCards;				
	}
	public Card nextCard(){
		if(cardsLeft>0){
		    Random rnd = new Random();
		    int randomCard = rnd.nextInt(cardsLeft);
			Card temp = allcards[cardsLeft-1];  
		    allcards[cardsLeft-1] = allcards[randomCard]; 
			allcards[randomCard] = temp;
            cardsLeft--;
		    return allcards[randomCard];
		}		
		return null;
	}
	public boolean shouldRestart(){
		if(cardsLeft<numberOfCards/4){
			return true;
		}
		return false;
	}
	public void restart(){
		cardsLeft = numberOfCards;
	}
	public static void main(String[] args){
		River river = new River(1);
		while(river.shouldRestart()==false){			
			System.out.println(river.nextCard());
		}
		river.restart();
		while(river.nextCard()!=null){
			System.out.println(river.nextCard());
		}
	}
}