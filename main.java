package TugasLinkedList;

// Class Song (untuk node LinkedList)
class Song {
    String title;  // Judul lagu
    Song next;     // Pointer ke lagu berikutnya

    // Constructor
    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

// Class Playlist (mengelola daftar lagu)
class Playlist {
    private Song head; // Lagu pertama dalam playlist

    // Menambahkan lagu ke akhir playlist
    public void addSong(String title) {
        Song newSong = new Song(title);

        // Jika playlist masih kosong
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            // Menelusuri hingga lagu terakhir
            while (current.next != null) {
                current = current.next;
            }
            // Tambahkan di akhir
            current.next = newSong;
        }
    }
    // Menampilkan semua lagu dalam playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist masih kosong.");
            return;
        }
        System.out.println("Daftar Lagu dalam Playlist:");
        Song current = head;
        while (current != null) {
            System.out.println("- " + current.title);
            current = current.next;
        }
    }
}
// Class utama untuk menjalankan program
public class TugasLinkedList {
    public static void main(String[] args) {
        Playlist playlistKu = new Playlist();

        playlistKu.addSong("the lazy song");
        playlistKu.addSong("bergema selamanya");
        playlistKu.addSong("Someone Like You");
        playlistKu.addSong("Shape of You");
        playlistKu.displayPlaylist();
    }
}

