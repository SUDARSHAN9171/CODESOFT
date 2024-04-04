import java.util.*;

class QuizQuestion {
    String question;
    List<String> options;
    int correctAnswerIndex;

    public QuizQuestion(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

public class TASK4 {
    private static final int QUESTION_TIME_LIMIT = 10;

    public static void main(String[] args) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of India?",
                Arrays.asList("A. Mumbai", "B. Delhi", "C. Pune", "D. Chennai"), 1));
        quizQuestions.add(new QuizQuestion("Which is the national bird of India?",
                Arrays.asList("A. Sparrow", "B. Peacock", "C. Kingfisher", "D. Penguin"), 1));
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (QuizQuestion question : quizQuestions) {
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.println("Enter your answer (A/B/C/D):");
            String userAnswer = scanner.nextLine().toUpperCase();

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel();
                    System.exit(0);
                }
            };
            timer.schedule(task, QUESTION_TIME_LIMIT * 1000);

            switch (userAnswer) {
                case "A":
                case "B":
                case "C":
                case "D":
                    int answerIndex = userAnswer.charAt(0) - 'A';
                    if (question.isCorrect(answerIndex)) {
                        System.out.println("Correct");
                        score++;
                    } else {
                        System.out.println("Incorrect");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
            }

            timer.cancel();
            System.out.println();
        }
        System.out.println("Quiz ended. Your final score is: " + score + "/" + quizQuestions.size());
        for (int i = 0; i < quizQuestions.size(); i++) {
            QuizQuestion question = quizQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.question);
            System.out.println("Correct Answer: " + question.options.get(question.correctAnswerIndex));
            if (question.isCorrect(i)) {
                System.out.println("Your Answer: Correct");
            } else {
                System.out.println("Your Answer: Incorrect");
            }
            System.out.println();
        }
    }
}
