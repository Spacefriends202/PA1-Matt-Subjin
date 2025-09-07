public class Savings extends BankAccount{
private double YearlyintrestRate;
//Savings accounts have added functionality for yearly interest rate which is applied monthly.
//constructors use the BankAccount's constructor then add an interest rate double value.
public Savings(String owner,double balance, double yIntrestRate){
    super(owner,balance); 
    this.YearlyintrestRate = yIntrestRate;  
}
public Savings(long number, String owner,double balance, double yIntrestRate){
    super(number,owner,balance);
    this.YearlyintrestRate = yIntrestRate;
}
//getter for interest rate
public double getYearlyInterest(){return YearlyintrestRate;}
//uses the function below to to add interest to the account each month.
public double applyMonthlyInterest(){
    //balance = balance + ((yearly interest/12)/100)*balance
   double temp = YearlyintrestRate/12;
   temp = (temp/100) * balance; 
   balance += temp;
    
   return temp; 
}
//setter for interest rate.
public void setYearlyInterest(double y){this.YearlyintrestRate = y;}
//modified toString to output type "Savings" and display the interest rate
public String toString(){
return String.format("%-10s\t%-10d\t%-30s\t$%-10.2f\t%-10.2f",
                            "Savings",super.getNumber(), super.getOwner(), super.getBalance(), YearlyintrestRate);


}


}