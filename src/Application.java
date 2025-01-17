import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SurveyRepository surveyRepository = new SurveyRepository();
        EmailService emailService = new EmailService();

        System.out.print("Enter survey question: ");
        String question = scanner.nextLine();
        Survey survey = new Survey(0, question);
        try {
            surveyRepository.saveSurvey(survey);
            System.out.println("Survey created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        emailService.sendPromotionalEmail("user@example.com", "Promotion", "Thank you for participating in our survey!");

        scanner.close();
    }
}