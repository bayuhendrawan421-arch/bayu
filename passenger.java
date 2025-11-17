package Penumpang;

    class Passenger {
        String name;       // Nama penumpang
        Passenger next;    // Pointer ke penumpang berikutnya


        // Constructor
        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }


    // Kelas Flight berisi daftar penumpang (Linked List)
    class Flight {
        private Passenger head;  // Penumpang pertama (head) dalam daftar


        // Menambahkan penumpang di akhir daftar
        public void addPassenger(String name) {
            Passenger newPassenger = new Passenger(name);


            // Jika daftar penumpang masih kosong
            if (head == null) {
                head = newPassenger;
            } else {
                Passenger current = head;
                // Menelusuri hingga penumpang terakhir
                while (current.next != null) {
                    current = current.next;
                }
                // Tambahkan penumpang di akhir
                current.next = newPassenger;
            }
            System.out.println(name + " telah ditambahkan ke daftar penumpang.");
        }


        // Menghapus penumpang berdasarkan nama
        public void removePassenger(String name) {
            if (head == null) {
                System.out.println("Daftar penumpang kosong.");
                return;
            }


            // Jika penumpang yang dihapus adalah penumpang pertama
            if (head.name.equals(name)) {
                head = head.next;
                System.out.println(name + " telah dihapus dari daftar penumpang.");
                return;
            }
            Passenger current = head;
            Passenger prev = null;


            // Menelusuri daftar untuk mencari penumpang yang sesuai
            while (current != null && !current.name.equals(name)) {
                prev = current;
                current = current.next;
            }


            // Jika penumpang tidak ditemukan
            if (current == null) {
                System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
                return;
            }


            // Hapus penumpang dengan menghubungkan node sebelumnya ke node berikutnya
            prev.next = current.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
        }


        // Menampilkan semua penumpang
        public void displayPassengers() {
            if (head == null) {
                System.out.println("Tidak ada penumpang dalam daftar.");
                return;
            }


            System.out.println("Daftar Penumpang Penerbangan:");
            Passenger current = head;
            while (current != null) {
                System.out.println("- " + current.name);
                current = current.next;
            }
        }
    }


    // Kelas utama untuk menjalankan program
    public class Penumpang {
        public static void main(String[] args) {
            Flight flight = new Flight();


            flight.addPassenger("Alice");
            flight.addPassenger("Bob");
            flight.addPassenger("Charlie");
            flight.addPassenger("Diana");


            System.out.println();
            flight.displayPassengers();


            System.out.println("\nMenghapus penumpang 'Bob'...");
            flight.removePassenger("Bob");


            System.out.println();
            flight.displayPassengers();


            System.out.println("\nMencoba menghapus penumpang yang tidak ada:");
            flight.removePassenger("Eve");
        }
    }

