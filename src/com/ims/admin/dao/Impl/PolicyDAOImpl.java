package com.pms.admin.dao.Impl;

import com.pms.admin.dao.Impl.jdbcUtility.ConnectionManager;
import com.pms.admin.dao.Impl.jdbcUtility.ExceptionSMS;
import com.pms.admin.dao.PolicyDetailsDAO;
import com.pms.model.PolicyDetails;
import com.pms.model.UserList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PolicyDAOImpl implements PolicyDetailsDAO {
    Scanner sc = new Scanner(System.in);
    static List<PolicyDetails> addPolicy = new LinkedList<>();
    //static List<PolicyDetails> addCategory = new LinkedList<>();
    //static List<PolicyDetails> addSubCategory = new LinkedList<>();
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;

    static List<UserList> studentList = new LinkedList<>();
    int row = 0;


    public String addPolicy(PolicyDetails policyDetails) throws ExceptionSMS, SQLException {

        try {
            connection = ConnectionManager.getConnection();//1
            final String sql = "INSERT INTO PolicyList (Category,SubCategory,Name,`Sum Assured`,Premium,Description)" +
                    " VALUES (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);//2
            preparedStatement.setString(1, policyDetails.getCategory());
            preparedStatement.setString(2, policyDetails.getSubCategor());
            preparedStatement.setString(3, policyDetails.getpName());
            preparedStatement.setInt(4, policyDetails.getSumAssured());
            preparedStatement.setInt(5, policyDetails.getPremium());
            preparedStatement.setString(6, policyDetails.getDescription());
            row = preparedStatement.executeUpdate();//3
            if (row > 0) {
                throw new ExceptionSMS("PolicyList Added Successfully");
            } else {
                throw new ExceptionSMS("PolicyList Failed to Add");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }

        return null;
    }

    public void displayCategoryandSubCategory() throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            final String readQuery = "SELECT Category.cname AS CategoryName, " +
                    "SubCategory.sbname AS SubCategoryName FROM Category \n" +
                    "INNER JOIN SubCategory ON Category.cid = SubCategory.sbid;";
            preparedStatement = connection.prepareStatement(readQuery);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                String categoryName = resultSet.getString("CategoryName");
                String subCategoryName = resultSet.getString("SubCategoryName");
                System.out.println("CategoryName:" + categoryName + "  SubCategoryName: " + subCategoryName);
                row++;
            }

            if (row > 0) {
                throw new ExceptionSMS(" Check Category and SubCategoy");
            } else {
                throw new ExceptionSMS(" Add Category and SubCategoy First");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }
    }


    @Override
    public List<PolicyDetails> viewPolicy() throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1

            final String readQuery = "SELECT * FROM PolicyList";
            preparedStatement = connection.prepareStatement(readQuery);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println(
                        "pid:" + resultSet.getInt(1) + "  Category:" +
                                resultSet.getString(2) + "  SubCategory:" +
                                resultSet.getString(3) + "  Name:" +
                                resultSet.getString(4) + "  Sum Assured:" +
                                resultSet.getInt(5) + "  Premium:" +
                                resultSet.getInt(6) + "  Description: " +
                                resultSet.getString(7));
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("View All PolicyList Successfully");
            } else {
                throw new ExceptionSMS("PolicyList  not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return null;
    }

    @Override
    public int updatePolicy(int pid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            final String updateName = "UPDATE PolicyList SET `Name` = ? WHERE ID =?";
            final String updateSumAssured = "UPDATE PolicyList SET `Sum Assured` = ? WHERE ID =?";
            final String updatePremium = "UPDATE PolicyList SET `Premium` = ? WHERE ID =?";
            final String updateDescription = "UPDATE PolicyList SET  `Description`  = ? WHERE ID =?";
            System.out.println("Enter 1)Name 2)Sum Assured 3)Primium 4)Description for  for update=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    preparedStatement = connection.prepareStatement(updateName);//2
                    System.out.println("Enter Policy name for update=");
                    String cna = sc.next();
                    preparedStatement.setString(1, cna);
                    preparedStatement.setInt(2, pid);
                    break;
                case 2:
                    preparedStatement = connection.prepareStatement(updateSumAssured);//2
                    System.out.println("Enter Sum Assured for update=");
                    int sA = sc.nextInt();
                    preparedStatement.setInt(1, sA);
                    preparedStatement.setInt(2, pid);
                    break;
                case 3:
                    preparedStatement = connection.prepareStatement(updatePremium);//2
                    System.out.println("Enter Premium for update=");
                    int pr = sc.nextInt();
                    preparedStatement.setInt(1, pr);
                    preparedStatement.setInt(2, pid);
                    break;
                case 4:
                    preparedStatement = connection.prepareStatement(updateDescription);//2
                    System.out.println("Enter Description for update=");
                    String des = sc.next();
                    preparedStatement.setString(1, des);
                    preparedStatement.setInt(2, pid);
                    break;
                default:
                    System.out.println("Enter 1 to 4 ");
            }

            row = preparedStatement.executeUpdate();//row update count//3
            if (row > 0) {
                throw new ExceptionSMS("Policy info update Successfully");
            } else {
                throw new ExceptionSMS("Policy info Failed to update");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return row;
    }

    @Override
    public int deletePolicy(int pid) throws SQLException

    {
        try {
            connection = ConnectionManager.getConnection();//1
            final String deleteQuery = "DELETE FROM `PolicyList` WHERE ID=?";
            preparedStatement = connection.prepareStatement(deleteQuery);//2
            preparedStatement.setInt(1, pid);
            row = preparedStatement.executeUpdate();//3
            if (row > 0) {
                throw new ExceptionSMS("Student Delete Successfully");
            } else {
                throw new ExceptionSMS("Student not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return 0;
    }

}
























