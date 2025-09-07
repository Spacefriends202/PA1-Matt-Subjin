public class Investment extends BankAccount{
private String type; //can be Property, Growth, or Shares.
//Investment accounts have added functionality for Type, and their value can change depending on risk.
public Investment(String owner, double balance, String type){super(owner,balance); this.type = type;}
public Investment(long number,String owner, double balance, String type){super(number,owner,balance); this.type = type;}
//getter for type
public String getType(){return type;}
//setter for type
public void setType(String type){this.type = type;}
//Uses risk to determine whether to add %5 to the balence or subtract %2 if risk is lower than 0.5
public double getProfitOrLoss(double risk){
    double temp;
    if(risk < 0.5){temp = -1*(balance*0.02);}
    else{temp = balance * 0.05;}
    balance +=temp;
    return temp;
}
//modified toString to output type "Investment" and display the Investment type.
public String toString(){
return String.format("%-10s\t%-10d\t%-30s\t$%-10.2f\t%-10s",
                            "Investment",super.getNumber(), super.getOwner(), super.getBalance(), type);
}

}