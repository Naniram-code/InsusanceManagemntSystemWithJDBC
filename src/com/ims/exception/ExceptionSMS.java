package com.ims.exception;

import java.sql.SQLException;
//Create exceptionSMS class and extends SqlException classs
public class ExceptionSMS extends SQLException {
    public ExceptionSMS() { //default constructor
        super();
    }

    public   ExceptionSMS(String message) {
        super(message); //Parameterize constructor
    }
}

