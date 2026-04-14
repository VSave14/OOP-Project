import java.io.*;
import java.util.*;

/**
 * ===== ELECTIVE RECOMMENDATION SYSTEM =====
 * A Java backend system for helping students select appropriate electives
 * Based on their interests, aptitudes, and career goals
 * College First-Year Project - No APIs or Complex Dependencies
 */

// ===== STUDENT CLASS =====
/**
 * What This Does: Represents a student with their basic information
 * and tracks their quiz answers and elective selections
 */
class Student {
    private String name;
    private String rollNumber;
    private String branch;
    private int year;
    private Map<String, String> quizAnswers;
    private List<Integer> selectedElectives;

    // Constructor
    public Student(String name, String rollNumber, String branch, int year) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.year = year;
        this.quizAnswers = new HashMap<>();
        this.selectedElectives = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getBranch() { return branch; }
    public int getYear() { return year; }
    public Map<String, String> getQuizAnswers() { return quizAnswers; }
    public List<Integer> getSelectedElectives() { return selectedElectives; }

    public void setQuizAnswers(Map<String, String> answers) {
        this.quizAnswers = answers;
    }

    public void addSelectedElective(int electiveId) {
        selectedElectives.add(electiveId);
    }

    // What This Does: Converts student data to a readable string format
    @Override
    public String toString() {
        return String.format(
            "Student: %s\nRoll: %s\nBranch: %s\nYear: %d",
            name, rollNumber, branch, year
        );
    }
}

// ===== ELECTIVE CLASS =====
/**
 * What This Does: Represents a single elective course with all its details
 * including faculty, ratings, and prerequisites
 */
class Elective {
    private int id;
    private String name;
    private String code;
    private String branch;
    private String description;
    private String faculty;
    private int semester;
    private int credits;
    private String prerequisites;
    private boolean practicalBased;
    private String difficulty;
    private String timing;
    private double rating;
    private List<String> reviews;

    // Constructor
    public Elective(int id, String name, String code, String branch, 
                   String description, String faculty, int semester, int credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.branch = branch;
        this.description = description;
        this.faculty = faculty;
        this.semester = semester;
        this.credits = credits;
        this.prerequisites = "N/A";
        this.practicalBased = false;
        this.difficulty = "Intermediate";
        this.timing = "TBD";
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }
    public String getBranch() { return branch; }
    public String getDescription() { return description; }
    public String getFaculty() { return faculty; }
    public int getSemester() { return semester; }
    public int getCredits() { return credits; }
    public String getPrerequisites() { return prerequisites; }
    public boolean isPracticalBased() { return practicalBased; }
    public String getDifficulty() { return difficulty; }
    public String getTiming() { return timing; }
    public double getRating() { return rating; }
    public List<String> getReviews() { return reviews; }

    public void setPrerequisites(String prerequisites) { this.prerequisites = prerequisites; }
    public void setPracticalBased(boolean practical) { this.practicalBased = practical; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setTiming(String timing) { this.timing = timing; }
    public void setRating(double rating) { this.rating = rating; }

    // What This Does: Add a student review for the elective
    public void addReview(String review) {
        reviews.add(review);
    }

    // What This Does: Calculate average rating from reviews
    public void updateRatingFromReviews(double newRating) {
        this.rating = newRating;
    }

    // What This Does: Print elective details in readable format
    public void printDetails() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ELECTIVE: " + name);
        System.out.println("=".repeat(50));
        System.out.println("Code: " + code);
        System.out.println("Branch: " + branch);
        System.out.println("Faculty: " + faculty);
        System.out.println("Semester: " + semester);
        System.out.println("Credits: " + credits);
        System.out.println("Description: " + description);
        System.out.println("Prerequisites: " + prerequisites);
        System.out.println("Practical-Based: " + (practicalBased ? "Yes" : "No"));
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Timing: " + timing);
        System.out.println("Rating: " + String.format("%.1f", rating) + "/5.0");
        System.out.println("=".repeat(50));
    }
}

