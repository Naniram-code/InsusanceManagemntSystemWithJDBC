package com.pms.admin.dao.Impl.jdbcUtility;

import java.sql.SQLException;

public class ExceptionSMS extends SQLException {
    public ExceptionSMS() {
        super();
    }

    public ExceptionSMS(String message) {
        super(message);
    }
}

