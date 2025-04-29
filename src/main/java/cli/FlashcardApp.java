package cli;

public class  FlashcardApp {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("--help")) {
            printHelp();
            return;
        }

        String fileName = args[0];
        String order = "random";
        int repetitions = 1;
        boolean invert = false;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--help":
                    printHelp();
                    return;
                case "--order":
                    if (i + 1 < args.length) order = args[++i];
                    else {
                        System.out.println("Missing argument for --order");
                        return;
                    }
                    break;
                case "--repetitions":
                    if (i + 1 < args.length) repetitions = Integer.parseInt(args[++i]);
                    else {
                        System.out.println("Missing argument for --repetitions");
                        return;
                    }
                    break;
                case "--invertCards":
                    invert = true;
                    break;
                default:
                    System.out.println("Unknown option: " + args[i]);
                    return;
            }
        }
        new FlashcardSystem(fileName, order, repetitions, invert).run();
    }

    private static void printHelp() {
        System.out.println("Usage: flashcard <cards-file> [options]");
        System.out.println("--help\t\tShow help");
        System.out.println("--order <order>\tOrder type [random, worst-first, recent-mistakes-first]");
        System.out.println("--repetitions <num>\tNumber of correct repetitions required");
        System.out.println("--invertCards\tSwap question and answer");
    }
}

