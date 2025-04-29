package cli;

import java.io.*;
import java.util.*;

public class CardLoader {
    public static List<Card> loadCards(String fileName) {
        List<Card> cards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("::");
                if (parts.length == 2) {
                    cards.add(new Card(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Файл уншихад алдаа гарлаа: " + e.getMessage());
        }
        return cards;
    }
}
