package com.pms.query;

public interface QueryConstant {
    public static String USER_REQUEST_POLICY="SELECT t1.uname AS `User Name`, t1.email, t1.phone As `Contact No`,\n" +
            "t2.Category, t2.SubCategory As `Sub Category`, t2.Name, t2.`Sum Assured`, t2.Premium\n" +
            "FROM Users t1\n" +
            "JOIN PolicyList t2 ON t1.uid = ? AND t2.ID = ?";
    public static String USER_INSERT_MY_POLICY_LIST="INSERT INTO MY_Policy_List  (`User Name`,`email`,`Contact No`,Category,`Sub Category`,`Name`,`Sum Assured`,`Premium`,`Status`) " +
            "VALUES (?,?,?,?,?,?,?,?,?)";

    public static final String ADMIN_readUSER_Status = "SELECT * FROM MY_Policy_List";
    public static final String Admin_Activate_User = "UPDATE MY_Policy_List SET `Status` = ? WHERE ID =?";
    public static final String Admin_Cancel_User = "UPDATE MY_Policy_List SET `Status` = ? WHERE ID =?";
    public  static String USER_VALID_QUERY="select * from Users where email=? and password=?";
}
