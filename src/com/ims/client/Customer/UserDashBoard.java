package com.ims.client.Customer;

import com.ims.admin.dao.Impl.*;
import com.ims.client.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class UserDashBoard {
    static PolicyDAOImpl policyDAOc = new PolicyDAOImpl();
    static SubCategoryDAOImpl subCategoryDAO = new SubCategoryDAOImpl();
    static UserStatusDAOImpl userstatusDAO = new UserStatusDAOImpl();
    static CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    public static void UserDashBoardmenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================================");
            System.out.println("                1)View Category                     ");
            System.out.println("                2)View SubCategory                  ");
            System.out.println("                3)view Policy                       ");
            System.out.println("                4)Request Policy                     ");
            System.out.println("                5)Policy Hold                       ");
            System.out.println("                6)BackHomePage                      ");
            System.out.println("=====================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    categoryDAO.viewCategory();
                    break;

                case 2:
                    subCategoryDAO.viewSubCategory();
                    break;

                case 3:
                    policyDAOc.viewPolicy();
                    break;


                case 4:
                    System.out.print("Enter  Your ID =");
                    int uid = sc.nextInt();
                    System.out.print("Enter Policy ID  =");
                    int pid = sc.nextInt();
                    userstatusDAO.createRequestPolicyList(uid, pid);

                    break;
                case 5:
                    System.out.print("Enter your email=");
                    String email = sc.next();
                    userstatusDAO.ViewPolicyHold(email);


                    break;

                case 6:
                    HomePage.main(null);
                    break;
                default:
                    System.out.println("Choose 1 to 6 Between");

            }
        }
    }

}


