package in.sp.notes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class NotesApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Notes App ===");
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        System.out.println("Choose mode:");
        System.out.println("1. Overwrite (purani file replace karega)");
        System.out.println("2. Append    (purani file ke end me add karega)");
        System.out.print("Enter 1 or 2: ");
        int mode = sc.nextInt();

        boolean append = (mode == 2);

        FileWriter writer = null;
        try {
            // append = true -> Append mode, false -> Overwrite mode
            writer = new FileWriter("notes.txt", append);
            writer.write(note + System.lineSeparator());
            System.out.println("✅ Note saved successfully in notes.txt!");
        } catch (IOException e) {
            // Exception log + stack trace
            System.err.println("❌ Error writing to file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Finally block ALWAYS executes, to close resource
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("FileWriter closed.");
                }
            } catch (IOException ex) {
                System.err.println("❌ Error closing the writer: " + ex.getMessage());
            }
            sc.close();
        }
    }
}
