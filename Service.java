import java.util.*;
public class Service {
    Scanner scanner=new Scanner(System.in);

    HashMap<Integer,User> users=new HashMap<>();

    HashMap<String,Account> accounts=new HashMap<>();
    


    public void register(){
        System.out.println("Enter your full name: ");
        String name=scanner.nextLine();
        System.out.println("Enter your Phone Number: ");
        long ph=scanner.nextLong();

        System.out.println("Enter your email ID: ");
        String email=scanner.next();

        User u=new User(name,ph,email);
        u.setUserId();

        //add the user oject to users hash map
        users.put(u.getId(),u);

        

        System.out.println("REGISTRATION SUCCESSFUL!\n" +
                "----------------------------------------------\n" +
                "User Name       : " + name + "\n" +
                "User Id         :"  +u.getId()+"\n"+
                "Email Registered: " + email + "\n" +
                "Ph Number       : " + ph +"\n" +
                "----------------------------------------------");

    }

    public boolean isExist(int user_id){
        return users.containsKey(user_id);
    }



    //method for new bank account gendration
    public void createAccount(){
        System.out.println("Enter your User Id: ");

        int u_id=scanner.nextInt();
        if(isExist(u_id)){
            User u=users.get(u_id);

            System.out.println("Welcome "+u.getName());
            System.out.print("====Please Enter the belove details clearly====");
            System.out.println("-------------------------------------------------------------------");

            System.out.println("Create New PIN for your Bank Account :");
            long password=scanner.nextLong();

            System.out.println("Confirm PIN :");
            long cpassword=scanner.nextLong();

            while(!(password==cpassword)){
                System.out.println("Create New PIN for your Bank Account :");
                password=scanner.nextLong();

            System.out.println("Confirm PIN :");
                cpassword=scanner.nextLong();


            }
            System.out.println("PIN Gendrated succesfully");

            System.out.println("Enter your initial balance");
            float balance=scanner.nextFloat();

            

            String s1=String.format("%04d%02d%05d",u.getId(),u.getCount(),Account.accountcount);
            Account.accountcount++;
            
            Account acc=new Account(u.getId(),s1,password,balance);
            accounts.put(s1,acc);

            System.out.println("New BankAccount created Succesfully ");

            System.out.println("--------------------------------------------------------");
            System.out.println(

                "Account holder:" +u.getName()+"\n"+
                "Account Number:" +acc.accountNumber()+"\n"+
                "Balance       :" +acc.availableBalance()+"\n"
            
            );

        }

        else{
            System.out.println("user did not Exist");

            System.out.println("Register First");
        
        }


    }

    public void deposite(){

        System.out.println("Enter your Account number: ");
        String a_num=scanner.next();

        if(!accounts.containsKey(a_num)){
            System.err.println("there is no account in this Account Number");
            System.out.println("Please recheck your acccount Number");
            return;
        }

        
        System.out.println("Enter the ammount to deposit: ");
        double ammount=scanner.nextFloat();

        accounts.get(a_num).deposit(ammount);     

    }
    public void withdraw(){
        System.out.println("Enter your Account number: ");
        String a_num=scanner.next();

        if(!accounts.containsKey(a_num)){
            System.err.println("there is no account in this Account Number");
            System.out.println("Please recheck your acccount Number");
            return;
        }
        System.out.println("Enter the ammount to withdrow: ");
        double amount=scanner.nextFloat();

        accounts.get(a_num).withdraw(amount); 



    }
    void monyTransfer(){
        System.out.println("Enter your Account number");
        String a_num=scanner.next();
        if(!accounts.containsKey(a_num)){
            System.out.println("""
            there is no Account in this Account nUmber

            Try Again with correct account Number
        """);
            return;

        }
        System.out.println("Enter the recivers Account number");
        String r_num=scanner.next();

         if(!accounts.containsKey(a_num)){
            System.out.println("""
            there is no Account in this Account nUmber

            Try Again with correct account Number
        """);
            return;

        }

        System.out.println("Enter the ammount to transfer");
        double amount=scanner.nextDouble();
        //geting recivers account using account number
        Account reciver=accounts.get(r_num);
        //senders account
        Account sender=accounts.get(a_num);

        //cheking sender's balance if have suficient balance move further
        if(sender.availableBalance()>=amount){
            reciver.deposit(amount);
            sender.withdraw(amount);

            System.out.println("Transaction Success" + "\n"+
            
            amount+"tranfered from"+a_num+"to"+r_num+"");

        }
        


    }





}

    

