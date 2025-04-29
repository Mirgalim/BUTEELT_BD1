package cli;

import java.util.*;

public class WorstFirstSorter implements CardOrganizer {
    @Override
    public List<Card> organize(List<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort((c1, c2) -> {
            int c1Total = c1.getCorrectCount() + c1.getIncorrectCount();
            int c2Total = c2.getCorrectCount() + c2.getIncorrectCount();

            double c1Accuracy = c1Total == 0 ? 1.0 : (double) c1.getCorrectCount() / c1Total;
            double c2Accuracy = c2Total == 0 ? 1.0 : (double) c2.getCorrectCount() / c2Total;

            return Double.compare(c1Accuracy, c2Accuracy);
        });
        return sorted;
    }
}

