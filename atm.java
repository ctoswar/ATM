import java.util.*;
public class atm {  
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        UserAccount user = new UserAccount("Duncan John D. Carpiso","duncan", 1234);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your username");
            String user_1 = sc.nextLine();
            System.out.println("Enter your password");
            Integer user_2 =sc.nextInt();
            user.ValidateLogin(user_1, user_2);
            acc.main_menu();
        }catch(Exception ex){
            System.err.println("no Strings in password");
        }
    }
}
class BankAccount{
    double balance;
    double previousTransaction;
    void main_menu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose 1-4");
        System.out.println("1. Withdrawal 2.Deposit");
        System.out.println("3.Previous Transaction  4.Balance Inquiry");
        System.out.println("5 Exit\n");
        System.out.println("Enter: ");
        
        int menu = s.nextInt();
        switch(menu){
            case 1 :
                System.out.println("Enter Amount of Withdrawal\n");
                double withdraw = s.nextDouble();
                withdraw(withdraw);
                main_menu();
                break;
            case 2 :
                System.out.println("Enter Amount of Deposit\n");
                double deposit = s.nextDouble();
                deposit(deposit);
                main_menu();
                break;
            case 3 :
                getPreviousTransaction();
                main_menu();
                break;
            case 4:
                System.out.println("\n Balance: " +  balance+"\n");
                main_menu();
            case 5 :
                System.exit(menu);
                break;
        }
    }
    void deposit(double amount){
        if(amount !=0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount){
        if(amount != 0){
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposit: " + previousTransaction);

        }else if(previousTransaction<0){
            System.out.println("Withdraw: " +  Math.abs(previousTransaction));
        }else{
            System.out.println("\n No transaction \n");
        }
    }
}
class UserAccount{
    private String full_name;
    protected String user_name;
    protected Integer user_password;

    public UserAccount(String name,String Uname,Integer pass){
        this.full_name = name;
        this.user_name = Uname;
        this.user_password = pass;
    }


   
    public boolean ValidateLogin(String Uname, Integer pass){
        
        if(this.user_name.equals(Uname)&&this.user_password.equals(pass)){
            System.out.println(getName());
            
            return true;
        }else{
            System.out.println("there's no username and password in our database");
            System.exit(0);
            return false;
        }
    }

    public String getName(){
        full_name = "\nWelcome " + full_name;
        return this.full_name;
    }
}
