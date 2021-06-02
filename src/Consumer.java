/**
 * Kelas consumer ini menangani bagian untuk mengambil uang
 * pada saldo akun tabungan milik konsumen
 */
class Consumer extends Thread {
    /**
     * inisialisasi variable account untuk memanggil kelas SavingsAccount
     */
    private SavingsAccount account;
    public Consumer(SavingsAccount acct) { account = acct; }
    /**
     * method run  berfungsi untuk menjalankan loop yang akan melakukan pengambilan uang atau withdraw uang dari saldo
     * tabungan milik konsumen
     */
    public void run() {
        for(int i = 0; i < 10; i++) {
            synchronized(account) { account.withdraw(10); }
        }
    }
}