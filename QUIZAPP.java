import java.util.*;

public class QuizApp {

    // Inner class representing a question in the quiz
    static class Question {
        String question;
        String[] options;
        String correctAnswer;

        public Question(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        
        // Adding new questions to the quiz
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, "Jupiter"));
        questions.add(new Question("Which animal is known as the king of the jungle?", new String[]{"Elephant", "Tiger", "Lion", "Cheetah"}, "Lion"));
        questions.add(new Question("What is the square root of 64?", new String[]{"6", "7", "8", "9"}, "8"));
        questions.add(new Question("Who was the first President of the United States?", new String[]{"Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"}, "George Washington"));
        questions.add(new Question("Which gas do plants primarily use for photosynthesis?", new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}, "Carbon Dioxide"));
        
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = questions.size();
        int timeLimit = 10;  // Set a time limit of 10 seconds per question
        
        // Loop through the list of questions
        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions.get(i);
            long startTime = System.currentTimeMillis();  // Record start time for timer
            
            // Display the question
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            
            // Display options
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            // Get the user's answer within the time limit
            String userAnswer = getAnswerWithTimer(scanner, timeLimit, startTime);
            
            // Check if the answer is correct
            if (userAnswer != null && userAnswer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                score++;
            }
        }
        
        // Display the final result
        showResult(totalQuestions, score);
    }

    // Method to get the user's answer with a timer
    public static String getAnswerWithTimer(Scanner scanner, int timeLimit, long startTime) {
        System.out.println("You have " + timeLimit + " seconds to answer...");
        String userAnswer = null;

        // Keep checking if the time has not expired
        while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
            if (scanner.hasNextLine()) {
                userAnswer = scanner.nextLine();
                break;
            }
        }

        if (userAnswer == null) {
            System.out.println("\nTime's up! No answer provided.");
        }
        return userAnswer;
    }

    // Method to show the final result of the quiz
    public static void showResult(int totalQuestions, int score) {
        System.out.println("\nYour final score is: " + score + "/" + totalQuestions);
        if (score == totalQuestions) {
            System.out.println("Congratulations, you got all answers correct!");
        } else {
            System.out.println("Better luck next time!");
        }
    }
}
