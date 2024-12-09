class Account {
    private double balance;

    //constructor enables the starting balance
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    //method to add money to the account
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", New Balance: " + balance);
    }

    //method to withdraw money
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    //returns the balance
    public double getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    //variables
    private Account account;
    private boolean isDeposit;
    private double amount;

    //constructor enables the variables
    public Transaction(Account account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    //runs the method calls whichever instance
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}