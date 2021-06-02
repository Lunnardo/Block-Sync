/**
 * Kelas SavingsAccount ini menangani bagian error handling untuk deposit dan withdraw dan
 * juga menampilkan balance atau saldo
 *
 */
class SavingsAccount {
    private double balance;
    /**
     * inisialisasi kelas
     */
    public SavingsAccount(double bal) {
        balance = bal;
    }

    public SavingsAccount() {
        this(0);
    }
    /**
     * method getBalance berfungsi untuk mendapatkan nilai balance atau saldo milik konsumen
     */
    public double getBalance() {
        return balance;
    }

    /**
     * method withdraw berfungsi untuk menangani error handling berupa
     * jika nilai penarikan bernilai dibawah 0 maka,
     * akan muncul pesan error yang memberitahu bahwa nilai withdraw negatif.
     * dan menampilkan nilai balance atau saldo setiap kali terjadi penarikan uang atau withdraw
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
     * method deposit berfungsi untuk menangani error handling berupa ketika  dilakukan deposit atau penyimpanan uang
     * dan ternyata nilai yang dimasukkan untuk penyimpanan uang atau deposit bernilai dibawah 0 maka,
     * akan muncul error yang memberitahu bahwa nilai deposit negatif.
     * dan menampilkan nilai balance atau saldo setiap kali terjadi penyimpanana uang atau deposit
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