// ===== QUIZ CLASS =====
/**
 * What This Does: Manages the quiz questions and processes student responses
 * Returns structured data about student answers
 */
class Quiz {
    private List<String> questions;
    private List<List<String>> options;
    private Map<String, String> studentAnswers;

    // Constructor
    public Quiz() {
        this.questions = new ArrayList<>();
        this.options = new ArrayList<>();
        this.studentAnswers = new HashMap<>();
        initializeQuestions();
    }

    // What This Does: Set up all 8 quiz questions with their options
    private void initializeQuestions() {
        // Question 1: Career Ambitions
        questions.add("What are your primary career ambitions?");
        options.add(Arrays.asList(
            "Software Development / Web Development",
            "Data Science / AI & Machine Learning",
            "System Design / Infrastructure",
            "Cybersecurity / Network Administration",
            "Hardware / Embedded Systems",
            "I'm Still Exploring"
        ));

        // Question 2: Technical Interests
        questions.add("Which technical area interests you most?");
        options.add(Arrays.asList(
            "Frontend / UI/UX Design",
            "Backend / Databases",
            "Mathematical / Algorithmic Thinking",
            "Systems / Low-level Programming",
            "IoT / Embedded Systems",
            "Not Sure Yet"
        ));

        // Question 3: Coding Experience
        questions.add("What is your current coding experience level?");
        options.add(Arrays.asList(
            "Beginner - Learning Basics",
            "Intermediate - Comfortable with Core Concepts",
            "Advanced - Built Projects Before"
        ));

        // Question 4: Available Time
        questions.add("How much time can you dedicate weekly?");
        options.add(Arrays.asList(
            "Limited (5-8 hours/week) - Need flexible electives",
            "Moderate (8-12 hours/week) - Balanced schedule",
            "Extensive (12+ hours/week) - Can handle demanding electives"
        ));

        // Question 5: Learning Style
        questions.add("What's your preferred learning style?");
        options.add(Arrays.asList(
            "Hands-on / Project-based",
            "Theoretical / Conceptual",
            "Balanced Mix"
        ));

        // Question 6: Practical Applications
        questions.add("Do you prefer practical or research-oriented courses?");
        options.add(Arrays.asList(
            "Practical - Real-world applications",
            "Research - Theoretical depth",
            "Both equally"
        ));

        // Question 7: Class Schedule Preference
        questions.add("Preferred class timings?");
        options.add(Arrays.asList(
            "Morning (8-11 AM)",
            "Afternoon (12-4 PM)",
            "Evening (4-7 PM)",
            "Flexible / Online"
        ));

        // Question 8: Team Projects
        questions.add("Do you prefer team projects or individual work?");
        options.add(Arrays.asList(
            "Team Projects",
            "Individual Work",
            "Either is Fine"
        ));
    }

    // What This Does: Return all quiz questions
    public List<String> getQuestions() {
        return questions;
    }

    // What This Does: Return options for a specific question (0-indexed)
    public List<String> getOptionsForQuestion(int questionIndex) {
        if (questionIndex >= 0 && questionIndex < options.size()) {
            return options.get(questionIndex);
        }
        return new ArrayList<>();
    }

    // What This Does: Store a student's answer to a question
    public void recordAnswer(String questionKey, String answer) {
        studentAnswers.put(questionKey, answer);
    }

    // What This Does: Get all recorded answers
    public Map<String, String> getAnswers() {
        return studentAnswers;
    }

    // What This Does: Print quiz in a readable format
    public void printQuiz() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ELECTIVE RECOMMENDATION QUIZ");
        System.out.println("=".repeat(60));
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions.get(i));
            List<String> qOptions = options.get(i);
            for (int j = 0; j < qOptions.size(); j++) {
                System.out.println("  " + (j + 1) + ". " + qOptions.get(j));
            }
        }
        System.out.println("=".repeat(60) + "\n");
    }
}

// ===== RECOMMENDATION ENGINE CLASS =====
/**
 * What This Does: The core algorithm that analyzes quiz answers
 * and scores each elective based on the student's profile
 */
