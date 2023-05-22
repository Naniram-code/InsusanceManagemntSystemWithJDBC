import java.sql.*;

public class CURD_DataTable {
    public static void main(String[] args) {
        // Database connection parameters
        final String url = "jdbc:mysql://localhost:3306/InsuranceMangementSystem";
        final String username = "root";
        final String password = "Bex987174";
        Connection connection = null;//(I)

        try {// 1: Establish the connection//DriverManager(C)
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database Successfully");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();// Statement(I)
            //Create Table
            statement.execute("CREATE TABLE IF NOT EXISTS Users (" +
                    "iD INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," +
                    "address VARCHAR(100)," +
                    "phone BIGINT NOT NULL," +
                    "login VARCHAR(100)," +
                    "password VARCHAR(50)" +
                    ")");
            System.out.println("Table created successfully.");

            // Step 3: Perform CRUD operations

            // Create operation
            String createQuery = "INSERT INTO Users (name,address,phone,login,password) VALUES ('John Doe','NYC',1234567890,'abcd@1234','xyzvv')";
            statement.executeUpdate(createQuery);
            System.out.println("Record created!");

            // Read operation
            String readQuery = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(readQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("iD");
                String name = resultSet.getString("name");
                String adds = resultSet.getString("address");
                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + adds);
            }

            // Update operation
            String updateQuery = "UPDATE Users SET address = 'DC' WHERE id = 1";
            statement.executeUpdate(updateQuery);
            System.out.println("Record updated!");

            // Delete operation
            String deleteQuery = "DELETE FROM Users WHERE id = 1";
            statement.executeUpdate(deleteQuery);
            System.out.println("Record deleted!");
            statement.close();
            connection.close();



         } catch (SQLException e) {
        e.printStackTrace();
        }}}