//Assignment: Pa1
//TODO:Matt Subjin
public class Bank{
//array of BankAccount objects
private BankAccount[] accounts;
//counter for number of initialized accounts, all indexes in the array beyond count should be NULL.
private int count;

public Bank(){
//initalizes 50 BankAccount objects as NULL
 accounts = new BankAccount[50];
//since no accounts are added, counter is set to 0
count = 0;
}
//returns the number of accounts added.
public int size(){return count;}
//adds an account to the array, it's type depends on the type of object that is created in BankManager
public void add(BankAccount ba){
//adding an account
accounts[count] = ba;
//incrementing the counter
count++;
}
//finds an account based on it's number, if no account is found, returns NULL
public BankAccount find(long number){
    //searches through added accounts.
    for(int i = 0; i<count; i++){
        //if an account is found, return a reference to the object.
        long X = accounts[i].getNumber();
        if(X == number){return accounts[i];}
    }
    //if no account is found return NULL
    return null;
}
//removes an account based on it's number, or returns NULL if no such object exists
//BUG! for some reason dispite removing the correct object, it returns a number 1 higher than expected.
public BankAccount remove(long number){
//initializes k as -1, if an account is found k will become that account's index in the array.

int k = -1;
//searches through added accounts like the find method.
for(int i = 0; i<(count); i++){
        long X = accounts[i].getNumber();
        if(X == number){
            //if an account is found k will become that account's index in the array.
            k = i;
        }
    }
    //if k is found
if (k != -1){
    //goes through and moves each object down by one index in the array starting at k
    for(int X = k; X<count; X++){accounts[X] = accounts[X+1];}
    //decrements the counter now that there is 1 less object in the array
    count--;
    //should return the deleted object, but returns the object above it in the index for some reason.
    //I attempted to change the line to return accounts[k-1]; and it made it return the index BELOW the deleted object. 
    //This is probably because the object in question has been deleted by the time it needs to be returned
    return accounts[k];
    }
return null;
}
//Insertion sort method that sorts the array of accounts based on their balence 
public void sort(){
    for (int i=1; i<count; i++) {
        //Insert element i in the sorted sub-list
        BankAccount currentVal = accounts[i];
        int j = i;
        
        while (j>0 && currentVal.getBalance() < accounts[j - 1].getBalance()){
        // Shift element (j-1) into element (j)
        accounts[j] = accounts[j - 1];
        j--;
 	    }
 	    // Insert currentVal at position j
 	    accounts[j] = currentVal;
   }
}
//Main toString method that prints out the table of accounts and all relevent information for them based on the template in output.reference
//calls upon the toString methods from different account types to display their information then prints the newline character.
public String toString(){
    String out =  String.format("%-10s\t%-10s\t%-30s\t%-10s\t%-10s\n",
                            "Type","Number", "Owner", "Balance", "Interest/Type");
    for(int i = 0; i<count; i++){
        out += accounts[i].toString();
        out += "\n";
    }
    return out;
}

}