class RecommendationEngine {
    private List<Elective> allElectives;
    private Map<Integer, Integer> electiveScores;

    // Constructor
    public RecommendationEngine(List<Elective> electives) {
        this.allElectives = electives;
        this.electiveScores = new HashMap<>();
    }

    /**
     * What This Does: Calculate recommendation scores for all electives
     * based on student answers. Each answer contributes points to relevant electives
     * Returns a ranked list of recommendations
     */
    public List<ElectiveRecommendation> generateRecommendations(Map<String, String> answers) {
        // Initialize scores
        for (Elective e : allElectives) {
            electiveScores.put(e.getId(), 0);
        }

        // Score based on Career Ambition
        String careerAmbition = answers.get("careerAmbition");
        if (careerAmbition.contains("Software Development")) {
            addScore(1, 20, "Web dev aligns with your software development goals");
            addScore(3, 10, null);
            addScore(9, 15, null);
        } else if (careerAmbition.contains("Data Science")) {
            addScore(2, 25, "Perfect match for your data science aspirations");
            addScore(6, 20, "AI/ML is crucial for data science career");
        } else if (careerAmbition.contains("System Design")) {
            addScore(3, 20, null);
            addScore(5, 18, null);
            addScore(9, 15, null);
        } else if (careerAmbition.contains("Cybersecurity")) {
            addScore(4, 25, "Directly relevant to cybersecurity career");
            addScore(3, 10, null);
        } else if (careerAmbition.contains("Hardware")) {
            addScore(8, 25, "Perfect for embedded systems and hardware work");
        }

        // Score based on Technical Interest
        String techInterest = answers.get("techInterest");
        if (techInterest.contains("Frontend")) {
            addScore(1, 15, "Web dev covers frontend technologies well");
            addScore(7, 15, null);
        } else if (techInterest.contains("Backend")) {
            addScore(3, 15, "Database systems essential for backend development");
            addScore(5, 15, null);
        } else if (techInterest.contains("Mathematical")) {
            addScore(10, 20, "Algorithms course uses heavy mathematical concepts");
            addScore(6, 15, null);
        } else if (techInterest.contains("Systems")) {
            addScore(3, 10, null);
            addScore(8, 20, null);
        } else if (techInterest.contains("IoT")) {
            addScore(8, 25, null);
            addScore(5, 10, null);
        }

        // Score based on Coding Experience
        String codingExp = answers.get("codingExperience");
        if (codingExp.contains("Beginner")) {
            addScore(1, 10, "Web dev is beginner-friendly");
            addScore(5, 8, null);
        } else if (codingExp.contains("Intermediate")) {
            addScore(3, 10, null);
            addScore(2, 10, null);
        } else if (codingExp.contains("Advanced")) {
            addScore(6, 15, null);
            addScore(10, 15, null);
        }

        // Score based on Available Time
        String availTime = answers.get("availableTime");
        if (availTime.contains("Limited")) {
            addScore(9, 15, "Less practical work, suitable for limited time");
        } else if (availTime.contains("Extensive")) {
            addScore(6, 15, null);
            addScore(8, 10, null);
        }

        // Score based on Learning Style
        String learningStyle = answers.get("learningStyle");
        if (learningStyle.equals("Hands-on / Project-based")) {
            addScore(1, 15, null);
            addScore(7, 15, null);
            addScore(8, 15, null);
        } else if (learningStyle.equals("Theoretical / Conceptual")) {
            addScore(9, 15, null);
            addScore(10, 15, null);
        }

        // Score based on Orientation
        String orientation = answers.get("orientation");
        if (orientation.contains("Practical")) {
            addScore(1, 10, null);
            addScore(5, 12, null);
            addScore(7, 10, null);
        } else if (orientation.contains("Research")) {
            addScore(6, 15, null);
            addScore(10, 12, null);
        }

        // Create recommendations list
        List<ElectiveRecommendation> recommendations = new ArrayList<>();
        for (Elective e : allElectives) {
            int score = electiveScores.get(e.getId());
            recommendations.add(new ElectiveRecommendation(e, score));
        }

        // Sort by score descending
        recommendations.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        return recommendations;
    }

