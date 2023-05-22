package com.ims.configure.jdbcUtility;

import com.ims.exception.ExceptionSMS;
import com.ims.utility.Properties_Reader;

import java.sql.*;

public class ConnectionManager {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;

    public static Connection getConnection() throws ExceptionSMS {
        try {
            return DriverManager.getConnection(
                    Properties_Reader.readKey("url"),
                    Properties_Reader.readKey("username"),
                    Properties_Reader.readKey("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void closeconnection(Connection con, PreparedStatement ps) throws ExceptionSMS {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeconnection(ResultSet rs, PreparedStatement ps, Connection con) throws ExceptionSMS {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

}


