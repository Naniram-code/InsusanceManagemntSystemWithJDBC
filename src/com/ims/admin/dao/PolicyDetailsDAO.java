package com.ims.admin.dao;

import com.ims.exception.ExceptionSMS;
import com.ims.model.PolicyDetails;

import java.sql.SQLException;
import java.util.List;

public interface PolicyDetailsDAO {
    public String addPolicy(PolicyDetails policyDetailsl) throws ExceptionSMS, SQLException;
    List<PolicyDetails> viewPolicy() throws SQLException;
    int updatePolicy(int pid) throws SQLException;
    public int deletePolicy(int pid) throws SQLException;








}
