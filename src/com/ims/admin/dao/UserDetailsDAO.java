package com.ims.admin.dao;

import com.ims.exception.ExceptionSMS;
import com.ims.model.UserList;

import java.sql.SQLException;
import java.util.List;

public interface UserDetailsDAO {
    public String addUser(UserList userList) throws ExceptionSMS, SQLException;

    public List<UserList> viewAllUserInfo() throws SQLException;

    public boolean AuthenticationEmailandPassword(String email,String password)throws SQLException;

    String getPassword(String email) throws SQLException;
    public int deleteUser(int pid) throws SQLException;
    public int AuthenticationAdminaAndUser(String email,String Password) throws SQLException;



}
