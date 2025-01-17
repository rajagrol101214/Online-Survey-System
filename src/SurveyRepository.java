import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurveyRepository {
    public void saveSurvey(Survey survey) throws SQLException {
        String query = "INSERT INTO surveys (question) VALUES (?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, survey.getQuestion());
            statement.executeUpdate();
        }
    }

    public List<Survey> getAllSurveys() throws SQLException {
        List<Survey> surveys = new ArrayList<>();
        String query = "SELECT * FROM surveys";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                surveys.add(new Survey(resultSet.getInt("id"), resultSet.getString("question")));
            }
        }
        return surveys;
    }
}