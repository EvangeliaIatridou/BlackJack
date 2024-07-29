//Evaggelia Iatridou ,A.M.:4676
class CasinoCustomer{
	private String name;
	private double money;
	public CasinoCustomer(String name, double money){
		this.name = name;
		this.money = money;
	}
    public void payBet(double lost){
        this.money -= lost;
    }
    public void collectBet(double won){
        this.money += won;
    }
    public boolean canCover(double bet){
        if(this.money>=bet){
			return true;
        }
        return false;
    }
    public boolean isBroke(){
        if(this.money<1){
            return true;
        }
        return false;
    }
    public String toString(){
        return this.name;
    }
    public void printState(){
        System.out.println(this.name+" has "+this.money+"$ left ");
    }
}