    /**
     * What This Does: Helper method to add score to an elective
     */
    private void addScore(int electiveId, int points, String reason) {
        electiveScores.put(electiveId, electiveScores.get(electiveId) + points);
    }

    /**
     * What This Does: Print recommendations in a readable format with tiers
     */
    public void printRecommendations(List<ElectiveRecommendation> recommendations) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PERSONALIZED ELECTIVE RECOMMENDATIONS");
        System.out.println("=".repeat(60));

        System.out.println("\n🎯 TIER 1: HIGHLY RECOMMENDED");
        for (int i = 0; i < Math.min(3, recommendations.size()); i++) {
            ElectiveRecommendation rec = recommendations.get(i);
            System.out.println("  " + (i + 1) + ". " + rec.getElective().getName() + 
                             " (Score: " + rec.getScore() + "/100)");
        }

        System.out.println("\n⭐ TIER 2: ALSO GOOD OPTIONS");
        for (int i = 3; i < Math.min(6, recommendations.size()); i++) {
            ElectiveRecommendation rec = recommendations.get(i);
            System.out.println("  " + (i - 2) + ". " + rec.getElective().getName() + 
                             " (Score: " + rec.getScore() + "/100)");
        }

        System.out.println("\n💡 TIER 3: CONSIDER THESE");
        for (int i = 6; i < recommendations.size(); i++) {
            ElectiveRecommendation rec = recommendations.get(i);
            System.out.println("  " + (i - 5) + ". " + rec.getElective().getName() + 
                             " (Score: " + rec.getScore() + "/100)");
        }
        System.out.println("=".repeat(60));
    }
}

// ===== ELECTIVE RECOMMENDATION CLASS =====
/**
 * What This Does: Wraps an elective with its recommendation score
 */
class ElectiveRecommendation {
    private Elective elective;
    private int score;

    public ElectiveRecommendation(Elective elective, int score) {
        this.elective = elective;
        this.score = score;
    }

    public Elective getElective() { return elective; }
    public int getScore() { return score; }
}

// ===== MAIN CLASS - ELECTIVE SYSTEM =====
/**
 * What This Does: Main system that ties everything together
 * Initializes data, manages the flow, and provides a console interface
 */
public class ElectiveRecommendationSystem {
    private List<Elective> allElectives;
    private Quiz quiz;
    private RecommendationEngine engine;
    private Scanner scanner;
    private Student currentStudent;

    // Constructor
    public ElectiveRecommendationSystem() {
        this.scanner = new Scanner(System.in);
        this.allElectives = new ArrayList<>();
        this.quiz = new Quiz();
        initializeElectives();
        this.engine = new RecommendationEngine(allElectives);
    }

