package com.pms.client;

import com.pms.admin.dao.Impl.UserDetailsDAOImpl;
import com.pms.admin.dao.Impl.UserStatusDAOImpl;
import com.pms.client.Customer.Home;
import com.pms.client.Customer.Registration;
import com.pms.client.Customer.UserDashBoard;
import com.pms.client.admin.Admin;


import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) throws SQLException {
        UserStatusDAOImpl userStatusDAO = new UserStatusDAOImpl();
        UserDetailsDAOImpl userDAO = new UserDetailsDAOImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================");
            System.out.println("                1)Home                                 ");
            System.out.println("                2)SignIn                               ");
            System.out.println("                3)SignOut                               ");
            System.out.println("                4)exit                                  ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Home.customermenu();
                    break;
                case 2:
                    System.out.println("Enter  login email");
                    String em = sc.next();
                    System.out.println("Enter  login password");
                    String psw = sc.next();
                     int uRole=userDAO.AuthenticationAdminaAndUser(em, psw);
                    if (uRole == 1)
                        Admin.adminPage();
                    else
                        UserDashBoard.UserDashBoardmenu();
                case 3:
                    Registration.CustomerClientmenu();
                    break;
                case 4:
                    System.out.println("*******************Thanks For Using Apps****************");
                    System.exit(0);

                default:
                    System.out.println("Enter 1 to 4 ");
            }

        }
    }
}






