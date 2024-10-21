import java.util.LinkedList;
import java.util.Scanner;

public class BrowserHistory {
    private LinkedList<String> history; // Menggunakan LinkedList untuk menyimpan history

    public BrowserHistory() {
        history = new LinkedList<>();
    }

    // Fungsi untuk menampilkan history
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }
        System.out.println("History Browser:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }

    // Fungsi untuk menambahkan website baru
    public void browse(String website) {
        history.addFirst(website); // Menambahkan website ke bagian depan stack
        System.out.println("Menambahkan: " + website);
    }

    // Fungsi untuk kembali ke website sebelumnya
    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
            return;
        }
        String removedWebsite = history.removeFirst(); // Menghapus website terbaru dari history
        System.out.println("Kembali dari: " + removedWebsite);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Sistem History Browser");
        System.out.println("Perintah: view, browse <website>, back, exit");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("view")) {
                browserHistory.view();
            } else if (command.startsWith("browse ")) {
                String website = command.substring(7); // Mengambil nama website
                browserHistory.browse(website);
            } else if (command.equalsIgnoreCase("back")) {
                browserHistory.back();
            } else {
                System.out.println("Perintah tidak dikenali.");
            }
        }

        scanner.close();
    }
}
