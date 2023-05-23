import java.util.*;

class BankAccount
{
    String name;
    String userName;
    String password;
    String accountNumber;
    float balance =10000f;
    String TransactionHistory="";
    int transaction=0;

   /* BankAccount(String name,String userName, String password, String accountNumber)
    {
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.accountNumber=accountNumber;
    }*/
    public void register()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Details To Create New Account :");
        System.out.println("Enter Your Name :");
        name=sc.next();
        System.out.println("Create a User Name :");
        userName=sc.next();
        System.out.println("Create a Password :");
        password=sc.next();
        System.out.println("Enter Your Account Number :");
        accountNumber=sc.next();
        System.out.println("Account Create Successfully.............");
    }





    public boolean login()
    {
        boolean islogin=false;
        Scanner sc = new Scanner(System.in);
        while(!islogin)
        {
            System.out.println("Enter Your UserName :");
            String UserName =sc.next();
            if(UserName.equals(userName))
            {
                while(!islogin)
                {
                    System.out.println("Enter the Password "+userName+" UserName ");
                    String Password = sc.next();
                    if(Password.equals(password))
                    {
                        System.out.println("Login is Successfull");
                        islogin=true;
                    }
                    else
                    {
                        System.out.println("You Have Entered Wrong Password");
                    }
                }
            }
            else
            {
                System.out.println("You have Entered Wrong UserName");
            }
        }
        return islogin;
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw :");
        float amount = sc.nextFloat();

        try {
            if (balance >= amount) {
                transaction++;
                balance = balance - amount;
                System.out.println("Successfully Withdraw Money...");
                String str = amount + " is Withdraw   ";
                TransactionHistory = TransactionHistory.concat(str);

            } else {
                System.out.println("Amount is not sufficient......");
            }
        }
        catch(Exception e){

        }

    }

    public void deposite()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposite");
        float amount =sc.nextFloat();

        try {
            if (amount <= balance) {
                transaction++;
                balance = balance + amount;
                System.out.println("\nDeposited Successfully...");
                String str = amount + " is deposited   ";
                TransactionHistory = TransactionHistory.concat(str);
            } else {
                System.out.println("Deposite amount less than 10K");
            }
        }
        catch(Exception e)
        {}
    }


    public void tranfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to Transfer :");
        float amount =sc.nextFloat();
        System.out.println("Enter the receipent name :");
        String receipent=sc.next();

        try {

            if (amount <= balance) {
                if (amount <= 5000f) {
                    transaction++;
                    balance = balance - amount;
                    System.out.println("\nTransfer Successesfull.....");
                    String str = amount + " is Transfered to   " + receipent;
                    TransactionHistory = TransactionHistory.concat(str);
                } else {
                    System.out.println("Enter amount less than 5K");
                }
            } else {
                System.out.println("Insufficient Amount.....");
            }
        }
        catch(Exception e)
        {

        }
    }

    public void checkBalance()
    {
        System.out.println("Total Balance :"+balance);
    }

    public void TransactionHistory()
    {
        if(transaction==0)
        {
            System.out.println("No Transaction History...");
        }
        else
        System.out.println("Transaction History :\n"+TransactionHistory+" \n");
    }







}
public class ATMInterface
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
       BankAccount b = new BankAccount();
      /* b.register();
       b.login();
       b.withdraw();
       b.deposite();*/
        b.register();
        System.out.println("\n**********WELCOME TO  ATM SYSTEM**********\n");
        System.out.println("1.Login \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int ch = sc.nextInt();

        if(ch==1)
        {
         if(b.login())
         {
             System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
             boolean isfinished=false;

             while(!isfinished)
             {
                 System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                 System.out.print("\nEnter Your Choice - ");
                 int c = sc.nextInt();

                 switch(c)
                 {
                     case 1:
                         b.withdraw();
                         break;


                     case 2:
                         b.deposite();
                         break;

                     case 3:
                         b.tranfer();
                         break;

                     case 4:
                         b.checkBalance();
                         break;

                     case 5:
                         b.TransactionHistory();
                         break;

                     case 6:
                         isfinished=true;
                         break;

                 }
             }
         }
        }
        else if(ch==2)
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Wrong input.....");
        }

    }
}
