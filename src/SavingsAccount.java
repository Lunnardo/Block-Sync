/** Kelas SavingsAccount mengatur logika menyimpan dan pengeluaran uang
 * saldo yang diambil adalah saldo kostumer
 * termasuk dengan error handling terhadap input yang tidak valid
 */

class SavingsAccount {

    /** deklarasi variable pada kelas SavingsAccount
     */
    private double balance;

    public SavingsAccount(double bal) {
        balance = bal;
    }

    public SavingsAccount() {
        this(0);
    }

    /** konstruktor untuk mendapatkan data balance
     */

    public double getBalance() {
        return balance;
    }

    /** Melakukan fungsi withdraw atau pengambilan uang dari balance kustomer
     * exception berlaku untuk input yang tidak valid yaitu jumlah negatif
     */
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

    /**
     * Fungsi deposit berfungsi untuk melakukan penyimpanan uang ke balance kustomer
     * exception berlaku untuk input yang tidak valid yaitu jumlah negatif
     */
    public void deposit(float anAmount) {

        if (anAmount < 0.0)
            throw new IllegalArgumentException("Deposit amount negative");
        synchronized (this) {
            balance = balance + anAmount;
        }

        System.out.println("after deposit balance = $" + balance);
    }
}