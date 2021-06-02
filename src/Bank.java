/**Merupakan Main class dari Proyek ini
 * @author  Leonardus Kevin 1806199934
 * @author  Lunnardo Soekarno Lukias 1806198890
 * @author  Natalia Kristian 1806200103 */

public class Bank {

    /**
     * Disini thread akan dijalankan sesuai dengan variable slaveCount
     * Pemberian nilai balance, dimana pada contoh ini kita beri nilai 100*/
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(100);
        int slaveCount = 4;
        Thread[] slaves = new Thread[slaveCount];
        for(int i = 0; i < slaveCount; i++) {
            if (i % 2 == 0) {
                slaves[i] = new Producer(account);
            } else {
                slaves[i] = new Consumer(account);
            }
        }
        /**Memulai Thread*/
        for(int i = 0; i < slaveCount; i++) {
            slaves[i].start();
        }
        /**Menggabungkan semua thread yang sudah dijalankan
         * akan ada output ketika sebuah thread sudah dijanlankan*/

        for(int i = 0; i < slaveCount; i++) {
            try {
                slaves[i].join();
            } catch(InterruptedException ie) {
                System.err.println(ie.getMessage());
            } finally {
                System.out.println("slave "+ i + " has died");
            }
        }
        /**
         * Menampilkan hasil akhir dari balance, dimana
         * output yang diharapkan seharusnya sama dengan
         * nilai balance yang ditentukan sebelumnya*/

        System.out.print("Closing balance = ");
        System.out.println("$" + account.getBalance());
}
}