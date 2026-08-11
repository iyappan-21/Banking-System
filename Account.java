import java.util.ArrayList;
public class Account {
    private String account_num;
    private int user_id;
    private long password;
    private float balance;
    private ArrayList<String> history=new ArrayList<>();

    public static long accountcount=1;

    Account(int user_id,String account_num,long password,float balance){
        this.user_id=user_id;
        this.account_num=account_num;
        this.password=password;
        this.balance=balance;
    }
    public String accountNumber(){
        return account_num;
    }

    public float availableBalance(){
        return balance;
    }
    public void  trasactionHistory(){
        for(String s:history){
            System.out.println("-----------------------------------------------------");
            System.out.println(s);
            System.out.println("-----------------------------------------------------");
        }

    }
    //account nuber counter

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.err.println("-----------------------------------------------------------------");
            System.out.println("Deposited: " + amount);
            System.out.println("balance: "+ balance);

            System.err.println("-----------------------------------------------------------------");
        } else {
            System.out.println("Invalid deposit amount.");
        }
        history.add(amount+"deposited  Balance"+balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Transaction denied.");
        } else {
            balance -= amount;
            System.err.println("__________________________________________________________________");
            System.out.println("Withdrew: "+ amount);
            System.out.println("balance: "+ balance);

            System.err.println("__________________________________________________________________");
        }
        history.add(amount+"withdrawed  Balance"+balance);


    }


    
}
