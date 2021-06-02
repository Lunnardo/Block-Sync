/**
 * Kelas producer ini menangani bagian untuk mengirimkan uang
 * pada saldo akun tabungan milik konsumen
 */
class Producer extends Thread {
    /**
     * inisialisasi variable account untuk memanggil kelas SavingsAccount
     */
    private SavingsAccount account;
    public Producer(SavingsAccount acct) { account = acct; }
    /**
     * method run  berfungsi untuk menjalankan loop yang akan melakukan pengiriman uang atau deposit uang ke saldo
     * tabungan milik konsumen
     */
    public void run() {
        for(int i = 0; i < 10; i++) {
            synchronized(account) { account.deposit(10); }
        }
    }
}