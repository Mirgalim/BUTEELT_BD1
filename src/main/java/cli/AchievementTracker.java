package cli;

import java.util.List;

public class AchievementTracker {
    public static void checkAchievements(List<Card> cards, long durationMillis) {
        boolean allCorrect = cards.stream().allMatch(c -> c.getIncorrectCount() == 0);
        boolean repeatAchieved = cards.stream().anyMatch(c -> c.getCorrectCount() + c.getIncorrectCount() > 5);
        boolean confident = cards.stream().anyMatch(c -> c.getCorrectCount() >= 3);
        double avgTime = durationMillis / 1000.0 / cards.size();

        if (allCorrect) System.out.println("Achievement: CORRECT");
        if (repeatAchieved) System.out.println("Achievement: REPEAT");
        if (confident) System.out.println("Achievement: CONFIDENT");
        if (avgTime < 5) System.out.println("Speed bonus: FAST LEARNER");
    }
}
