package com.ims.client.admin;

import com.ims.admin.dao.Impl.PolicyDAOImpl;
import com.ims.model.PolicyDetails;

import java.sql.SQLException;
import java.util.Scanner;

public class Policy {


    static PolicyDAOImpl policyDAOp = new PolicyDAOImpl();

    public static void policyDetails() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================================== ");
            System.out.println("                1)AddPolicy                            ");
            System.out.println("                2)ViewPolicy                           ");
            System.out.println("                3)UpdatePolicy                         ");
            System.out.println("                4)Delete                               ");
            System.out.println("                5)BackAdminPage                               ");
            System.out.println("=======================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("***LIST OF CATEGORY***");
                    policyDAOp.displayCategory();
                    System.out.print("Choose Category  from List=");
                    String cat = sc.next();
                    System.out.println("***LIST OF SUB CATEGORY***");
                    policyDAOp.displaySubCategory();
                    System.out.print("Choose SubCategory from List=");
                    String subcat = sc.next();
                    System.out.print("Enter Policy Name=");
                    String pname = sc.next();
                    System.out.print("Enter Sum Assures=");
                    int  sa = sc.nextInt();
                    System.out.print("Enter Premium=");
                    int pre = sc.nextInt();
                    System.out.print("Enter Description=");
                    String des = sc.next();
                    PolicyDetails plist = new PolicyDetails(cat,subcat,pname,sa,pre,des);
                    policyDAOp.addPolicy(plist);
                    break;
                case 2:
                    policyDAOp.viewPolicy();
                    break;

                case 3:
                   System.out.print("Enter police ID to update =");
                    int pid = sc.nextInt();
                    policyDAOp.updatePolicy(pid);
                    break;
                case 4:

                   System.out.print("Enter police Id to delete =");
                    int did = sc.nextInt();
                    policyDAOp.deletePolicy(did);
                    break;
                case 5:
                    Admin.adminPage();
                    break;
                default:
                    System.out.println("Choose 1 to 5 Between");

            }
        }
    }
}








