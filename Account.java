import java.util.ArrayList;
public class Account {
    long account_num;
    long password;
    float balance;
    ArrayList<String> history=new ArrayList<>();

    Account(int account_num,long password,float balance){
        this.account_num=account_num;
        this.password=password;
        this.balance=balance;
    }
    public long accountNumber(){
        return account_num;
    }

    public float availableBalance(){
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: "+ amount);
        }
    }


    
}
