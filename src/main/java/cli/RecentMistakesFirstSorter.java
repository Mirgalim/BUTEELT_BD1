package cli;

import java.util.*;

public class RecentMistakesFirstSorter implements CardOrganizer {
    @Override
    public List<Card> organize(List<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort((c1, c2) -> Integer.compare(c2.getIncorrectCount(), c1.getIncorrectCount()));
        return sorted;
    }
}

