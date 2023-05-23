package com.ims.admin.dao;
import com.ims.model.UserList;

import java.sql.SQLException;
import java.util.List;

public interface UserStatusDAO {

    public List<UserList> createRequestPolicyList(int uid,int pid) throws SQLException;
    public List<UserList> UserActivate();
    public List<UserList> ViewUsersStatus() throws SQLException;

    public int ActivateRequest(int id) throws SQLException;
    public int CancelUser(int uid) throws SQLException;
    public void ViewPolicyHold(String email) throws SQLException;




}
