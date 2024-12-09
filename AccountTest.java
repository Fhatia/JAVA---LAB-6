public class AccountTest {
    public static void main(String[] args) {
        //set the starting balance to $1500
        Account account = new Account(1500);

        //makes a thread for each deposit or withdraw
        Thread t1 = new Thread(new Transaction(account, true, 200));
        Thread t2 = new Thread(new Transaction(account, false, 150));
        Thread t3 = new Thread(new Transaction(account, true, 300));
        Thread t4 = new Thread(new Transaction(account, false, 700));

        //starts all the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //ensures that the final balance is correct
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR Thread could not be made.");
        }

        //final account balanve after all threads have been run
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
