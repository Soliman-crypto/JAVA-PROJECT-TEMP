package semestarovka.reposetories.implementations;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import semestarovka.models.User;
import semestarovka.reposetories.Userrepo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryJdbcimplementations implements Userrepo {
    private DataSource dataSource;
    private final static String SQL_INSERT = "INSERT INTO registerUsers (full_name, user_name, email, password, gender) VALUES (?, ?, ?, ?, ?)";
//
//    private static final String DATABASE_URL = "jdbc:mysql://your_database_url";
//    private static final String USER = "your_username";
//    private static final String PASSWORD = "your_password";

    private final static String FIND_USER_BY_USERNAME = "SELECT * FROM registerUsers WHERE user_name=?";
    public UserRepositoryJdbcimplementations(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(User model) {
        System.out.println("SAVE METHOD");
        System.out.println(model.getFull_Name()+model.getUsername()+
                model.getEmail()+ model.getPassword()+
                model.getGender());
        // Add code to save the user object to the database
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, model.getFull_Name());
            statement.setString(2, model.getUsername());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getPassword());
            statement.setString(5, model.getGender());

//            User user = (User) model;
//            statement.setString(1, user.getFull_Name());
//            statement.setString(2, user.getUsername());
//            statement.setString(3, user.getEmail());
//            statement.setString(4, user.getPassword());
//            statement.setString(5, user.getConfirm_Password());
//            statement.setString(6, user.getGender());

            statement.executeUpdate();
            System.out.println("USER HAS BEEN INSERTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        // Add code to retrieve all users from the database
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM registerUsers")) {

            while (resultSet.next()) {
                User user = new User();
                user.setFull_Name(resultSet.getString("full_name"));
                user.setUsername(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findUser(String email, String password) {
        // Add code to find a user by email and password in the database
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM registerUsers WHERE email = ? AND password = ?")) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setFull_Name(resultSet.getString("full_name"));
                    user.setUsername(resultSet.getString("user_name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setGender(resultSet.getString("gender"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void userCookie(UUID uuid, int userId) {
        // Add code to handle user cookies in the database
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE registerUsers SET cookie_uuid = ? WHERE id = ?")) {

            statement.setString(1, uuid.toString());
            statement.setInt(2, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        // Add code to delete a user from the database
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM registerUsers WHERE id = ?")) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int userId, String firstName, String lastName, int age, String email, String password) {
        // Add code to update a user's information in the database
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE registerUsers SET full_name = ?, user_name = ?, email = ?, password = ? WHERE id = ?")) {

            statement.setString(1, firstName + " " + lastName);
            statement.setString(2, firstName.toLowerCase() + "_" + lastName.toLowerCase());
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int userId) {
        // Add code toHere's the continuation of the updated code:
         // Add code to find a user by ID in the database
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM registerUsers WHERE id = ?")) {

                statement.setInt(1, userId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        User user = new User();
                        user.setFull_Name(resultSet.getString("full_name"));
                        user.setUsername(resultSet.getString("user_name"));
                        user.setEmail(resultSet.getString("email"));
                        user.setPassword(resultSet.getString("password"));
                        user.setGender(resultSet.getString("gender"));
                        return user;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public User findByUsername(String username) {
        User user = null;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME + "(?)");
            preparedStatement.setString(1, username);
   //         preparedStatement.setString(2,);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = User.builder()
                        .Full_Name(resultSet.getString("full_name"))
                        .Username(resultSet.getString("user_name"))
                        .Email(resultSet.getString("email"))
                //        .Password(resultSet.getString("password"))
                        .Gender(resultSet.getString("gender"))
                        .build();
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByCookie(UUID uuid) {
        return null;
    }
}