    /**
     * What This Does: Create and populate the electives database
     * This simulates loading from a database
     */
    private void initializeElectives() {
        // Elective 1: Web Development
        Elective e1 = new Elective(1, "Web Development Fundamentals", "CS401", "CS",
            "Learn HTML, CSS, JavaScript and build responsive web applications.",
            "Dr. Rajesh Sharma", 4, 3);
        e1.setPrerequisites("Basic Programming");
        e1.setPracticalBased(true);
        e1.setDifficulty("Intermediate");
        e1.setTiming("Morning");
        e1.setRating(4.5);
        allElectives.add(e1);

        // Elective 2: Data Science with Python
        Elective e2 = new Elective(2, "Data Science with Python", "CS402", "CS",
            "Master data analysis, visualization, and machine learning basics with Python.",
            "Prof. Neha Gupta", 4, 3);
        e2.setPrerequisites("Mathematics, Python Basics");
        e2.setPracticalBased(true);
        e2.setDifficulty("Advanced");
        e2.setTiming("Afternoon");
        e2.setRating(4.7);
        allElectives.add(e2);

        // Elective 3: Database Systems & SQL
        Elective e3 = new Elective(3, "Database Systems & SQL", "CS403", "CS",
            "Design and manage databases, write complex SQL queries, normalize schemas.",
            "Dr. Vikram Desai", 4, 3);
        e3.setPrerequisites("Data Structures");
        e3.setPracticalBased(true);
        e3.setDifficulty("Intermediate");
        e3.setTiming("Evening");
        e3.setRating(4.3);
        allElectives.add(e3);

        // Elective 4: Cybersecurity Essentials
        Elective e4 = new Elective(4, "Cybersecurity Essentials", "IT404", "IT",
            "Understand security principles, encryption, network security, and ethical hacking.",
            "Mr. Sanjay Chopra", 4, 3);
        e4.setPrerequisites("Networking Basics");
        e4.setPracticalBased(true);
        e4.setDifficulty("Advanced");
        e4.setTiming("Morning");
        e4.setRating(4.6);
        allElectives.add(e4);

        // Elective 5: Cloud Computing with AWS
        Elective e5 = new Elective(5, "Cloud Computing with AWS", "IT405", "IT",
            "Deploy and manage applications on AWS. Learn EC2, S3, Lambda, and more.",
            "Dr. Arjun Patel", 4, 3);
        e5.setPrerequisites("Basic Systems Knowledge");
        e5.setPracticalBased(true);
        e5.setDifficulty("Intermediate");
        e5.setTiming("Afternoon");
        e5.setRating(4.4);
        allElectives.add(e5);

        // Elective 6: AI & Machine Learning
        Elective e6 = new Elective(6, "Artificial Intelligence & Machine Learning", "CS406", "CS",
            "Deep dive into AI concepts, neural networks, supervised and unsupervised learning.",
            "Dr. Priya Sharma", 4, 4);
        e6.setPrerequisites("Mathematics, Python, Data Science Basics");
        e6.setPracticalBased(true);
        e6.setDifficulty("Advanced");
        e6.setTiming("Morning");
        e6.setRating(4.8);
        allElectives.add(e6);

        // Elective 7: Mobile App Development
        Elective e7 = new Elective(7, "Mobile App Development", "IT406", "IT",
            "Build iOS and Android applications using modern frameworks and best practices.",
            "Ms. Divya Kapoor", 4, 3);
        e7.setPrerequisites("Object-Oriented Programming");
        e7.setPracticalBased(true);
        e7.setDifficulty("Intermediate");
        e7.setTiming("Afternoon");
        e7.setRating(4.5);
        allElectives.add(e7);

        // Elective 8: Embedded Systems Programming
        Elective e8 = new Elective(8, "Embedded Systems Programming", "EC407", "EC",
            "Program microcontrollers, IoT devices, and understand hardware interfacing.",
            "Dr. Arun Verma", 4, 3);
        e8.setPrerequisites("C Programming, Digital Logic");
        e8.setPracticalBased(true);
        e8.setDifficulty("Advanced");
        e8.setTiming("Evening");
        e8.setRating(4.4);
        allElectives.add(e8);

        // Elective 9: Software Engineering & Project Management
        Elective e9 = new Elective(9, "Software Engineering & Project Management", "CS408", "CS",
            "Learn SDLC, Agile methodologies, design patterns, and project management.",
            "Prof. Ashok Kumar", 4, 3);
        e9.setPrerequisites("Programming Fundamentals");
        e9.setPracticalBased(false);
        e9.setDifficulty("Intermediate");
        e9.setTiming("Morning");
        e9.setRating(4.2);
        allElectives.add(e9);

        // Elective 10: Advanced Algorithms & Competitive Programming
        Elective e10 = new Elective(10, "Advanced Algorithms & Competitive Programming", "CS409", "CS",
            "Master algorithmic problem-solving, competitive coding, and optimization.",
            "Dr. Suresh Patil", 4, 3);
        e10.setPrerequisites("Data Structures, Mathematics");
        e10.setPracticalBased(true);
        e10.setDifficulty("Advanced");
        e10.setTiming("Evening");
        e10.setRating(4.6);
        allElectives.add(e10);
    }

