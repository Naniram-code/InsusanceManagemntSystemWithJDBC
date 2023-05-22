package com.ims.admin.dao.Impl;

import com.ims.configure.ConnectionManager;
import com.ims.exception.ExceptionSMS;
import com.ims.admin.dao.UserStatusDAO;
import com.ims.model.UserList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.ims.query.QueryConstant.*;

public class UserStatusDAOImpl implements UserStatusDAO {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static Scanner sc = new Scanner(System.in);
    int row = 0;

    @Override
    public List<UserList> createRequestPolicyList(int uid, int pid) throws SQLException {
        List<UserList> requestList = new LinkedList<>();
        try {
            connection = ConnectionManager.getConnection();//1 connection
            preparedStatement = connection.prepareStatement(USER_REQUEST_POLICY);//2 Prepare statement
            preparedStatement.setInt(1, uid);
            preparedStatement.setInt(2, pid);
            resultSet = preparedStatement.executeQuery();//3 Execute
            while (resultSet.next()) {
                //Read User and Policy data according request (two table Data)
                String uName = resultSet.getString("User Name");
                String email = resultSet.getString("email");
                String cno = resultSet.getString("Contact No");
                String cat = resultSet.getString("Category");
                String subcat = resultSet.getString("Sub Category");
                String pname = resultSet.getString("Name");
                int sa = resultSet.getInt("Sum Assured");
                int pr = resultSet.getInt("Premium");

                preparedStatement = connection.prepareStatement(USER_INSERT_MY_POLICY_LIST);
                //request set
                preparedStatement.setString(1, uName);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, cno);
                preparedStatement.setString(4, cat);
                preparedStatement.setString(5, subcat);
                preparedStatement.setString(6, pname);
                preparedStatement.setInt(7, sa);
                preparedStatement.setInt(8, pr);
                preparedStatement.setString(9, "Requested");
                row = preparedStatement.executeUpdate();
            }

            if (row > 0) {
                throw new ExceptionSMS("Policy Request Successfully");
            } else {
                throw new ExceptionSMS("Request Fail try again");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }
        return requestList;
    }


    @Override
    public List<UserList> UserActivate() {
        return null;
    }

    @Override
    public List<UserList> ViewUsersStatus() throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(ADMIN_readUSER_Status);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println(//getting value from MY_Policy_LIst
                               "ID:"+resultSet.getInt(1) +" "+
                               "User Name:"+resultSet.getString(2) +" "+
                               "Email"+resultSet.getString(3) +" "+
                               "Contact no:"+resultSet.getString(4) +" "+
                               "Category:"+resultSet.getString(5) +" "+
                               "Sub Category:"+resultSet.getString(6) +" "+
                               "Policy name:"+resultSet.getString(7) +" "+
                               "Sum Assured:"+resultSet.getInt(8)+" "+
                                       "Premium:"+resultSet.getString(9)+" "+
                                     "Status:"+resultSet.getString(10));
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
    public int ActivateRequest(int uid) throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(Admin_Activate_User);//2

                preparedStatement.setString(1, "Active");
                preparedStatement.setInt(2, uid);
                row = preparedStatement.executeUpdate();//row update count//3
            if (row > 0) {
                throw new ExceptionSMS("User Activate  Successfully");
            } else {
                throw new ExceptionSMS("User Failed to Activate");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }

        return row;
    }

    @Override

        public int CancelUser(int uid) throws SQLException {
            try {
                connection = ConnectionManager.getConnection();//1
                preparedStatement = connection.prepareStatement(Admin_Cancel_User);//2
                preparedStatement.setString(1, "Cancel");
                preparedStatement.setInt(2, uid);
                row = preparedStatement.executeUpdate();//row update count//3
                if (row > 0) {
                    throw new ExceptionSMS("User Cancel  Successfully");
                } else {
                    throw new ExceptionSMS("User Failed to Cancel");
                }
            } catch (ExceptionSMS e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionManager.closeconnection(connection, preparedStatement);
            }

            return row;
        }

    @Override
    public void ViewPolicyHold(int uid)throws SQLException {
        try {
            connection = ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(Select_Active_User);//2
            preparedStatement.setInt(1, uid);
            preparedStatement.setString(2, "Active");
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                System.out.println(//getting value from MY_Policy_LIst
                                "ID:"+resultSet.getInt(1) +" "+
                                "User Name:"+resultSet.getString(2) +" "+
                                "Email: "+resultSet.getString(3) +" "+
                                "Contact no:"+resultSet.getString(4) +" "+
                                "Category:"+resultSet.getString(5) +" "+
                                "Sub Category:"+resultSet.getString(6) +" "+
                                "Policy name:"+resultSet.getString(7) +" "+
                                "Sum Assured:"+resultSet.getInt(8)+" "+
                                "Premium:"+resultSet.getString(9)+" "+
                                "Status:"+resultSet.getString(10));
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("Your policy hold  found Successfully");
            } else {
                throw new ExceptionSMS("Policy hold  not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }
    }

    }

