package com.ims.admin.dao.Impl;

import com.ims.configure.ConnectionManager;
import com.ims.exception.ExceptionSMS;
import com.ims.admin.dao.PolicyDetailsDAO;
import com.ims.model.PolicyDetails;
import com.ims.model.UserList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.ims.query.QueryConstant.*;

public class PolicyDAOImpl implements PolicyDetailsDAO {
    Scanner sc = new Scanner(System.in);
    static List<PolicyDetails> addPolicy = new LinkedList<>();
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;


    int row = 0;


    public String addPolicy(PolicyDetails policyDetails) throws ExceptionSMS, SQLException {

        try {
            connection = ConnectionManager.getConnection();//1

            preparedStatement = connection.prepareStatement(AddPolicy);//2
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
            preparedStatement = connection.prepareStatement(displayCategoryAndSubCategory);//2
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
            preparedStatement = connection.prepareStatement(readPolicyList);//2
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
            final String deletePolicy = "DELETE FROM `PolicyList` WHERE ID=?";
            preparedStatement = connection.prepareStatement(deletePolicy);//2
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
























