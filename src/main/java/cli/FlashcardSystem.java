package cli;

import java.util.List;
import java.util.Scanner;

public class FlashcardSystem {
    private final String fileName;
    private final String order;
    private final int repetitions;
    private final boolean invert;

    public FlashcardSystem(String fileName, String order, int repetitions, boolean invert) {
        this.fileName = fileName;
        this.order = order;
        this.repetitions = repetitions;
        this.invert = invert;
    }

    public void run() {
        List<Card> cards = CardLoader.loadCards(fileName);
        CardOrganizer organizer = getOrganizer();
        List<Card> orderedCards = organizer.organize(cards);

        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();

        for (Card card : orderedCards) {
            int corrects = 0;
            while (corrects < repetitions) {
                System.out.println((invert ? card.getAnswer() : card.getQuestion()));
                String input = scanner.nextLine().trim();
                if ((invert ? card.getQuestion() : card.getAnswer()).equalsIgnoreCase(input)) {
                    System.out.println("Зөв байна!");
                    card.correct();
                    corrects++;
                } else {
                    System.out.println("Буруу. Зөв хариулт нь : " + (invert ? card.getQuestion() : card.getAnswer()));
                    card.incorrect();
                }
            }
        }

        long end = System.currentTimeMillis();
        AchievementTracker.checkAchievements(cards, end - start);
    }

    private CardOrganizer getOrganizer() {
        return switch (order) {
            case "recent-mistakes-first" -> new RecentMistakesFirstSorter();
            case "worst-first" -> new WorstFirstSorter();
            default -> new RandomSorter();
        };
    }
}
