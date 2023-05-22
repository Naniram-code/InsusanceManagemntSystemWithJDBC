package com.pms.client.admin;

import com.pms.admin.dao.Impl.UserDetailsDAOImpl;
import com.pms.admin.dao.Impl.UserStatusDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class BuyerPolicyRequest {
    static UserStatusDAOImpl userStatusDAO=new UserStatusDAOImpl();
    static UserDetailsDAOImpl userDAO = new UserDetailsDAOImpl();

    public static void CustomerStatus() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================  ");
            System.out.println("                1)ViewUsersStatus                                 ");
            System.out.println("                2)Activate                               ");
            System.out.println("                3)Cancel                                 ");
            System.out.println("                4)BackAdminPage                                 ");
            System.out.println("======================================================== ");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    userStatusDAO.ViewUsersStatus();
                    break;
                case 2:
                    System.out.print("Enter User Id for Activate= ");
                    int id = sc.nextInt();
                    userStatusDAO.ActivateRequest(id);
                    break;

                case 3:

                    System.out.println("Enter User ID for cancel= ");
                    int uid = sc.nextInt();
                    userStatusDAO.CancelUser(uid);
                    break;

                case 4:
                    Admin.adminPage();
                    break;
                default:
                    System.out.println("Choose 1 to 4 Between");

            }
        }
    }

}








