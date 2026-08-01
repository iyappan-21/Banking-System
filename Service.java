import java.util.*;
public class Service {
    Scanner scanner=new Scanner(System.in);

    HashMap<Integer,User> users=new HashMap<>();

    HashMap<Integer,Account> accounts=new HashMap<>();
    


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
                "Account Holder  : " + name + "\n" +
                "Email Registered: " + email + "\n" +
                "Ph Number       : " + ph +"\n" +
                "----------------------------------------------");

    }
    
}
