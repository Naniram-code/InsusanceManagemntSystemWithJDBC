package com.ims.query;

public interface QueryConstant {
    //read data from User Table and Policy list Table
    //public static final =data member=String= bez of interface  definition
     String USER_REQUEST_POLICY="SELECT t1.uname AS `User Name`, t1.email, t1.phone As `Contact No`,\n" +
            "t2.Category, t2.SubCategory As `Sub Category`, t2.Name, t2.`Sum Assured`, t2.Premium\n" +
            "FROM Users t1\n" +
            "JOIN PolicyList t2 ON t1.uid = ? AND t2.ID = ?";
    //user insert data to policy request
     String USER_INSERT_MY_POLICY_LIST="INSERT INTO MY_Policy_List  (`User Name`,`email`,`Contact No`,Category,`Sub Category`,`Name`,`Sum Assured`,`Premium`,`Status`) " +
            "VALUES (?,?,?,?,?,?,?,?,?)";
      //My Policy list query
     String ADMIN_readUSER_Status = "SELECT * FROM MY_Policy_List";
     String Admin_Activate_User = "UPDATE MY_Policy_List SET `Status` = ? WHERE ID =?";
     String Admin_Cancel_User = "UPDATE MY_Policy_List SET `Status` = ? WHERE ID =?";

     String Select_Active_User="select*from  MY_Policy_List where  ID=? and Status=?";

    //Category Query
     String adnimAddCategory = "INSERT INTO Category (`cname`,`Description`) VALUES (?,?)";
     String readCategory = "SELECT * FROM Category";
     String updateCategorysname = "UPDATE Category SET `cname` = ? WHERE cid =?";
     String updateCategoryDes = "UPDATE Category SET  `Description`  = ? WHERE cid =?";
     String deleteCategory = "DELETE FROM Category WHERE cid=?";


    //Policy Query
     String AddPolicy = "INSERT INTO PolicyList (Category,SubCategory,Name,`Sum Assured`,Premium,Description)" +
            " VALUES (?,?,?,?,?,?)";
     String displayCategoryAndSubCategory = "SELECT Category.cname AS CategoryName, " +
            "SubCategory.sbname AS SubCategoryName FROM Category \n" +
            "INNER JOIN SubCategory ON Category.cid = SubCategory.sbid;";
     String readPolicyList = "SELECT * FROM PolicyList";
     String updateName = "UPDATE PolicyList SET `Name` = ? WHERE ID =?";
    String updateSumAssured = "UPDATE PolicyList SET `Sum Assured` = ? WHERE ID =?";
     String updatePremium = "UPDATE PolicyList SET `Premium` = ? WHERE ID =?";
     String updateDescription = "UPDATE PolicyList SET  `Description`  = ? WHERE ID =?";
     String deletePolicy = "DELETE FROM `PolicyList` WHERE ID=?";

    //Sub Category query
     String InsertSubCategory = "INSERT INTO SubCategory (`sbname`,`Description`) VALUES (?,?)";
     String readSubCategory = "SELECT * FROM SubCategory";
     String updateSCsname = "UPDATE SubCategory SET `sbname` = ? WHERE sbid =?";
    String updateSCdes = "UPDATE SubCategory SET  `Description`  = ? WHERE sbid =?";
    String deleteSBC = "DELETE FROM SubCategory WHERE cid=?";
    // USERS QUERY
    String insertUser = "INSERT INTO Users (uid,uname,address,phone,email,password) " +
            "VALUES (?,?,?,?,?,?)";
    String readSelectUser = "SELECT * FROM Users";
    String USER_VALID_QUERY="select * from Users where email=? and password=?";
    String readPassword = "SELECT password FROM Users WHERE email = ?";
    String deleteUser = "DELETE FROM Users WHERE uid=?";
    String readUser = "SELECT * FROM Users Where uid=?";




}
