package com.pms.admin.dao;

import com.pms.admin.dao.Impl.jdbcUtility.ExceptionSMS;
import com.pms.model.SubCategoryDetails;

import java.sql.SQLException;
import java.util.List;

public interface SubCategoryDetailsDAO {
    public String addSubCategory(SubCategoryDetails categoryDetail) throws ExceptionSMS, SQLException;
    List<SubCategoryDetails> viewSubCategory() throws SQLException;
    int updateSubCategory(int pid) throws SQLException;
    public int deleteSubCategory(int pid) throws SQLException;
}
