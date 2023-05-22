package com.ims.admin.dao.Impl;

import com.ims.admin.dao.CategoryDetailsDAO;
import com.ims.configure.ConnectionManager;
import com.ims.exception.ExceptionSMS;
import com.ims.model.CategoryDetail;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.ims.query.QueryConstant.*;

public class CategoryDAOImpl implements CategoryDetailsDAO {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static Scanner sc = new Scanner(System.in);
    int row = 0;


    @Override

    public String addCategory(CategoryDetail categoryDetail) throws SQLException {

        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(adnimAddCategory);//2
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
            preparedStatement = connection.prepareStatement(readCategory);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println("cid:" + resultSet.getInt(1) +
                        "  Category:" + resultSet.getString(2) +
                        "  Descriptions:" + resultSet.getString(3));
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("View All Category Successfully");
            } else {
                throw new ExceptionSMS("Category  not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return null;
    }


    @Override
    public int updateCategory(int ccid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1

            System.out.println("Enter 1 for  for update cname 2 for Description=");
            int ch = sc.nextInt();
            if (ch == 1) {
                preparedStatement = connection.prepareStatement(updateCategorysname);//2
                System.out.println("Enter New Category name for update=");
                String cna = sc.next();
                preparedStatement.setString(1, cna);
                preparedStatement.setInt(2, ccid);
            } else {
                preparedStatement = connection.prepareStatement(updateCategoryDes);//2
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

            preparedStatement = connection.prepareStatement(deleteCategory);//2
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
