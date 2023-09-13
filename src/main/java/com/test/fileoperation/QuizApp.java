package com.test.fileoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Question {
    private String questionText;
    private List<String> options;
    private List<Integer> correctAnswers;
    private String category;
    private int complexity;
    private int weightage;

    public Question(String questionText, List<String> options, List<Integer> correctAnswers, String category, int complexity, int weightage) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.category = category;
        this.complexity = complexity;
        this.weightage = weightage;
    }

    // Getters for question attributes
    // ...

    public boolean isCorrect(List<Integer> userAnswers) {
        return userAnswers.containsAll(correctAnswers) && correctAnswers.containsAll(userAnswers);
    }

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<Integer> getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(List<Integer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public int getWeightage() {
		return weightage;
	}

	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getCategory().equalsIgnoreCase(category)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public List<Question> getRandomQuestionsByCategory(String category, int numQuestions) {
        List<Question> categoryQuestions = getQuestionsByCategory(category);
        List<Question> selectedQuestions = new ArrayList<>();
        Random random = new Random();

        if (categoryQuestions.size() <= numQuestions) {
            return categoryQuestions; // Return all questions if there are fewer questions than required.
        }

        while (selectedQuestions.size() < numQuestions) {
            int randomIndex = random.nextInt(categoryQuestions.size());
            Question selectedQuestion = categoryQuestions.get(randomIndex);

            if (!selectedQuestions.contains(selectedQuestion)) {
                selectedQuestions.add(selectedQuestion);
            }
        }

        return selectedQuestions;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        // Create some sample questions
        Question question1 = new Question(
            "Which one is cheapest aws bucket ?",
            List.of("S3 Standerd", "S3 Glacier", "S3 Glacier deep", "S3 IF"),
            List.of(3),
            "AWS",
            1,
            10
        );
        
        Question question3 = new Question(
                "AWS stands for ?",
                List.of("Amazon web services", "Amazon web security", "Amazon web sync", "NA"),
                List.of(1),
                "AWS",
                1,
                10
            );
        
        
        Question question4 = new Question(
                "AWS stands for question3?",
                List.of("Amazon web services", "Amazon web security", "Amazon web sync", "NA"),
                List.of(1),
                "AWS",
                1,
                10
            );
        
        Question question5 = new Question(
                "AWS stands for question5?",
                List.of("Amazon web services", "Amazon web security", "Amazon web sync", "NA"),
                List.of(1),
                "AWS",
                1,
                10
            );
        Question question6 = new Question(
                "AWS stands for question6?",
                List.of("Amazon web services", "Amazon web security", "Amazon web sync", "NA"),
                List.of(1),
                "AWS",
                1,
                10
            );

        Question question7 = new Question(
                "AWS stands for question7?",
                List.of("Amazon web services", "Amazon web security", "Amazon web sync", "NA"),
                List.of(1),
                "AWS",
                1,
                10
            );

        Question question2 = new Question(
            "Which programming languages are used for web development?",
            List.of("Java", "Python", "HTML", "CSS", "JavaScript"),
            List.of(2, 3, 4),
            "Programming",
            2,
            20
        );

        // Create a quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question3);
        quiz.addQuestion(question2);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);
        quiz.addQuestion(question7);
        // Sample user taking a quiz (Data Science category, 2 questions)
        List<Question> quizQuestions = quiz.getRandomQuestionsByCategory("Programming", 5);
        int totalWeightage = 0;
        int totalScore = 0;

        for (Question question : quizQuestions) {
            System.out.println("Question: " + question.getQuestionText());
            System.out.println("Options: " + question.getOptions());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer(s) (comma-separated): ");
            String answerInput = scanner.nextLine();
            String[] answerTokens = answerInput.split(",");

            List<Integer> userAnswers = new ArrayList<>();
            for (String token : answerTokens) {
                userAnswers.add(Integer.parseInt(token));
            }
            totalWeightage += question.getWeightage();
            if (question.isCorrect(userAnswers)) {
                int questionWeightage = question.getWeightage();
                totalScore += questionWeightage;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
        }

        double percentageScore = ((double) totalScore / totalWeightage) * 100;
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + percentageScore + "%");
    }
}
