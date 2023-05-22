package com.pms.client.admin;

import com.pms.admin.dao.Impl.UserDetailsDAOImpl;
import com.pms.client.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    static UserDetailsDAOImpl userDAO = new UserDetailsDAOImpl();

    public static void adminPage() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================  ");
            System.out.println("                1)UserList                              ");
            System.out.println("                2)Category                              ");
            System.out.println("                3)SubCategory                           ");
            System.out.println("                4)Policy                                ");
            System.out.println("                5)Buyer's Policy Request                        ");
            System.out.println("                6)BackHomePage                                 ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    userDAO.viewAllUserInfo();
                    break;

                case 2:

                    Category.categoryDetails();

                    break;

                case 3:
                    SubCategory.subCategoryDetails();

                    break;

                case 4:
                    Policy.policyDetails();

                    break;
                case 5:
                   BuyerPolicyRequest.CustomerStatus();
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


