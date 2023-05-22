package com.pms.admin.dao.Impl;


import com.pms.admin.dao.Impl.jdbcUtility.ConnectionManager;
import com.pms.admin.dao.Impl.jdbcUtility.ExceptionSMS;
import com.pms.admin.dao.UserDetailsDAO;
import com.pms.client.Customer.UserDashBoard;
import com.pms.client.admin.Admin;
import com.pms.model.UserList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.pms.query.QueryConstant.USER_VALID_QUERY;

public class UserDetailsDAOImpl implements UserDetailsDAO {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static Scanner sc = new Scanner(System.in);
    static List<UserList> studentList = new LinkedList<>();
    static int row = 0;

    @Override
    public String addUser(UserList userList) throws SQLException {

        try {
            connection = ConnectionManager.getConnection();//1
            final String sql = "INSERT INTO Users (uid,uname,address,phone,email,password) " +
                    "VALUES (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);//2
            preparedStatement.setInt(1, userList.getUid());
            preparedStatement.setString(2, userList.getUname());
            preparedStatement.setString(3, userList.getAddress());
            preparedStatement.setLong(4, userList.getPhone());
            preparedStatement.setString(5, userList.getEmail());
            preparedStatement.setString(6, userList.getPassword());
            row = preparedStatement.executeUpdate();//3

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

            final String readQuery = "SELECT * FROM Users";
            preparedStatement = connection.prepareStatement(readQuery);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println(
                                "UserID: " + resultSet.getString(1) +"   "+
                                "Name:" + resultSet.getString(2) +"   "+
                                "Address" + resultSet.getString(3) +"   "+
                                "Contact no:" + resultSet.getString(4) +"   "+
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

        return studentList;
    }


    @Override
    public int AuthenticationAdminaAndUser(String email,String password) throws SQLException {
        int role = 0;
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(USER_VALID_QUERY);//2
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();//3
            if(resultSet.next()) {

                role = resultSet.getInt("role_ID");
                System.out.println("User login:"+resultSet.getString("uname"));
                }
           else
           {
                throw new ExceptionSMS("User not found");
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
            String readQuery = "SELECT password FROM Users WHERE email = ?";
            preparedStatement = connection.prepareStatement(readQuery);//2
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();//3
            if (resultSet.next()) {
                password = resultSet.getString("password");
                throw new ExceptionSMS("Passwor geting Successfully");
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
            final String deleteQuery = "DELETE FROM Users WHERE uid=?";
            preparedStatement = connection.prepareStatement(deleteQuery);//2
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
    public boolean AuthenticationEmailandPassword(String email, String pass)throws SQLException {

        boolean flag=false;
        try {
            connection = ConnectionManager.getConnection();//1

            preparedStatement=connection.prepareStatement(USER_VALID_QUERY);//2

            preparedStatement.setString(1, email);

            preparedStatement.setString(2, pass);

            resultSet=preparedStatement.executeQuery();//3

            if(resultSet.next())//move the cursor from Before First Record to FirstRecord
            {         flag=true;
                      throw new ExceptionSMS("User verified");}
                 else
                  {     flag=false;
                        throw new ExceptionSMS("User not found");
                  }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return flag;
    }
        }


