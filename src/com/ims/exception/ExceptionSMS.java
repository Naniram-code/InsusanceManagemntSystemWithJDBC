package com.ims.exception;

import java.sql.SQLException;

public class ExceptionSMS extends SQLException {
    public ExceptionSMS() {
        super();
    }

    public ExceptionSMS(String message) {
        super(message);
    }
}

