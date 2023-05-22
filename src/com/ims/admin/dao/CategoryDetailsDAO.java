package com.ims.admin.dao;

import com.ims.exception.ExceptionSMS;
import com.ims.model.CategoryDetail;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDetailsDAO {

    public String addCategory(CategoryDetail categoryDetail) throws ExceptionSMS, SQLException;
    List<CategoryDetail> viewCategory() throws SQLException;
    int updateCategory(int pid) throws SQLException;
    public int deleteCategory(int pid) throws SQLException;
}
