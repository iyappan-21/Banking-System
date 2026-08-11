import java.util.Scanner;
public class BankingSystem {
    
    public static void main(String arg[]){
            Scanner sc = new Scanner(System.in);
        Service service=new Service();




        while (true) { 
            display();
            System.out.println();
            System.out.print("Select one option: ");
                int n = sc.nextInt();
                // handle selection (placeholder)
                switch(n){
                    case 1:
                        service.register();
                        break;

                    case 2:
                        service.createAccount();
                        break;
                    case 3:
                        service.deposite();

                    case 4:
                        service.withdraw();
                    
                    case  5:
                        service.monyTransfer();
                        
                    
                    default:
                        break;
                }

        
            
        }
        }
    


    static void display(){
        System.out.println("""
            1.register new User
            2.Create new account
            3.Deposit
            4.Withdraw
            5.Transaction
        """);
    }

}




    

