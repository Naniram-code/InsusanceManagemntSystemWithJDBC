package com.ims.admin.dao.Impl;


import com.ims.configure.ConnectionManager;
import com.ims.exception.ExceptionSMS;
import com.ims.admin.dao.UserDetailsDAO;
import com.ims.model.UserList;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.ims.query.QueryConstant.*;

public class UserDetailsDAOImpl implements UserDetailsDAO {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static Scanner sc = new Scanner(System.in);
    //static List<UserList> userList = new LinkedList<>();
    static int row = 0;

    @Override
    public String addUser(UserList userList) throws SQLException {

        try {
            connection = ConnectionManager.getConnection();//1 Connection
            preparedStatement = connection.prepareStatement(insertUser);//2 prepare Statement
            preparedStatement.setInt(1, userList.getUid());
            preparedStatement.setString(2, userList.getUname());
            preparedStatement.setString(3, userList.getAddress());
            preparedStatement.setLong(4, userList.getPhone());
            preparedStatement.setString(5, userList.getEmail());
            preparedStatement.setString(6, userList.getPassword());
            row = preparedStatement.executeUpdate();//3 Execute

            if (row > 0) {
                throw new ExceptionSMS("User Added Successfully");
            } else {
                throw new ExceptionSMS("User Failed to Add");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return null;
    }


    @Override
    public List<UserList> viewAllUserInfo() throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(readSelectUser);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println(
                                "UserID: " + resultSet.getString(1) + "   " +
                                "Name:" + resultSet.getString(2) + "   " +
                                "Address: " + resultSet.getString(3) + "   " +
                                "Contact no:" + resultSet.getString(4) + "   " +
                                "Email  :" + resultSet.getString(5));
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("View All Users Successfully");
            } else {
                throw new ExceptionSMS("Users  are not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return null;
    }


    @Override
    public int AuthenticationAdminaAndUser(String email, String password) throws SQLException {
        int role = 0;
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(USER_VALID_QUERY);//2
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();//3
            if (resultSet.next()) {
                role = resultSet.getInt("role_ID");
                System.out.println("User login:" + resultSet.getString("uname"));
            } else {
                throw new ExceptionSMS("User not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return role;
    }


    @Override
    public String getPassword(String email) throws SQLException {
        String password = null;
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(readPassword);//2
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();//3
            if (resultSet.next()) {
                password = resultSet.getString("password");
                throw new ExceptionSMS("Password getting Successfully");
            } else {
                throw new ExceptionSMS("Invalid email");

            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }
        return password;
    }


    @Override
    public int deleteUser(int pid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(deleteUser);//2
            preparedStatement.setInt(1, pid);
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

    @Override
    public boolean AuthenticationEmailandPassword(String email, String pass) throws SQLException {

        boolean flag = false;
        try {
            connection = ConnectionManager.getConnection();//1

            preparedStatement = connection.prepareStatement(USER_VALID_QUERY);//2

            preparedStatement.setString(1, email);

            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();//3

            if (resultSet.next())//move the cursor from Before First Record to FirstRecord
            {
                System.out.println(
                                "UserID: " + resultSet.getInt(1) + "   " +
                                "Name:" + resultSet.getString(2) + "   " +
                                "Address: " + resultSet.getString(3) + "   " +
                                "Contact no:" + resultSet.getString(4) + "   " +
                                "Email  :" + resultSet.getString(5));
                flag = true;
                throw new ExceptionSMS("User verified");
            } else {
                flag = false;
                throw new ExceptionSMS("User not found");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return flag;
    }

    public List<UserList> viewUser(int uid)throws SQLException {
        // TODO Auto-generated method stub

        List<UserList> addUser=new ArrayList<>();

        try {
            connection=ConnectionManager.getConnection();
            preparedStatement=connection.prepareStatement(readUser);
            preparedStatement.setInt(1, uid);
            resultSet=preparedStatement.executeQuery();


            while(resultSet.next())
            {
                int uiid=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String address=resultSet.getString(3);
                long phone=resultSet.getLong(4);
                String email=resultSet.getString(5);
                UserList user=new UserList(uiid,name,address,phone,email);

                addUser.add(user);
                row++;
         }

        if (row != 0) {
            throw new ExceptionSMS("View User Successfully");
        } else {
            throw new ExceptionSMS("Users  are not exit");
        }
    } catch (ExceptionSMS e) {
        System.out.println(e.getMessage());

    } finally {
        ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
    }

        return addUser;
}}

