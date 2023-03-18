import java.util.Scanner;
import java.util.concurrent.locks.Condition;

class customer{
    private static int account_no;
    private static String holder_name;
    private static float account_balance;
    
    static int flag; 
    static float amount;
    static float withdraw_amount;

private static void  initializecustomer(){
        Scanner acno=new Scanner(System.in);
        System.out.print("Enter the account number: ");
        account_no=acno.nextInt();
        Scanner name=new Scanner(System.in);
        System.out.print("Enter the name:");
        holder_name=name.nextLine();
        Scanner balance=new Scanner(System.in);
        System.out.print("Enter the blance:");
        account_balance=balance.nextFloat();

    }

    private static float depositemoney(){
        
        Scanner money= new Scanner(System.in);
        System.out.print("Enter the amount that you want to deposite:");
        amount=money.nextInt();
        account_balance += amount;
        System.out.print("Deposited successfully");
        flag=1;
        return account_balance;

    }
    private static float withdraw (){
        
        Scanner withdraw =new Scanner(System.in);
        System.out.print("Enter the withdraw amount:");
        withdraw_amount=withdraw.nextInt();
        if (account_balance>=withdraw_amount){
            account_balance -= withdraw_amount;
            System.out.println("Withdrawal successful.");
            flag=0;
        } else {
            System.out.println("Insufficient funds.");
        }
        

        return account_balance;

    }

    private static void printTransactions() {
            
        if(flag==1){
            System.out.println("Account number:"+account_no);
            System.out.println("Account holder name:"+holder_name);
            System.out.println("Previous balance:"+(account_balance+amount));
            System.out.println("Current balance:"+account_balance);
        }
        else if(flag==0){
            System.out.println("Account number:"+account_no);
            System.out.println("Account holder name:"+holder_name);
            System.out.println("previous balance:"+(account_balance-withdraw_amount));
            System.out.println("current balance:"+account_balance);
        }
        
    }
    private static void printAccountSummary() {
        System.out.println("Account Number: " + account_no);
        System.out.println("Account Holder Name: " + holder_name);
        System.out.println("Account Balance: " + account_balance);
    }



    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Bank!");
        
        initializecustomer();
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Print transactions");
            System.out.println("4. Print account summary");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    depositemoney();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    printAccountSummary();
                    break;
                case 5:
                    System.out.print("Exit");
                    break;
                default:
                    System.out.println("Invalid option selected");
                }
            }while(option>=5);
        }

    }

     


