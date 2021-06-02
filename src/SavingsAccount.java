class SavingsAccount {
    private double balance;

    public SavingsAccount(double bal) {
        balance = bal;
    }

    public SavingsAccount() {
        this(0);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(float anAmount) {
        if (anAmount < 0.0)
            throw new IllegalArgumentException("Withdraw amount negative");
        if (anAmount <= balance) {
            synchronized (this) {
                balance = balance - anAmount;
            }
        }
        System.out.println("after withdrawal balance = $" + balance);
    }

    public void deposit(float anAmount) {

        if (anAmount < 0.0)
            throw new IllegalArgumentException("Deposit amount negative");
        synchronized (this) {
            balance = balance + anAmount;
        }

        System.out.println("after deposit balance = $" + balance);
    }
}