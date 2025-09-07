public abstract class BankAccount{
    //attributes
    private long number;
    private String owner;
    protected double balance;
    private static long nextNumber = 1111111111L;
    //constructor for bank accounts, once the account is created nextnumber is incremented so that the accounts all have unique numbers.
    //Derived classes call on this constructor and add their additional attributes
    public BankAccount(String owner, double balance){
        
        this.number = nextNumber;
        this.owner = owner;
        this.balance = balance;
        nextNumber++;

    }
    //constructor for subsequent accounts, increments the next number and assings the current number to this object's number attribute.
    //After completing this assignment I am not sure this is ever used.
    public BankAccount(long number, String owner, double balance){
        nextNumber = number+1;
        this.number = number;
        this.owner = owner;
        this.balance = balance;

    
    }
    //getters
    public long getNumber(){return number;}
    public String getOwner(){return owner;}
    public double getBalance(){return balance;}
    //setters
    public void setNumber(long n){this.number = n;}
    public void setOwner(String o){this.owner = o;}
    //deposit method new balance = old balance + ammount added
    public void deposit(double amount){this.balance += amount;}
    //withdraw method new balance = old balance - ammount lost / returns true if amount less than balance and false if the amount is to large to be withdrawn.
    public boolean withdraw(double amount){
        if(this.balance < amount){return false;}
        else{this.balance -= amount;}
        return true;
    }
    //returns a string of all attributes except nextNumber.
    public String toString(){
        return String.format("%-10d\t%-30s\t$%-10.2f",
                            number, owner, balance);
    }










}