    /**
     * What This Does: Display the main menu and get user choice
     */
    public void showMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("MUKESH PATEL SCHOOL OF TECHNOLOGY AND MANAGEMENT");
        System.out.println("Elective Recommendation System");
        System.out.println("=".repeat(60));
        System.out.println("1. Start Recommendation Process");
        System.out.println("2. View All Electives");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }

    /**
     * What This Does: Get student login information
     */
    public void loginStudent() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("STUDENT LOGIN");
        System.out.println("-".repeat(60));
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your roll number: ");
        String rollNumber = scanner.nextLine();
        
        System.out.print("Enter your branch (CS/IT/EC): ");
        String branch = scanner.nextLine();
        
        System.out.print("Enter your year (1-4): ");
        int year = Integer.parseInt(scanner.nextLine());
        
        currentStudent = new Student(name, rollNumber, branch, year);
        System.out.println("\n✓ Login successful!");
        System.out.println(currentStudent);
    }

    /**
     * What This Does: Conduct the quiz by asking all questions
     * and recording student answers
     */
    public void conductQuiz() {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("ELECTIVE SELECTION QUIZ");
        System.out.println("-".repeat(60));
        System.out.println("Answer the following questions to get personalized recommendations.\n");

        Map<String, String> answers = new HashMap<>();
        String[] answerKeys = {
            "careerAmbition",
            "techInterest",
            "codingExperience",
            "availableTime",
            "learningStyle",
            "orientation",
            "classTime",
            "teamPreference"
        };

        List<String> questions = quiz.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions.get(i));
            List<String> options = quiz.getOptionsForQuestion(i);
            
            for (int j = 0; j < options.size(); j++) {
                System.out.println("  " + (j + 1) + ". " + options.get(j));
            }

            System.out.print("Select option (1-" + options.size() + "): ");
            int choice = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (choice >= 0 && choice < options.size()) {
                answers.put(answerKeys[i], options.get(choice));
            }
        }

        currentStudent.setQuizAnswers(answers);
        System.out.println("\n✓ Quiz completed!");
    }

    /**
     * What This Does: Display recommended electives based on quiz
     */
    public void displayRecommendations() {
        if (currentStudent == null || currentStudent.getQuizAnswers().isEmpty()) {
            System.out.println("\nPlease complete the quiz first!");
            return;
        }

        List<ElectiveRecommendation> recommendations = 
            engine.generateRecommendations(currentStudent.getQuizAnswers());
        
        engine.printRecommendations(recommendations);

        System.out.print("\nWould you like to view details of any elective? (y/n): ");
        String response = scanner.nextLine().toLowerCase();
        
        if (response.equals("y")) {
            System.out.print("Enter the rank number (1-10): ");
            int rank = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (rank >= 0 && rank < recommendations.size()) {
                recommendations.get(rank).getElective().printDetails();
            }
        }
    }

    /**
     * What This Does: Display all available electives
     */
    public void displayAllElectives() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL AVAILABLE ELECTIVES");
        System.out.println("=".repeat(60));

        for (Elective e : allElectives) {
            System.out.println("\n" + e.getCode() + " - " + e.getName());
            System.out.println("  Faculty: " + e.getFaculty());
            System.out.println("  Branch: " + e.getBranch());
            System.out.println("  Rating: " + String.format("%.1f", e.getRating()) + "/5.0");
            System.out.println("  Difficulty: " + e.getDifficulty());
        }
        System.out.println("=".repeat(60));
    }

    /**
     * What This Does: Run the main program loop
     */
    public void run() {
        boolean running = true;

        while (running) {
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    loginStudent();
                    conductQuiz();
                    displayRecommendations();
                    break;
                case "2":
                    displayAllElectives();
                    break;
                case "3":
                    System.out.println("\nThank you for using the Elective Recommendation System!");
                    System.out.println("For any queries, contact: admissions@mpstm.edu.in");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * What This Does: Program entry point
     */
    public static void main(String[] args) {
        System.out.println("Starting Elective Recommendation System...\n");
        ElectiveRecommendationSystem system = new ElectiveRecommendationSystem();
        system.run();
    }
}
