package cli;

public class Card {
    private final String question;
    private final String answer;
    private int correctCount = 0;
    private int incorrectCount = 0;

    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public void correct() { correctCount++; }
    public void incorrect() { incorrectCount++; }
    public int getCorrectCount() { return correctCount; }
    public int getIncorrectCount() { return incorrectCount; }
}

