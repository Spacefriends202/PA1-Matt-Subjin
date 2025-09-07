public class Checking extends BankAccount{
//This class is very similar to the Abstract class with the only addition being type "checking" being added to toString()
//Constructors call upon BankAccount to fill in their attributes 
public Checking(String owner, double balance){super(owner, balance);}
public Checking(long number, String owner, double balance){super(number,owner,balance);}
public String toString(){
return String.format("%-10s\t%-10d\t%-30s\t$%-10.2f",
                            "Checking",super.getNumber(), super.getOwner(), super.getBalance());
}


}