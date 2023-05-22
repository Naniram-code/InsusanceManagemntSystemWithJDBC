package com.pms.admin.dao.Impl;

import com.pms.admin.dao.CategoryDetailsDAO;
import com.pms.admin.dao.Impl.jdbcUtility.ConnectionManager;
import com.pms.admin.dao.Impl.jdbcUtility.ExceptionSMS;
import com.pms.model.CategoryDetail;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CategoryDAOImpl implements CategoryDetailsDAO {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static Scanner sc = new Scanner(System.in);
    int row = 0;
    static List<CategoryDetail> categoryDetailList = new LinkedList<>();

    @Override

    public String addCategory(CategoryDetail categoryDetail) throws SQLException {

        try {
            connection = ConnectionManager.getConnection();//1
            final String sql = "INSERT INTO Category (`cname`,`Description`) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);//2
            preparedStatement.setString(1, categoryDetail.getcname());
            preparedStatement.setString(2, categoryDetail.getDescription());

            row = preparedStatement.executeUpdate();//3

            if (row > 0) {
                throw new ExceptionSMS("Category Added Successfully");
            } else {
                throw new ExceptionSMS("Category Failed to Add");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return null;
    }

    @Override
    public List<CategoryDetail> viewCategory() throws SQLException {

        try {
            connection = ConnectionManager.getConnection();//1

            final String readQuery = "SELECT * FROM Category";
            preparedStatement = connection.prepareStatement(readQuery);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println("cid:"+resultSet.getInt(1)+
                "  Category:"+resultSet.getString(2)+
                "  Descriptions:"+resultSet.getString(3));
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("View All Student Successfully");
            } else {
                throw new ExceptionSMS("Student  are not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return categoryDetailList;
    }


    @Override
    public int updateCategory(int ccid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            final String updateQuerysname = "UPDATE Category SET `cname` = ? WHERE cid =?";
            final String updateQuerysaddress = "UPDATE Category SET  `Description`  = ? WHERE cid =?";
            System.out.println("Enter 1 for  for update cname 2 for Description=");
            int ch = sc.nextInt();
            if (ch == 1) {
                preparedStatement = connection.prepareStatement(updateQuerysname);//2
                System.out.println("Enter New Category name for update=");
                String cna = sc.next();
                preparedStatement.setString(1, cna);
                preparedStatement.setInt(2, ccid);
            } else {
                preparedStatement = connection.prepareStatement(updateQuerysaddress);//2
                System.out.println("Enter New Student Address for update=");
                String des = sc.next();
                preparedStatement.setString(1, des);
                preparedStatement.setInt(2, ccid);
            }

            row = preparedStatement.executeUpdate();//row update count//3
            if (row > 0) {
                throw new ExceptionSMS("Category info update Successfully");
            } else {
                throw new ExceptionSMS("Category info Failed to update");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }

        return row;
    }


    @Override

    public int deleteCategory(int cid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            final String deleteQuery = "DELETE FROM Category WHERE cid=?";
            preparedStatement = connection.prepareStatement(deleteQuery);//2
            preparedStatement.setInt(1, cid);
            row = preparedStatement.executeUpdate();//3
            if (row > 0) {
                throw new ExceptionSMS("Student Delete Successfully");
            } else {
                throw new ExceptionSMS("Student Failed to Delete");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return 0;
    }
}
