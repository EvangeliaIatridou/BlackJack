//Evaggelia Iatridou ,A.M.:4676
import java.util.Scanner;
class Blackjack{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Give the number of players: ");
		int number = input.nextInt();
		BlackjackTable table = new BlackjackTable(number);
		table.play();
	}
}